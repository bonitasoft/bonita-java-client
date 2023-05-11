/** 
 * Copyright (C) 2022 BonitaSoft S.A.
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
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class MessageMessageContentValue implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_VALUE = "value";
    private String value;

    /**
     * Date types must be in the ISO-8601 format. When not set, the type is guessed using the value. Be careful as it can lead to type inconsistency in the target
     * process (eg: a java.lang.Long is expected and the guessed type is a java.lang.Integer)
     */
    public enum TypeEnum {

        LANG_STRING("java.lang.String"),

        LANG_BOOLEAN("java.lang.Boolean"),

        LANG_INTEGER("java.lang.Integer"),

        LANG_DOUBLE("java.lang.Double"),

        LANG_FLOAT("java.lang.Float"),

        LANG_LONG("java.lang.Long"),

        UTIL_DATE("java.util.Date"),

        TIME_LOCALDATE("java.time.LocalDate"),

        TIME_LOCALDATETIME("java.time.LocalDateTime"),

        TIME_OFFSETDATETIME("java.time.OffsetDateTime");

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

    public MessageMessageContentValue() {
    }

    public MessageMessageContentValue value(String value) {

        this.value = value;
        return this;
    }

    /**
     * @return value
     **/
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setValue(String value) {
        this.value = value;
    }

    public MessageMessageContentValue type(TypeEnum type) {

        this.type = type;
        return this;
    }

    /**
     * Date types must be in the ISO-8601 format. When not set, the type is guessed using the value. Be careful as it can lead to type inconsistency in the target
     * process (eg: a java.lang.Long is expected and the guessed type is a java.lang.Integer)
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
