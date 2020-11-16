package org.bonitasoft.web.client.feign.decoder;

import feign.Request;
import feign.RequestTemplate;
import feign.Response;
import org.bonitasoft.web.client.exception.ClientException;
import org.bonitasoft.web.client.exception.NotFoundException;
import org.bonitasoft.web.client.exception.UnauthorizedException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.bonitasoft.web.client.TestUtils.mockResponseBuilder;

@ExtendWith(MockitoExtension.class)
class BonitaErrorDecoderTest {

    @Test
    void should_decode_401() {
        // Given
        final BonitaErrorDecoder decoder = new BonitaErrorDecoder();
        final String reason = "Unauthorized";
        Response response = mockResponseBuilder().status(401).reason(reason).build();

        // When
        final Exception exception = decoder.decode("Api.getData", response);

        // Then
        assertThat(exception).isInstanceOf(UnauthorizedException.class).hasMessageContaining(reason);
    }

    @Test
    void should_decode_404() {
        // Given
        final BonitaErrorDecoder decoder = new BonitaErrorDecoder();
        Response response = mockResponseBuilder().status(404).build();

        // When
        final Exception exception = decoder.decode("Api.getData", response);

        // Then
        assertThat(exception).isInstanceOf(NotFoundException.class);
    }

    @Test
    void should_decode_other() {
        // Given
        final BonitaErrorDecoder decoder = new BonitaErrorDecoder();
        final String errorMessage = "error message";
        Response response = mockResponseBuilder().status(500).body(errorMessage, StandardCharsets.UTF_8).build();

        // When
        final Exception exception = decoder.decode("Api.getData", response);

        // Then
        assertThat(exception).isInstanceOf(ClientException.class).hasMessageContaining(errorMessage);
    }

}