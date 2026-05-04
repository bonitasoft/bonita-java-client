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
 * Session
 */
@JsonPropertyOrder({
        Session.JSON_PROPERTY_USER_ID,
        Session.JSON_PROPERTY_USER_NAME,
        Session.JSON_PROPERTY_SESSION_ID,
        Session.JSON_PROPERTY_CONF,
        Session.JSON_PROPERTY_IS_TECHNICAL_USER,
        Session.JSON_PROPERTY_IS_GUEST_USER,
        Session.JSON_PROPERTY_VERSION,
        Session.JSON_PROPERTY_COPYRIGHT
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_USER_ID = "user_id";
    @jakarta.annotation.Nullable
    private String userId;

    public static final String JSON_PROPERTY_USER_NAME = "user_name";
    @jakarta.annotation.Nullable
    private String userName;

    public static final String JSON_PROPERTY_SESSION_ID = "session_id";
    @jakarta.annotation.Nullable
    private String sessionId;

    public static final String JSON_PROPERTY_CONF = "conf";
    @jakarta.annotation.Nullable
    private String conf;

    public static final String JSON_PROPERTY_IS_TECHNICAL_USER = "is_technical_user";
    @jakarta.annotation.Nullable
    private Boolean isTechnicalUser;

    public static final String JSON_PROPERTY_IS_GUEST_USER = "is_guest_user";
    @jakarta.annotation.Nullable
    private Boolean isGuestUser;

    public static final String JSON_PROPERTY_VERSION = "version";
    @jakarta.annotation.Nullable
    private String version;

    public static final String JSON_PROPERTY_COPYRIGHT = "copyright";
    @jakarta.annotation.Nullable
    private String copyright;

    public Session() {
    }

    public Session userId(@jakarta.annotation.Nullable String userId) {

        this.userId = userId;
        return this;
    }

    /**
     * user id
     * 
     * @return userId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserId() {
        return userId;
    }

    @JsonProperty(JSON_PROPERTY_USER_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserId(@jakarta.annotation.Nullable String userId) {
        this.userId = userId;
    }

    public Session userName(@jakarta.annotation.Nullable String userName) {

        this.userName = userName;
        return this;
    }

    /**
     * user name
     * 
     * @return userName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUserName() {
        return userName;
    }

    @JsonProperty(JSON_PROPERTY_USER_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setUserName(@jakarta.annotation.Nullable String userName) {
        this.userName = userName;
    }

    public Session sessionId(@jakarta.annotation.Nullable String sessionId) {

        this.sessionId = sessionId;
        return this;
    }

    /**
     * the session id
     * 
     * @return sessionId
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SESSION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty(JSON_PROPERTY_SESSION_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSessionId(@jakarta.annotation.Nullable String sessionId) {
        this.sessionId = sessionId;
    }

    public Session conf(@jakarta.annotation.Nullable String conf) {

        this.conf = conf;
        return this;
    }

    /**
     * conf
     * 
     * @return conf
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getConf() {
        return conf;
    }

    @JsonProperty(JSON_PROPERTY_CONF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setConf(@jakarta.annotation.Nullable String conf) {
        this.conf = conf;
    }

    public Session isTechnicalUser(@jakarta.annotation.Nullable Boolean isTechnicalUser) {

        this.isTechnicalUser = isTechnicalUser;
        return this;
    }

    /**
     * is technical user: true|false
     * 
     * @return isTechnicalUser
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_TECHNICAL_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsTechnicalUser() {
        return isTechnicalUser;
    }

    @JsonProperty(JSON_PROPERTY_IS_TECHNICAL_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsTechnicalUser(@jakarta.annotation.Nullable Boolean isTechnicalUser) {
        this.isTechnicalUser = isTechnicalUser;
    }

    public Session isGuestUser(@jakarta.annotation.Nullable Boolean isGuestUser) {

        this.isGuestUser = isGuestUser;
        return this;
    }

    /**
     * is technical user: true|false
     * 
     * @return isGuestUser
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_IS_GUEST_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Boolean getIsGuestUser() {
        return isGuestUser;
    }

    @JsonProperty(JSON_PROPERTY_IS_GUEST_USER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIsGuestUser(@jakarta.annotation.Nullable Boolean isGuestUser) {
        this.isGuestUser = isGuestUser;
    }

    public Session version(@jakarta.annotation.Nullable String version) {

        this.version = version;
        return this;
    }

    /**
     * bonita version
     * 
     * @return version
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getVersion() {
        return version;
    }

    @JsonProperty(JSON_PROPERTY_VERSION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setVersion(@jakarta.annotation.Nullable String version) {
        this.version = version;
    }

    public Session copyright(@jakarta.annotation.Nullable String copyright) {

        this.copyright = copyright;
        return this;
    }

    /**
     * bonita copyright
     * 
     * @return copyright
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COPYRIGHT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCopyright() {
        return copyright;
    }

    @JsonProperty(JSON_PROPERTY_COPYRIGHT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCopyright(@jakarta.annotation.Nullable String copyright) {
        this.copyright = copyright;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session session = (Session) o;
        return Objects.equals(this.userId, session.userId) &&
                Objects.equals(this.userName, session.userName) &&
                Objects.equals(this.sessionId, session.sessionId) &&
                Objects.equals(this.conf, session.conf) &&
                Objects.equals(this.isTechnicalUser, session.isTechnicalUser) &&
                Objects.equals(this.isGuestUser, session.isGuestUser) &&
                Objects.equals(this.version, session.version) &&
                Objects.equals(this.copyright, session.copyright);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, sessionId, conf, isTechnicalUser, isGuestUser, version, copyright);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Session {\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    sessionId: ").append(toIndentedString(sessionId)).append("\n");
        sb.append("    conf: ").append(toIndentedString(conf)).append("\n");
        sb.append("    isTechnicalUser: ").append(toIndentedString(isTechnicalUser)).append("\n");
        sb.append("    isGuestUser: ").append(toIndentedString(isGuestUser)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    copyright: ").append(toIndentedString(copyright)).append("\n");
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
