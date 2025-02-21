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
        Bdm.JSON_PROPERTY_ID,
        Bdm.JSON_PROPERTY_NAME,
        Bdm.JSON_PROPERTY_TYPE,
        Bdm.JSON_PROPERTY_STATE,
        Bdm.JSON_PROPERTY_LAST_UPDATED_BY,
        Bdm.JSON_PROPERTY_LAST_UPDATE_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class Bdm implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_TYPE = "type";
    private String type;

    public static final String JSON_PROPERTY_STATE = "state";
    private TenantResourceState state;

    public static final String JSON_PROPERTY_LAST_UPDATED_BY = "lastUpdatedBy";
    private String lastUpdatedBy = "-1";

    public static final String JSON_PROPERTY_LAST_UPDATE_DATE = "lastUpdateDate";
    private String lastUpdateDate;

    public Bdm() {
    }

    public Bdm id(String id) {

        this.id = id;
        return this;
    }

    /**
     * BDM id
     * 
     * @return id
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(String id) {
        this.id = id;
    }

    public Bdm name(String name) {

        this.name = name;
        return this;
    }

    /**
     * BDM name
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

    public Bdm type(String type) {

        this.type = type;
        return this;
    }

    /**
     * BDM type
     * 
     * @return type
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getType() {
        return type;
    }

    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setType(String type) {
        this.type = type;
    }

    public Bdm state(TenantResourceState state) {

        this.state = state;
        return this;
    }

    /**
     * Get state
     * 
     * @return state
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public TenantResourceState getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(TenantResourceState state) {
        this.state = state;
    }

    public Bdm lastUpdatedBy(String lastUpdatedBy) {

        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }

    /**
     * This value is always -1 because only the technical admin can install BDM.
     * 
     * @return lastUpdatedBy
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Bdm lastUpdateDate(String lastUpdateDate) {

        this.lastUpdateDate = lastUpdateDate;
        return this;
    }

    /**
     * Last date when the BDM was installed or updated.
     * 
     * @return lastUpdateDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    @JsonProperty(JSON_PROPERTY_LAST_UPDATE_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bdm bdm = (Bdm) o;
        return Objects.equals(this.id, bdm.id) &&
                Objects.equals(this.name, bdm.name) &&
                Objects.equals(this.type, bdm.type) &&
                Objects.equals(this.state, bdm.state) &&
                Objects.equals(this.lastUpdatedBy, bdm.lastUpdatedBy) &&
                Objects.equals(this.lastUpdateDate, bdm.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, state, lastUpdatedBy, lastUpdateDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Bdm {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    lastUpdatedBy: ").append(toIndentedString(lastUpdatedBy)).append("\n");
        sb.append("    lastUpdateDate: ").append(toIndentedString(lastUpdateDate)).append("\n");
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
