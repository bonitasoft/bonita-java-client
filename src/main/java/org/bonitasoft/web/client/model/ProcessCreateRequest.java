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
package org.bonitasoft.web.client.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ProcessCreateRequest
 */
@JsonPropertyOrder({
        ProcessCreateRequest.JSON_PROPERTY_FILEUPLOAD
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ProcessCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_FILEUPLOAD = "fileupload";
    private String fileupload;

    public ProcessCreateRequest() {
    }

    public ProcessCreateRequest fileupload(String fileupload) {

        this.fileupload = fileupload;
        return this;
    }

    /**
     * the bar file to deploy (previously uploaded in tmp folder)
     * 
     * @return fileupload
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FILEUPLOAD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFileupload() {
        return fileupload;
    }

    @JsonProperty(JSON_PROPERTY_FILEUPLOAD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFileupload(String fileupload) {
        this.fileupload = fileupload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessCreateRequest processCreateRequest = (ProcessCreateRequest) o;
        return Objects.equals(this.fileupload, processCreateRequest.fileupload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileupload);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessCreateRequest {\n");
        sb.append("    fileupload: ").append(toIndentedString(fileupload)).append("\n");
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
