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
 * Bonita license
 */
@JsonPropertyOrder({
        License.JSON_PROPERTY_OWNER,
        License.JSON_PROPERTY_EDITION,
        License.JSON_PROPERTY_NB_CPU_CORES,
        License.JSON_PROPERTY_EXPIRATION_DATE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class License implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_OWNER = "owner";
    @jakarta.annotation.Nullable
    private String owner;

    public static final String JSON_PROPERTY_EDITION = "edition";
    @jakarta.annotation.Nullable
    private String edition;

    public static final String JSON_PROPERTY_NB_CPU_CORES = "nb_cpu_cores";
    @jakarta.annotation.Nullable
    private String nbCpuCores;

    public static final String JSON_PROPERTY_EXPIRATION_DATE = "expirationDate";
    @jakarta.annotation.Nullable
    private Long expirationDate;

    public License() {
    }

    public License owner(@jakarta.annotation.Nullable String owner) {

        this.owner = owner;
        return this;
    }

    /**
     * Owner of the license
     * 
     * @return owner
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OWNER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getOwner() {
        return owner;
    }

    @JsonProperty(JSON_PROPERTY_OWNER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setOwner(@jakarta.annotation.Nullable String owner) {
        this.owner = owner;
    }

    public License edition(@jakarta.annotation.Nullable String edition) {

        this.edition = edition;
        return this;
    }

    /**
     * name of the Bonita edition enabled by the license (Community,...)
     * 
     * @return edition
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EDITION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEdition() {
        return edition;
    }

    @JsonProperty(JSON_PROPERTY_EDITION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEdition(@jakarta.annotation.Nullable String edition) {
        this.edition = edition;
    }

    public License nbCpuCores(@jakarta.annotation.Nullable String nbCpuCores) {

        this.nbCpuCores = nbCpuCores;
        return this;
    }

    /**
     * number of CPUs
     * 
     * @return nbCpuCores
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NB_CPU_CORES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getNbCpuCores() {
        return nbCpuCores;
    }

    @JsonProperty(JSON_PROPERTY_NB_CPU_CORES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNbCpuCores(@jakarta.annotation.Nullable String nbCpuCores) {
        this.nbCpuCores = nbCpuCores;
    }

    public License expirationDate(@jakarta.annotation.Nullable Long expirationDate) {

        this.expirationDate = expirationDate;
        return this;
    }

    /**
     * License expiration date with format: &#x60;yyyy-MM-dd HH:mm:ss.SSS&#x60;
     * 
     * @return expirationDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPIRATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getExpirationDate() {
        return expirationDate;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExpirationDate(@jakarta.annotation.Nullable Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        License license = (License) o;
        return Objects.equals(this.owner, license.owner) &&
                Objects.equals(this.edition, license.edition) &&
                Objects.equals(this.nbCpuCores, license.nbCpuCores) &&
                Objects.equals(this.expirationDate, license.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, edition, nbCpuCores, expirationDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class License {\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    edition: ").append(toIndentedString(edition)).append("\n");
        sb.append("    nbCpuCores: ").append(toIndentedString(nbCpuCores)).append("\n");
        sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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
