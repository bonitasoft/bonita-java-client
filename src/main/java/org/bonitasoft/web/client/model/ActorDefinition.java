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
 * Actor definition
 */
@JsonPropertyOrder({
        ActorDefinition.JSON_PROPERTY_NAME,
        ActorDefinition.JSON_PROPERTY_DESCRIPTION,
        ActorDefinition.JSON_PROPERTY_INITIATOR
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public class ActorDefinition implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_INITIATOR = "initiator";
    private Boolean initiator;

    public ActorDefinition() {
    }

    public ActorDefinition name(String name) {

        this.name = name;
        return this;
    }

    /**
     * the actor name
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

    public ActorDefinition description(String description) {

        this.description = description;
        return this;
    }

    /**
     * the actor description
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

    public ActorDefinition initiator(Boolean initiator) {

        this.initiator = initiator;
        return this;
    }

    /**
     * true, if this actor can start the process
     * 
     * @return initiator
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INITIATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getInitiator() {
        return initiator;
    }

    @JsonProperty(JSON_PROPERTY_INITIATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInitiator(Boolean initiator) {
        this.initiator = initiator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActorDefinition actorDefinition = (ActorDefinition) o;
        return Objects.equals(this.name, actorDefinition.name) &&
                Objects.equals(this.description, actorDefinition.description) &&
                Objects.equals(this.initiator, actorDefinition.initiator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, initiator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActorDefinition {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    initiator: ").append(toIndentedString(initiator)).append("\n");
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
