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
 * 
 */
@JsonPropertyOrder({
        CustomUserValue.JSON_PROPERTY_USER_ID,
        CustomUserValue.JSON_PROPERTY_VALUE,
        CustomUserValue.JSON_PROPERTY_DEFINITION_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class CustomUserValue implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_USER_ID = "userId";
    @jakarta.annotation.Nullable
    private String userId;

    public static final String JSON_PROPERTY_VALUE = "value";
    @jakarta.annotation.Nullable
    private String value;

    public static final String JSON_PROPERTY_DEFINITION_ID = "definitionId";
    @jakarta.annotation.Nullable
    private String definitionId;

    public CustomUserValue() {
    }

    public CustomUserValue userId(@jakarta.annotation.Nullable String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * user id
     * 
     * @return userId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserId() {
        return userId;
    }

    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserId(@jakarta.annotation.Nullable String userId) {
        this.userId = userId;
    }

    public CustomUserValue value(@jakarta.annotation.Nullable String value) {

        this.value = value;
        return this;
    }

    /**
     * definition value
     * 
     * @return value
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getValue() {
        return value;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setValue(@jakarta.annotation.Nullable String value) {
        this.value = value;
    }

    public CustomUserValue definitionId(@jakarta.annotation.Nullable String definitionId) {

        this.definitionId = definitionId;
        return this;
    }

    /**
     * definition id
     * 
     * @return definitionId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDefinitionId() {
        return definitionId;
    }

    @JsonProperty(JSON_PROPERTY_DEFINITION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDefinitionId(@jakarta.annotation.Nullable String definitionId) {
        this.definitionId = definitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomUserValue customUserValue = (CustomUserValue) o;
        return Objects.equals(this.userId, customUserValue.userId) &&
                Objects.equals(this.value, customUserValue.value) &&
                Objects.equals(this.definitionId, customUserValue.definitionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, value, definitionId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomUserValue {\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    definitionId: ").append(toIndentedString(definitionId)).append("\n");
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
