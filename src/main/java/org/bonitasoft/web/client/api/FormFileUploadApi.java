/** 
 * Copyright (C) 2024 BonitaSoft S.A.
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
package org.bonitasoft.web.client.api;

import java.io.File;

import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.FormFileUploadResponse;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.7.0")
public interface FormFileUploadApi extends ApiClient.Api {

    /**
     * Upload a file
     * Supports any type of files, used to upload a file before submitting a process or task form with a document in its contract
     * 
     * @param file (optional)
     * @return FormFileUploadResponse
     */
    @RequestLine("POST /API/formFileUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    FormFileUploadResponse formFileUpload(@Param("file") File file);

    /**
     * Upload a file
     * Similar to <code>formFileUpload</code> but it also returns the http response headers .
     * Supports any type of files, used to upload a file before submitting a process or task form with a document in its contract
     * 
     * @param file (optional)
     * @return A ApiResponse that wraps the response boyd and the http headers.
     */
    @RequestLine("POST /API/formFileUpload")
    @Headers({
            "Content-Type: multipart/form-data",
            "Accept: application/json,text/plain",
    })
    ApiResponse<FormFileUploadResponse> formFileUploadWithHttpInfo(@Param("file") File file);

}
