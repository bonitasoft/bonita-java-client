package org.bonitasoft.web.client.feign.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.bonitasoft.web.client.BonitaClient;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

import static feign.FeignException.errorStatus;
import static java.lang.System.lineSeparator;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;

public class BonitaErrorDecoder implements ErrorDecoder {

    private static Logger log = LoggerFactory.getLogger(BonitaClient.class);

    @Override
    public Exception decode(String methodKey, Response response) {
        final int responseStatus = response.status();
        if (responseStatus == 401) {
            return new UnauthorizedException(response.reason());
        }
        if (responseStatus == 404) {
            return new NotFoundException(response.reason());
        }
        if (responseStatus >= 400 && responseStatus <= 599) {
            String message = String.format("status: %s %s", responseStatus, response.reason());
            String details = getMessageDetails(response);
            return new ClientException(message + details);
        }
        return errorStatus(methodKey, response);
    }

    private String getMessageDetails(Response response) {
        try (final Response.Body responseBody = response.body()) {
            return Optional.ofNullable(responseBody).map(body -> {
                StringBuilder messageDetails = new StringBuilder(" :" + lineSeparator());
                try (InputStream inputStream = body.asInputStream()) {
                    String responseText = new BufferedReader(new InputStreamReader(inputStream, UTF_8))
                            .lines().collect(joining(lineSeparator()));
                    messageDetails.append(responseText);
                } catch (Exception e) {
                    log.error("Failed to read error response text.", e);
                }
                return messageDetails.toString();
            }).orElse("");
        } catch (IOException e) {
            log.error("Failed to read error response body", e);
            return "";
        }finally {
            response.close();
        }
    }
}
