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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Information about the comment of an archived process instances.
 */
@JsonPropertyOrder({
        ArchivedProcessInstanceCommentAllOf.JSON_PROPERTY_ARCHIVED_DATE
})
@JsonTypeName("ArchivedProcessInstanceComment_allOf")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ArchivedProcessInstanceCommentAllOf implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ARCHIVED_DATE = "archivedDate";
    private String archivedDate;

    public ArchivedProcessInstanceCommentAllOf() {
    }

    public ArchivedProcessInstanceCommentAllOf archivedDate(String archivedDate) {

        this.archivedDate = archivedDate;
        return this;
    }

    /**
     * the date set when the process instance comment was archived
     * 
     * @return archivedDate
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getArchivedDate() {
        return archivedDate;
    }

    @JsonProperty(JSON_PROPERTY_ARCHIVED_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setArchivedDate(String archivedDate) {
        this.archivedDate = archivedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArchivedProcessInstanceCommentAllOf archivedProcessInstanceCommentAllOf = (ArchivedProcessInstanceCommentAllOf) o;
        return Objects.equals(this.archivedDate, archivedProcessInstanceCommentAllOf.archivedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archivedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArchivedProcessInstanceCommentAllOf {\n");
        sb.append("    archivedDate: ").append(toIndentedString(archivedDate)).append("\n");
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
