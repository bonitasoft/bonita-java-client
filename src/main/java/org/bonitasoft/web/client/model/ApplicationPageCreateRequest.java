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
 * ApplicationPageCreateRequest
 */
@JsonPropertyOrder({
        ApplicationPageCreateRequest.JSON_PROPERTY_TOKEN,
        ApplicationPageCreateRequest.JSON_PROPERTY_APPLICATION_ID,
        ApplicationPageCreateRequest.JSON_PROPERTY_PAGE_ID
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ApplicationPageCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_TOKEN = "token";
    private String token;

    public static final String JSON_PROPERTY_APPLICATION_ID = "applicationId";
    private String applicationId;

    public static final String JSON_PROPERTY_PAGE_ID = "pageId";
    private String pageId;

    public ApplicationPageCreateRequest() {
    }

    public ApplicationPageCreateRequest token(String token) {

        this.token = token;
        return this;
    }

    /**
     * token use to access the page using a URL : ../appName/pageToken/
     * 
     * @return token
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getToken() {
        return token;
    }

    @JsonProperty(JSON_PROPERTY_TOKEN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setToken(String token) {
        this.token = token;
    }

    public ApplicationPageCreateRequest applicationId(String applicationId) {

        this.applicationId = applicationId;
        return this;
    }

    /**
     * id of the application related to this page
     * 
     * @return applicationId
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_APPLICATION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getApplicationId() {
        return applicationId;
    }

    @JsonProperty(JSON_PROPERTY_APPLICATION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationPageCreateRequest pageId(String pageId) {

        this.pageId = pageId;
        return this;
    }

    /**
     * id of the custom page to display
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationPageCreateRequest applicationPageCreateRequest = (ApplicationPageCreateRequest) o;
        return Objects.equals(this.token, applicationPageCreateRequest.token) &&
                Objects.equals(this.applicationId, applicationPageCreateRequest.applicationId) &&
                Objects.equals(this.pageId, applicationPageCreateRequest.pageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, applicationId, pageId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApplicationPageCreateRequest {\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
        sb.append("    pageId: ").append(toIndentedString(pageId)).append("\n");
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
