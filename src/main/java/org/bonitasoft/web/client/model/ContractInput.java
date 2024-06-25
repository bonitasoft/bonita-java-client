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
 * ContractInput
 */
@JsonPropertyOrder({
        ContractInput.JSON_PROPERTY_DESCRIPTION,
        ContractInput.JSON_PROPERTY_NAME,
        ContractInput.JSON_PROPERTY_MULTIPLE,
        ContractInput.JSON_PROPERTY_TYPE,
        ContractInput.JSON_PROPERTY_INPUTS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ContractInput implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_MULTIPLE = "multiple";
    private String multiple;

    public static final String JSON_PROPERTY_TYPE = "type";
    private ContractInputType type;

    public static final String JSON_PROPERTY_INPUTS = "inputs";
    private List<ContractInput> inputs = new ArrayList<>();

    public ContractInput() {
    }

    public ContractInput description(String description) {

        this.description = description;
        return this;
    }

    /**
     * input description
     * 
     * @return description
     **/
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

    public ContractInput name(String name) {

        this.name = name;
        return this;
    }

    /**
     * input name
     * 
     * @return name
     **/
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

    public ContractInput multiple(String multiple) {

        this.multiple = multiple;
        return this;
    }

    /**
     * true if input contains multiple values
     * 
     * @return multiple
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MULTIPLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMultiple() {
        return multiple;
    }

    @JsonProperty(JSON_PROPERTY_MULTIPLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public ContractInput type(ContractInputType type) {

        this.type = type;
        return this;
    }

    /**
     * Get type
     * 
     * @return type
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ContractInputType getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(ContractInputType type) {
        this.type = type;
    }

    public ContractInput inputs(List<ContractInput> inputs) {

        this.inputs = inputs;
        return this;
    }

    public ContractInput addInputsItem(ContractInput inputsItem) {
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
        ContractInput contractInput = (ContractInput) o;
        return Objects.equals(this.description, contractInput.description) &&
                Objects.equals(this.name, contractInput.name) &&
                Objects.equals(this.multiple, contractInput.multiple) &&
                Objects.equals(this.type, contractInput.type) &&
                Objects.equals(this.inputs, contractInput.inputs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, multiple, type, inputs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContractInput {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    multiple: ").append(toIndentedString(multiple)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
