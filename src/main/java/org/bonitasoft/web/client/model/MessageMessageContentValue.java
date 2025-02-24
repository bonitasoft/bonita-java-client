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
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * MessageMessageContentValue
 */
@JsonPropertyOrder({
        MessageMessageContentValue.JSON_PROPERTY_VALUE,
        MessageMessageContentValue.JSON_PROPERTY_TYPE
})
@JsonTypeName("Message_messageContent_value")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class MessageMessageContentValue implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_VALUE = "value";
    @jakarta.annotation.Nonnull
    private String value;

    /**
     * Date types must be in the ISO-8601 format. When not set, the type is guessed using the value. Be careful as it can lead to type inconsistency in the target
     * process (eg: a java.lang.Long is expected and the guessed type is a java.lang.Integer)
     */
    public enum TypeEnum {

        JAVA_LANG_STRING(String.valueOf("java.lang.String")),

        JAVA_LANG_BOOLEAN(String.valueOf("java.lang.Boolean")),

        JAVA_LANG_INTEGER(String.valueOf("java.lang.Integer")),

        JAVA_LANG_DOUBLE(String.valueOf("java.lang.Double")),

        JAVA_LANG_FLOAT(String.valueOf("java.lang.Float")),

        JAVA_LANG_LONG(String.valueOf("java.lang.Long")),

        JAVA_UTIL_DATE(String.valueOf("java.util.Date")),

        JAVA_TIME_LOCAL_DATE(String.valueOf("java.time.LocalDate")),

        JAVA_TIME_LOCAL_DATE_TIME(String.valueOf("java.time.LocalDateTime")),

        JAVA_TIME_OFFSET_DATE_TIME(String.valueOf("java.time.OffsetDateTime"));

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
    @jakarta.annotation.Nullable
    private TypeEnum type;

    public MessageMessageContentValue() {
    }

    public MessageMessageContentValue value(@jakarta.annotation.Nonnull String value) {

        this.value = value;
        return this;
    }

    /**
     * @return value
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setValue(@jakarta.annotation.Nonnull String value) {
        this.value = value;
    }

    public MessageMessageContentValue type(@jakarta.annotation.Nullable TypeEnum type) {

        this.type = type;
        return this;
    }

    /**
     * Date types must be in the ISO-8601 format. When not set, the type is guessed using the value. Be careful as it can lead to type inconsistency in the target
     * process (eg: a java.lang.Long is expected and the guessed type is a java.lang.Integer)
     * 
     * @return type
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TypeEnum getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(@jakarta.annotation.Nullable TypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MessageMessageContentValue messageMessageContentValue = (MessageMessageContentValue) o;
        return Objects.equals(this.value, messageMessageContentValue.value) &&
                Objects.equals(this.type, messageMessageContentValue.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MessageMessageContentValue {\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
