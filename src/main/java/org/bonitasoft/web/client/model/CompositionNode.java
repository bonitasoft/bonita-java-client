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
 * A node in the recursive composition tree of a business object type. Each node holds the qualified name of a composed business object type and the list of its
 * own composed children, allowing arbitrarily deep composition hierarchies to be expressed.
 */
@JsonPropertyOrder({
        CompositionNode.JSON_PROPERTY_QUALIFIED_NAME,
        CompositionNode.JSON_PROPERTY_COMPOSITIONS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class CompositionNode implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_QUALIFIED_NAME = "qualifiedName";
    @jakarta.annotation.Nonnull
    private String qualifiedName;

    public static final String JSON_PROPERTY_COMPOSITIONS = "compositions";
    @jakarta.annotation.Nonnull
    private List<CompositionNode> compositions = new ArrayList<>();

    public CompositionNode() {
    }

    public CompositionNode qualifiedName(@jakarta.annotation.Nonnull String qualifiedName) {

        this.qualifiedName = qualifiedName;
        return this;
    }

    /**
     * Fully qualified Java class name of the composed business object type.
     * 
     * @return qualifiedName
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_QUALIFIED_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getQualifiedName() {
        return qualifiedName;
    }

    @JsonProperty(JSON_PROPERTY_QUALIFIED_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setQualifiedName(@jakarta.annotation.Nonnull String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public CompositionNode compositions(@jakarta.annotation.Nonnull List<CompositionNode> compositions) {

        this.compositions = compositions;
        return this;
    }

    public CompositionNode addCompositionsItem(CompositionNode compositionsItem) {
        if (this.compositions == null) {
            this.compositions = new ArrayList<>();
        }
        this.compositions.add(compositionsItem);
        return this;
    }

    /**
     * Direct composition children of this object, or an empty list if none.
     * 
     * @return compositions
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_COMPOSITIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<CompositionNode> getCompositions() {
        return compositions;
    }

    @JsonProperty(JSON_PROPERTY_COMPOSITIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCompositions(@jakarta.annotation.Nonnull List<CompositionNode> compositions) {
        this.compositions = compositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompositionNode compositionNode = (CompositionNode) o;
        return Objects.equals(this.qualifiedName, compositionNode.qualifiedName) &&
                Objects.equals(this.compositions, compositionNode.compositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, compositions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CompositionNode {\n");
        sb.append("    qualifiedName: ").append(toIndentedString(qualifiedName)).append("\n");
        sb.append("    compositions: ").append(toIndentedString(compositions)).append("\n");
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
