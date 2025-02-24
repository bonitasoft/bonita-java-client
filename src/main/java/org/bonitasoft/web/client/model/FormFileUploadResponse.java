/** 
 * Copyright (C) 2024-2023 BonitaSoft S.A.
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
package org.bonitasoft.web.client.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Form file upload response
 */
@JsonPropertyOrder({
        FormFileUploadResponse.JSON_PROPERTY_FILENAME,
        FormFileUploadResponse.JSON_PROPERTY_TEMP_PATH,
        FormFileUploadResponse.JSON_PROPERTY_CONTENT_TYPE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class FormFileUploadResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_FILENAME = "filename";
    @jakarta.annotation.Nullable
    private String filename;

    public static final String JSON_PROPERTY_TEMP_PATH = "tempPath";
    @jakarta.annotation.Nullable
    private String tempPath;

    public static final String JSON_PROPERTY_CONTENT_TYPE = "contentType";
    @jakarta.annotation.Nullable
    private String contentType;

    public FormFileUploadResponse() {
    }

    public FormFileUploadResponse filename(@jakarta.annotation.Nullable String filename) {

        this.filename = filename;
        return this;
    }

    /**
     * file name
     * 
     * @return filename
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILENAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFilename() {
        return filename;
    }

    @JsonProperty(JSON_PROPERTY_FILENAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFilename(@jakarta.annotation.Nullable String filename) {
        this.filename = filename;
    }

    public FormFileUploadResponse tempPath(@jakarta.annotation.Nullable String tempPath) {

        this.tempPath = tempPath;
        return this;
    }

    /**
     * temporary path of a file
     * 
     * @return tempPath
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TEMP_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTempPath() {
        return tempPath;
    }

    @JsonProperty(JSON_PROPERTY_TEMP_PATH)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTempPath(@jakarta.annotation.Nullable String tempPath) {
        this.tempPath = tempPath;
    }

    public FormFileUploadResponse contentType(@jakarta.annotation.Nullable String contentType) {

        this.contentType = contentType;
        return this;
    }

    /**
     * response content type
     * 
     * @return contentType
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContentType() {
        return contentType;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContentType(@jakarta.annotation.Nullable String contentType) {
        this.contentType = contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormFileUploadResponse formFileUploadResponse = (FormFileUploadResponse) o;
        return Objects.equals(this.filename, formFileUploadResponse.filename) &&
                Objects.equals(this.tempPath, formFileUploadResponse.tempPath) &&
                Objects.equals(this.contentType, formFileUploadResponse.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, tempPath, contentType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FormFileUploadResponse {\n");
        sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
        sb.append("    tempPath: ").append(toIndentedString(tempPath)).append("\n");
        sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
