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
 * BDMInstallRequest
 */
@JsonPropertyOrder({
        BDMInstallRequest.JSON_PROPERTY_FILE_UPLOAD
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class BDMInstallRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_FILE_UPLOAD = "fileUpload";
    @jakarta.annotation.Nullable
    private String fileUpload;

    public BDMInstallRequest() {
    }

    public BDMInstallRequest fileUpload(@jakarta.annotation.Nullable String fileUpload) {

        this.fileUpload = fileUpload;
        return this;
    }

    /**
     * the temporary file name once uploaded on the server
     * 
     * @return fileUpload
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILE_UPLOAD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFileUpload() {
        return fileUpload;
    }

    @JsonProperty(JSON_PROPERTY_FILE_UPLOAD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFileUpload(@jakarta.annotation.Nullable String fileUpload) {
        this.fileUpload = fileUpload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BDMInstallRequest bdMInstallRequest = (BDMInstallRequest) o;
        return Objects.equals(this.fileUpload, bdMInstallRequest.fileUpload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileUpload);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BDMInstallRequest {\n");
        sb.append("    fileUpload: ").append(toIndentedString(fileUpload)).append("\n");
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
