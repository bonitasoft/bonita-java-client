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
 * A group of deployed processes that share the same &#x60;(name, displayName)&#x60; pair, with the list of their deployed versions. Returned by &#x60;GET
 * /API/bpm/processName&#x60;, which collapses the process deployment information into one entry per distinct name and display name.
 */
@JsonPropertyOrder({
        ProcessName.JSON_PROPERTY_NAME,
        ProcessName.JSON_PROPERTY_DISPLAY_NAME,
        ProcessName.JSON_PROPERTY_VERSIONS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class ProcessName implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    @jakarta.annotation.Nonnull
    private String name;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @jakarta.annotation.Nonnull
    private String displayName;

    public static final String JSON_PROPERTY_VERSIONS = "versions";
    @jakarta.annotation.Nonnull
    private List<String> versions = new ArrayList<>();

    public ProcessName() {
    }

    public ProcessName name(@jakarta.annotation.Nonnull String name) {

        this.name = name;
        return this;
    }

    /**
     * Technical name shared by every version in this group.
     * 
     * @return name
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setName(@jakarta.annotation.Nonnull String name) {
        this.name = name;
    }

    public ProcessName displayName(@jakarta.annotation.Nonnull String displayName) {

        this.displayName = displayName;
        return this;
    }

    /**
     * Human-readable name shared by every version in this group. Defaults to the process technical name when no display name was set at deployment.
     * 
     * @return displayName
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setDisplayName(@jakarta.annotation.Nonnull String displayName) {
        this.displayName = displayName;
    }

    public ProcessName versions(@jakarta.annotation.Nonnull List<String> versions) {

        this.versions = versions;
        return this;
    }

    public ProcessName addVersionsItem(String versionsItem) {
        if (this.versions == null) {
            this.versions = new ArrayList<>();
        }
        this.versions.add(versionsItem);
        return this;
    }

    /**
     * Deployed versions of the process sharing this name and display name. When an &#x60;activationState&#x60; filter is supplied, only the versions in that state
     * are listed. Always contains at least one entry.
     * 
     * @return versions
     */
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_VERSIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<String> getVersions() {
        return versions;
    }

    @JsonProperty(JSON_PROPERTY_VERSIONS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setVersions(@jakarta.annotation.Nonnull List<String> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessName processName = (ProcessName) o;
        return Objects.equals(this.name, processName.name) &&
                Objects.equals(this.displayName, processName.displayName) &&
                Objects.equals(this.versions, processName.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, versions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProcessName {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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
