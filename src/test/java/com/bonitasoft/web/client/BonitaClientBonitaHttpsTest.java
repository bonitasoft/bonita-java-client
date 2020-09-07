/*
 * Copyright (C) 2019 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client;

import static com.bonitasoft.web.client.BonitaClientBuilder.bonitaClient;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.io.IOException;

import javax.net.ssl.SSLHandshakeException;

import com.bonitasoft.web.client.exception.UnauthorizedException;
import com.bonitasoft.web.client.internal.BonitaCookieInterceptor;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

public class BonitaClientBonitaHttpsTest {

    @Rule
    public WireMockRule wireMock = new WireMockRule(wireMockConfig().dynamicPort().dynamicHttpsPort(), false);

    @Mock
    BonitaCookieInterceptor bonitaCookieInterceptor;

    @Test
    public void should_fail_with_Bonita_using_https_and_self_signed_certificate() {
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
    public void should_not_fail_using_https_and_self_signed_certificate_when_disableCertificateCheck_is_true()
            throws UnauthorizedException, IOException {
        //given:
        BonitaClient bonitaClient = bonitaClient(mockServerHttpsUrl()).disableCertificateCheck(true).build();
        wireMock.stubFor(post(urlEqualTo("/loginservice"))
                .willReturn(aResponse().withStatus(200).withHeader("set-cookie", "cookie1=value1;")));
        wireMock.stubFor(get(urlEqualTo("/API/system/session/unusedId")).willReturn(aResponse().withStatus(200)));

        //when:
        bonitaClient.login("user", "password");

        //then:

    }

    // =================================================================================================================
    // UTILS
    // =================================================================================================================

    private String mockServerHttpsUrl() {
        return "https://localhost:" + wireMock.httpsPort();
    }

}
