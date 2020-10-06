package org.bonitasoft.web.client;

public interface BonitaClientBuilder {
    BonitaClient build();

    BonitaClientBuilder connectTimeoutInSeconds(int connectTimeoutInSeconds);

    BonitaClientBuilder readTimeoutInSeconds(int readTimeoutInSeconds);

    BonitaClientBuilder writeTimeoutInSeconds(int writeTimeoutInSeconds);

    BonitaClientBuilder disableCertificateCheck(boolean disableCertificateCheck);
}
