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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Contract
 */
@JsonPropertyOrder({
        Contract.JSON_PROPERTY_CONSTRAINTS,
        Contract.JSON_PROPERTY_INPUTS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_CONSTRAINTS = "constraints";
    private List<ContractConstraint> constraints = new ArrayList<>();

    public static final String JSON_PROPERTY_INPUTS = "inputs";
    private List<ContractInput> inputs = new ArrayList<>();

    public Contract() {
    }

    public Contract constraints(List<ContractConstraint> constraints) {

        this.constraints = constraints;
        return this;
    }

    public Contract addConstraintsItem(ContractConstraint constraintsItem) {
        if (this.constraints == null) {
            this.constraints = new ArrayList<>();
        }
        this.constraints.add(constraintsItem);
        return this;
    }

    /**
     * Get constraints
     * 
     * @return constraints
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONSTRAINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ContractConstraint> getConstraints() {
        return constraints;
    }

    @JsonProperty(JSON_PROPERTY_CONSTRAINTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConstraints(List<ContractConstraint> constraints) {
        this.constraints = constraints;
    }

    public Contract inputs(List<ContractInput> inputs) {

        this.inputs = inputs;
        return this;
    }

    public Contract addInputsItem(ContractInput inputsItem) {
        if (this.inputs == null) {
            this.inputs = new ArrayList<>();
        }
        this.inputs.add(inputsItem);
        return this;
    }

    /**
     * Get inputs
     * 
     * @return inputs
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INPUTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<ContractInput> getInputs() {
        return inputs;
    }

    @JsonProperty(JSON_PROPERTY_INPUTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInputs(List<ContractInput> inputs) {
        this.inputs = inputs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contract contract = (Contract) o;
        return Objects.equals(this.constraints, contract.constraints) &&
                Objects.equals(this.inputs, contract.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constraints, inputs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Contract {\n");
        sb.append("    constraints: ").append(toIndentedString(constraints)).append("\n");
        sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
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
