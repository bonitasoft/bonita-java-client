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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Since Bonita 7.13, theme management is deprecated
 * 
 * @deprecated
 */
@Deprecated
@JsonPropertyOrder({
        ThemeCreateRequest.JSON_PROPERTY_TYPE,
        ThemeCreateRequest.JSON_PROPERTY_ZIP_FILE_PATHPORTAL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ThemeCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * theme type
     */
    public enum TypeEnum {

        PORTAL("portal"),

        MOBILE("mobile");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type;

    public static final String JSON_PROPERTY_ZIP_FILE_PATHPORTAL = "zipFilePathportal";
    private String zipFilePathportal;

    public ThemeCreateRequest() {
    }

    public ThemeCreateRequest type(TypeEnum type) {

        this.type = type;
        return this;
    }

    /**
     * theme type
     * 
     * @return type
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(TypeEnum type) {
        this.type = type;
    }

    public ThemeCreateRequest zipFilePathportal(String zipFilePathportal) {

        this.zipFilePathportal = zipFilePathportal;
        return this;
    }

    /**
     * tmp zip file Path as uploaded to portal
     * 
     * @return zipFilePathportal
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ZIP_FILE_PATHPORTAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getZipFilePathportal() {
        return zipFilePathportal;
    }

    @JsonProperty(JSON_PROPERTY_ZIP_FILE_PATHPORTAL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setZipFilePathportal(String zipFilePathportal) {
        this.zipFilePathportal = zipFilePathportal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ThemeCreateRequest themeCreateRequest = (ThemeCreateRequest) o;
        return Objects.equals(this.type, themeCreateRequest.type) &&
                Objects.equals(this.zipFilePathportal, themeCreateRequest.zipFilePathportal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, zipFilePathportal);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ThemeCreateRequest {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    zipFilePathportal: ").append(toIndentedString(zipFilePathportal)).append("\n");
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
