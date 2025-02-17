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
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * InstanciateProcess429Response
 */
@JsonPropertyOrder({
        InstanciateProcess429Response.JSON_PROPERTY_CODE,
        InstanciateProcess429Response.JSON_PROPERTY_DESCRIPTION,
        InstanciateProcess429Response.JSON_PROPERTY_REASON_PHRASE
})
@JsonTypeName("instanciateProcess_429_response")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class InstanciateProcess429Response implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CODE = "code";
    private BigDecimal code;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_REASON_PHRASE = "reasonPhrase";
    private String reasonPhrase;

    public InstanciateProcess429Response() {
    }

    public InstanciateProcess429Response code(BigDecimal code) {

        this.code = code;
        return this;
    }

    /**
     * The response status code
     * 
     * @return code
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BigDecimal getCode() {
        return code;
    }

    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCode(BigDecimal code) {
        this.code = code;
    }

    public InstanciateProcess429Response description(String description) {

        this.description = description;
        return this;
    }

    /**
     * The status description
     * 
     * @return description
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDescription(String description) {
        this.description = description;
    }

    public InstanciateProcess429Response reasonPhrase(String reasonPhrase) {

        this.reasonPhrase = reasonPhrase;
        return this;
    }

    /**
     * The detail of the reason
     * 
     * @return reasonPhrase
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REASON_PHRASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    @JsonProperty(JSON_PROPERTY_REASON_PHRASE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstanciateProcess429Response instanciateProcess429Response = (InstanciateProcess429Response) o;
        return Objects.equals(this.code, instanciateProcess429Response.code) &&
                Objects.equals(this.description, instanciateProcess429Response.description) &&
                Objects.equals(this.reasonPhrase, instanciateProcess429Response.reasonPhrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description, reasonPhrase);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstanciateProcess429Response {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    reasonPhrase: ").append(toIndentedString(reasonPhrase)).append("\n");
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
