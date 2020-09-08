/*
 * Copyright (C) 2019 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.security.SecurityContext;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;

import static com.bonitasoft.web.client.BonitaClientBuilder.bonitaClient;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
class BonitaClientBonitaHttpsTest {

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().dynamicPort().dynamicHttpsPort());
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void should_fail_with_Bonita_using_https_and_self_signed_certificate() {
        //given:
        BonitaClient bonitaClient = bonitaClient(mockServerHttpsUrl()).build();

        //when:
        final Throwable throwable = catchThrowable(() -> bonitaClient.login("user", "password"));

        //then:
        assertThat(throwable).as("client not supporting https self-signed certificate")
                .isExactlyInstanceOf(SSLHandshakeException.class)
                .hasMessageContaining("unable to find valid certification path to requested target");
    }

    @Test
    void should_not_fail_using_https_and_self_signed_certificate_when_disableCertificateCheck_is_true()
            throws UnauthorizedException, IOException {
        //given:
        BonitaClient bonitaClient = bonitaClient(mockServerHttpsUrl()).disableCertificateCheck(true).build();
        wireMockServer.stubFor(post(urlEqualTo("/loginservice"))
                .willReturn(aResponse().withStatus(200).withHeader("set-cookie", "cookie1=value1;")));
        wireMockServer.stubFor(get(urlEqualTo("/API/system/session/unusedId")).willReturn(aResponse().withStatus(200)));

        //when:
        bonitaClient.login("user", "password");

        //then:

    }

    // =================================================================================================================
    // UTILS
    // =================================================================================================================

    private String mockServerHttpsUrl() {
        return "https://localhost:" + wireMockServer.httpsPort();
    }

}
