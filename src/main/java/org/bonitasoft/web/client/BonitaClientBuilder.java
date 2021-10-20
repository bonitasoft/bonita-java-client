package org.bonitasoft.web.client;

import org.bonitasoft.web.client.log.LogContentLevel;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

/** Builder class for {@link BonitaClient} */
public interface BonitaClientBuilder<T extends BonitaClientBuilder> {

    /**
     * Build and return a new {@link BonitaClient}
     *
     * @return
     */
    BonitaClient build();

    /**
     * Configure client connectTimeout in seconds
     *
     * @param connectTimeoutInSeconds
     * @return the current builder
     */
    T connectTimeoutInSeconds(int connectTimeoutInSeconds);

    /**
     * Configure client readTimeout in seconds
     *
     * @param readTimeoutInSeconds
     * @return the current builder
     */
    T readTimeoutInSeconds(int readTimeoutInSeconds);

    /**
     * Configure client writeTimeout in seconds
     *
     * @param writeTimeoutInSeconds
     * @return the current builder
     */
    T writeTimeoutInSeconds(int writeTimeoutInSeconds);
    
    /**
     * Configure whether the client should follow HTTP redirections.
     * Disabled by default.
     *
     * @param followRedirects
     * @return the current builder
     */
    T followRedirects(boolean followRedirects);

    /**
     * disable certificate check, trust all certs as default
     *
     * @param disableCertificateCheck
     * @return the current builder
     */
    T disableCertificateCheck(boolean disableCertificateCheck);

    /**
     * Set the underlying OkHttp client to use. If none specified, default internal OkHttp client will
     * be used.
     *
     * @param okHttpClient
     * @return the current builder
     */
    T okHttpClient(OkHttpClient okHttpClient);

    /**
     * Set the underlying ObjectMapper client to use. If none specified, default internal ObjectMapper
     * client will be used.
     *
     * @param objectMapper
     * @return the current builder
     */
    T objectMapper(ObjectMapper objectMapper);

    /**
     * Configure the client log level. Default level is {@link LogContentLevel#OFF}
     *
     * @param level
     * @return the current builder
     */
    T logContentLevel(LogContentLevel level);
}
