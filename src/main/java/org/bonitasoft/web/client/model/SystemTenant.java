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
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 */
@JsonPropertyOrder({
        SystemTenant.JSON_PROPERTY_ID,
        SystemTenant.JSON_PROPERTY_PAUSED
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class SystemTenant implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_PAUSED = "paused";
    private Boolean paused;

    public SystemTenant() {
    }

    public SystemTenant id(String id) {

        this.id = id;
        return this;
    }

    /**
     * system tenant id
     * 
     * @return id
     **/
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

    public SystemTenant paused(Boolean paused) {

        this.paused = paused;
        return this;
    }

    /**
     * whether the system tenant is paused or not
     * 
     * @return paused
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PAUSED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getPaused() {
        return paused;
    }

    @JsonProperty(JSON_PROPERTY_PAUSED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemTenant systemTenant = (SystemTenant) o;
        return Objects.equals(this.id, systemTenant.id) &&
                Objects.equals(this.paused, systemTenant.paused);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paused);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SystemTenant {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    paused: ").append(toIndentedString(paused)).append("\n");
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
