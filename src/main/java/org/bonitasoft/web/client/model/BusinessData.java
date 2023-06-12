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
import java.util.HashMap;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Retrieve business data value. Depending on the object attribute loading policy, the API returns either the full object in JSON representation or the HATEOAS
 * links to the object attributes. Long attributes use a string representation added in 7.0.1 as a workaround for the JavaScript integer spectrum issue.
 * Representation of object attributes with an _always load_ policy: &#x60;&#x60;&#x60;json { \&quot;persistenceId\&quot;: _number_, // &lt;-- deprecated
 * \&quot;persistenceId_string\&quot;: \&quot;_number_\&quot; \&quot;persistenceVersion\&quot;: _number_, // &lt;-- deprecated
 * \&quot;persistenceVersion_string\&quot;: \&quot;_number_\&quot; \&quot;attributeName\&quot;:_attributeType_ ... } &#x60;&#x60;&#x60; The string
 * representation added in 7.0.1 for Long attributes is a workaround for the JavaScript integer spectrum issue. HATEOAS representation of object attribute with
 * a _load when needed_ policy: &#x60;&#x60;&#x60;json \&quot;links\&quot;:[ { \&quot;rel\&quot;:_string_ \&quot;href\&quot;:_uri_ } ] &#x60;&#x60;&#x60;
 */
@JsonPropertyOrder({
        BusinessData.JSON_PROPERTY_PERSISTENCE_ID_STRING,
        BusinessData.JSON_PROPERTY_PERSISTENCE_VERSION_STRING
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BusinessData extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PERSISTENCE_ID_STRING = "persistenceId_string";
    private String persistenceIdString;

    public static final String JSON_PROPERTY_PERSISTENCE_VERSION_STRING = "persistenceVersion_string";
    private String persistenceVersionString;

    public BusinessData() {

    }

    public BusinessData persistenceIdString(String persistenceIdString) {

        this.persistenceIdString = persistenceIdString;
        return this;
    }

    /**
     * Id of the business data object
     * 
     * @return persistenceIdString
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PERSISTENCE_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPersistenceIdString() {
        return persistenceIdString;
    }

    @JsonProperty(JSON_PROPERTY_PERSISTENCE_ID_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPersistenceIdString(String persistenceIdString) {
        this.persistenceIdString = persistenceIdString;
    }

    public BusinessData persistenceVersionString(String persistenceVersionString) {

        this.persistenceVersionString = persistenceVersionString;
        return this;
    }

    /**
     * Version of the business data object instance
     * 
     * @return persistenceVersionString
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PERSISTENCE_VERSION_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPersistenceVersionString() {
        return persistenceVersionString;
    }

    @JsonProperty(JSON_PROPERTY_PERSISTENCE_VERSION_STRING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPersistenceVersionString(String persistenceVersionString) {
        this.persistenceVersionString = persistenceVersionString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusinessData businessData = (BusinessData) o;
        return Objects.equals(this.persistenceIdString, businessData.persistenceIdString) &&
                Objects.equals(this.persistenceVersionString, businessData.persistenceVersionString) &&
                super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persistenceIdString, persistenceVersionString, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusinessData {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    persistenceIdString: ").append(toIndentedString(persistenceIdString)).append("\n");
        sb.append("    persistenceVersionString: ").append(toIndentedString(persistenceVersionString)).append("\n");
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
