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
 * The process definition expressions
 */
@JsonPropertyOrder({
        DesignProcessDefinitionContext.JSON_PROPERTY_KEY,
        DesignProcessDefinitionContext.JSON_PROPERTY_EXPRESSION
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class DesignProcessDefinitionContext implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_KEY = "key";
    private String key;

    public static final String JSON_PROPERTY_EXPRESSION = "expression";
    private Expression expression;

    public DesignProcessDefinitionContext() {
    }

    public DesignProcessDefinitionContext key(String key) {

        this.key = key;
        return this;
    }

    /**
     * Get key
     * 
     * @return key
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getKey() {
        return key;
    }

    @JsonProperty(JSON_PROPERTY_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setKey(String key) {
        this.key = key;
    }

    public DesignProcessDefinitionContext expression(Expression expression) {

        this.expression = expression;
        return this;
    }

    /**
     * Get expression
     * 
     * @return expression
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPRESSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Expression getExpression() {
        return expression;
    }

    @JsonProperty(JSON_PROPERTY_EXPRESSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DesignProcessDefinitionContext designProcessDefinitionContext = (DesignProcessDefinitionContext) o;
        return Objects.equals(this.key, designProcessDefinitionContext.key) &&
                Objects.equals(this.expression, designProcessDefinitionContext.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, expression);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DesignProcessDefinitionContext {\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
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
