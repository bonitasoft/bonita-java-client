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
package org.bonitasoft.web.client;

import org.bonitasoft.web.client.log.LogContentLevel;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Retryer;
import okhttp3.OkHttpClient;

/** Builder class for {@link BonitaClient} */
public interface BonitaClientBuilder<T extends BonitaClientBuilder<T>> {

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

    /**
     * Configure the client retry mechanism. Enabled by default.
     *
     * @see Retryer.Default
     * @param disableRetry
     * @return the current builder
     */
    T disableRetry(boolean disableRetry);


	/**
	 * Configure the client authentication method
	 * @param authBuilder
	 * @return
	 */
	T auth(AuthBuilder authBuilder);
}
