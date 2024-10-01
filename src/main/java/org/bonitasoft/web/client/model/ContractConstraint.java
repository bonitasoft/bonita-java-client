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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ContractConstraint
 */
@JsonPropertyOrder({
        ContractConstraint.JSON_PROPERTY_NAME,
        ContractConstraint.JSON_PROPERTY_EXPRESSION,
        ContractConstraint.JSON_PROPERTY_EXPLANATION,
        ContractConstraint.JSON_PROPERTY_INPUT_NAMES
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class ContractConstraint implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_EXPRESSION = "expression";
    private String expression;

    public static final String JSON_PROPERTY_EXPLANATION = "explanation";
    private String explanation;

    public static final String JSON_PROPERTY_INPUT_NAMES = "inputNames";
    private List<String> inputNames = new ArrayList<>();

    public ContractConstraint() {
    }

    public ContractConstraint name(String name) {

        this.name = name;
        return this;
    }

    /**
     * constraint name
     * 
     * @return name
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public ContractConstraint expression(String expression) {

        this.expression = expression;
        return this;
    }

    /**
     * constraint expression
     * 
     * @return expression
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPRESSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExpression() {
        return expression;
    }

    @JsonProperty(JSON_PROPERTY_EXPRESSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExpression(String expression) {
        this.expression = expression;
    }

    public ContractConstraint explanation(String explanation) {

        this.explanation = explanation;
        return this;
    }

    /**
     * constraint explanation
     * 
     * @return explanation
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPLANATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExplanation() {
        return explanation;
    }

    @JsonProperty(JSON_PROPERTY_EXPLANATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public ContractConstraint inputNames(List<String> inputNames) {

        this.inputNames = inputNames;
        return this;
    }

    public ContractConstraint addInputNamesItem(String inputNamesItem) {
        if (this.inputNames == null) {
            this.inputNames = new ArrayList<>();
        }
        this.inputNames.add(inputNamesItem);
        return this;
    }

    /**
     * Get inputNames
     * 
     * @return inputNames
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INPUT_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getInputNames() {
        return inputNames;
    }

    @JsonProperty(JSON_PROPERTY_INPUT_NAMES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInputNames(List<String> inputNames) {
        this.inputNames = inputNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContractConstraint contractConstraint = (ContractConstraint) o;
        return Objects.equals(this.name, contractConstraint.name) &&
                Objects.equals(this.expression, contractConstraint.expression) &&
                Objects.equals(this.explanation, contractConstraint.explanation) &&
                Objects.equals(this.inputNames, contractConstraint.inputNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expression, explanation, inputNames);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContractConstraint {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
        sb.append("    explanation: ").append(toIndentedString(explanation)).append("\n");
        sb.append("    inputNames: ").append(toIndentedString(inputNames)).append("\n");
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
