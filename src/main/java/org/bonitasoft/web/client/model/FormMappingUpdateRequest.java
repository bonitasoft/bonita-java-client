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
 * FormMappingUpdateRequest
 */
@JsonPropertyOrder({
        FormMappingUpdateRequest.JSON_PROPERTY_PAGE_ID,
        FormMappingUpdateRequest.JSON_PROPERTY_URL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class FormMappingUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_PAGE_ID = "pageId";
    private String pageId;

    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public FormMappingUpdateRequest() {
    }

    public FormMappingUpdateRequest pageId(String pageId) {

        this.pageId = pageId;
        return this;
    }

    /**
     * pageId of the FormMapping
     * 
     * @return pageId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPageId() {
        return pageId;
    }

    @JsonProperty(JSON_PROPERTY_PAGE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public FormMappingUpdateRequest url(String url) {

        this.url = url;
        return this;
    }

    /**
     * url of the FormMapping
     * 
     * @return url
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrl() {
        return url;
    }

    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormMappingUpdateRequest formMappingUpdateRequest = (FormMappingUpdateRequest) o;
        return Objects.equals(this.pageId, formMappingUpdateRequest.pageId) &&
                Objects.equals(this.url, formMappingUpdateRequest.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageId, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FormMappingUpdateRequest {\n");
        sb.append("    pageId: ").append(toIndentedString(pageId)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
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
