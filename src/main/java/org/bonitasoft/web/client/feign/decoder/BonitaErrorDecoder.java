/** 
 * Copyright (C) 2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.feign.decoder;

import static feign.FeignException.errorStatus;
import static java.lang.String.format;
import static java.lang.System.lineSeparator;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.UnauthorizedException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BonitaErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        final int responseStatus = response.status();
        String message = format("status: %s %s %s", responseStatus, response.reason(), System.lineSeparator());
        String details = getMessageDetails(response);
        String errorMessage = message + details;

        if (responseStatus == 401) {
            return new UnauthorizedException(errorMessage);
        }
        if (responseStatus == 404) {
            return new NotFoundException(errorMessage);
        }
        if (responseStatus >= 400 && responseStatus <= 599) {
            return new ClientException(errorMessage);
        }
        return errorStatus(methodKey, response);
    }

    private String getMessageDetails(Response response) {
        try (final Response.Body responseBody = response.body()) {
            return Optional.ofNullable(responseBody)
                    .map(
                            body -> {
                                StringBuilder messageDetails = new StringBuilder(" :" + lineSeparator());
                                try (InputStream inputStream = body.asInputStream()) {
                                    String responseText = new BufferedReader(new InputStreamReader(inputStream, UTF_8))
                                            .lines()
                                            .collect(joining(lineSeparator()));
                                    messageDetails.append(responseText);
                                } catch (Exception e) {
                                    log.error("Failed to read error response text.", e);
                                }
                                return messageDetails.toString();
                            })
                    .orElse("");
        } catch (IOException e) {
            log.error("Failed to read error response body", e);
            return "";
        } finally {
            response.close();
        }
    }
}
