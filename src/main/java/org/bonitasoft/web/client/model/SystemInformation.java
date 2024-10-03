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
        SystemInformation.JSON_PROPERTY_LICENSE_START_DATE,
        SystemInformation.JSON_PROPERTY_DURATION,
        SystemInformation.JSON_PROPERTY_LICENSE_EXPIRATION_DATE,
        SystemInformation.JSON_PROPERTY_NUMBER_OF_C_P_U_CORES,
        SystemInformation.JSON_PROPERTY_EDITION,
        SystemInformation.JSON_PROPERTY_SUBSCRIPTION_TYPE,
        SystemInformation.JSON_PROPERTY_LICENSE_MODE,
        SystemInformation.JSON_PROPERTY_MANAGED_APPS_LIMIT,
        SystemInformation.JSON_PROPERTY_LICENSEE,
        SystemInformation.JSON_PROPERTY_CONTACT_INFO,
        SystemInformation.JSON_PROPERTY_EXPIRATION_DATE,
        SystemInformation.JSON_PROPERTY_ACTIVE_FEATURES,
        SystemInformation.JSON_PROPERTY_REQUEST_KEY,
        SystemInformation.JSON_PROPERTY_SUBSCRIPTION_START_PERIOD,
        SystemInformation.JSON_PROPERTY_SUBSCRIPTION_END_PERIOD,
        SystemInformation.JSON_PROPERTY_CASE_COUNTER_LIMIT,
        SystemInformation.JSON_PROPERTY_CASE_COUNTER
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.8.0")
public class SystemInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_LICENSE_START_DATE = "licenseStartDate";
    private String licenseStartDate;

    public static final String JSON_PROPERTY_DURATION = "duration";
    private String duration;

    public static final String JSON_PROPERTY_LICENSE_EXPIRATION_DATE = "licenseExpirationDate";
    private String licenseExpirationDate;

    public static final String JSON_PROPERTY_NUMBER_OF_C_P_U_CORES = "numberOfCPUCores";
    private String numberOfCPUCores;

    public static final String JSON_PROPERTY_EDITION = "edition";
    private String edition;

    public static final String JSON_PROPERTY_SUBSCRIPTION_TYPE = "subscriptionType";
    private String subscriptionType;

    public static final String JSON_PROPERTY_LICENSE_MODE = "licenseMode";
    private String licenseMode;

    public static final String JSON_PROPERTY_MANAGED_APPS_LIMIT = "managedAppsLimit";
    private Long managedAppsLimit;

    public static final String JSON_PROPERTY_LICENSEE = "licensee";
    private String licensee;

    public static final String JSON_PROPERTY_CONTACT_INFO = "contactInfo";
    private String contactInfo;

    public static final String JSON_PROPERTY_EXPIRATION_DATE = "expirationDate";
    private Long expirationDate;

    public static final String JSON_PROPERTY_ACTIVE_FEATURES = "activeFeatures";
    private String activeFeatures;

    public static final String JSON_PROPERTY_REQUEST_KEY = "requestKey";
    private String requestKey;

    public static final String JSON_PROPERTY_SUBSCRIPTION_START_PERIOD = "subscriptionStartPeriod";
    private String subscriptionStartPeriod;

    public static final String JSON_PROPERTY_SUBSCRIPTION_END_PERIOD = "subscriptionEndPeriod";
    private String subscriptionEndPeriod;

    public static final String JSON_PROPERTY_CASE_COUNTER_LIMIT = "caseCounterLimit";
    private Long caseCounterLimit;

    public static final String JSON_PROPERTY_CASE_COUNTER = "caseCounter";
    private Long caseCounter;

    public SystemInformation() {
    }

    public SystemInformation licenseStartDate(String licenseStartDate) {

        this.licenseStartDate = licenseStartDate;
        return this;
    }

    /**
     * date in milliseconds timestamp since Epoch - first day (included) of license file validity - Subscription editions only
     * 
     * @return licenseStartDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LICENSE_START_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLicenseStartDate() {
        return licenseStartDate;
    }

    @JsonProperty(JSON_PROPERTY_LICENSE_START_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLicenseStartDate(String licenseStartDate) {
        this.licenseStartDate = licenseStartDate;
    }

    public SystemInformation duration(String duration) {

        this.duration = duration;
        return this;
    }

    /**
     * number of days for license file validity - Subscription editions only
     * 
     * @return duration
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDuration() {
        return duration;
    }

    @JsonProperty(JSON_PROPERTY_DURATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public SystemInformation licenseExpirationDate(String licenseExpirationDate) {

        this.licenseExpirationDate = licenseExpirationDate;
        return this;
    }

    /**
     * date in milliseconds timestamp since Epoch - last day (included) of license file validity - Subscription editions only
     * 
     * @return licenseExpirationDate
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LICENSE_EXPIRATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    @JsonProperty(JSON_PROPERTY_LICENSE_EXPIRATION_DATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLicenseExpirationDate(String licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public SystemInformation numberOfCPUCores(String numberOfCPUCores) {

        this.numberOfCPUCores = numberOfCPUCores;
        return this;
    }

    /**
     * number of CPUs allowed by the license, if license mode is CPU-based - Subscription editions only
     * 
     * @return numberOfCPUCores
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NUMBER_OF_C_P_U_CORES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getNumberOfCPUCores() {
        return numberOfCPUCores;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_OF_C_P_U_CORES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setNumberOfCPUCores(String numberOfCPUCores) {
        this.numberOfCPUCores = numberOfCPUCores;
    }

    public SystemInformation edition(String edition) {

        this.edition = edition;
        return this;
    }

    /**
     * name of the Bonita edition enabled by the license - Community &amp; Subscription editions
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
    public void setEdition(String edition) {
        this.edition = edition;
    }

    public SystemInformation subscriptionType(String subscriptionType) {

        this.subscriptionType = subscriptionType;
        return this;
    }

    /**
     * type of the Subscription the customer has purchased with Bonitasoft - Subscription editions only
     * 
     * @return subscriptionType
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSubscriptionType() {
        return subscriptionType;
    }

    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public SystemInformation licenseMode(String licenseMode) {

        this.licenseMode = licenseMode;
        return this;
    }

    /**
     * available mode enabled by the license - Subscription editions only
     * 
     * @return licenseMode
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LICENSE_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLicenseMode() {
        return licenseMode;
    }

    @JsonProperty(JSON_PROPERTY_LICENSE_MODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLicenseMode(String licenseMode) {
        this.licenseMode = licenseMode;
    }

    public SystemInformation managedAppsLimit(Long managedAppsLimit) {

        this.managedAppsLimit = managedAppsLimit;
        return this;
    }

    /**
     * number of managed apps provisioned for in a Bonita Central environment - Subscription editions only
     * 
     * @return managedAppsLimit
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MANAGED_APPS_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getManagedAppsLimit() {
        return managedAppsLimit;
    }

    @JsonProperty(JSON_PROPERTY_MANAGED_APPS_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setManagedAppsLimit(Long managedAppsLimit) {
        this.managedAppsLimit = managedAppsLimit;
    }

    public SystemInformation licensee(String licensee) {

        this.licensee = licensee;
        return this;
    }

    /**
     * Owner of the license - Subscription editions only
     * 
     * @return licensee
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LICENSEE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLicensee() {
        return licensee;
    }

    @JsonProperty(JSON_PROPERTY_LICENSEE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLicensee(String licensee) {
        this.licensee = licensee;
    }

    public SystemInformation contactInfo(String contactInfo) {

        this.contactInfo = contactInfo;
        return this;
    }

    /**
     * E-mail address of the owner of the license - Subscription editions only
     * 
     * @return contactInfo
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTACT_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContactInfo() {
        return contactInfo;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_INFO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public SystemInformation expirationDate(Long expirationDate) {

        this.expirationDate = expirationDate;
        return this;
    }

    /**
     * License expiration date in milliseconds timestamp since Epoch - Subscription editions only
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
    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public SystemInformation activeFeatures(String activeFeatures) {

        this.activeFeatures = activeFeatures;
        return this;
    }

    /**
     * List of active features that the license allow access to (separated by comma) - Subscription editions only
     * 
     * @return activeFeatures
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ACTIVE_FEATURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getActiveFeatures() {
        return activeFeatures;
    }

    @JsonProperty(JSON_PROPERTY_ACTIVE_FEATURES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setActiveFeatures(String activeFeatures) {
        this.activeFeatures = activeFeatures;
    }

    public SystemInformation requestKey(String requestKey) {

        this.requestKey = requestKey;
        return this;
    }

    /**
     * request key to use to generate a new license on the customer portal. If you have a subscription that specifies case-counter licensing, additional fields are
     * present:
     * 
     * @return requestKey
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_REQUEST_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRequestKey() {
        return requestKey;
    }

    @JsonProperty(JSON_PROPERTY_REQUEST_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRequestKey(String requestKey) {
        this.requestKey = requestKey;
    }

    public SystemInformation subscriptionStartPeriod(String subscriptionStartPeriod) {

        this.subscriptionStartPeriod = subscriptionStartPeriod;
        return this;
    }

    /**
     * date in milliseconds timestamp since Epoch - first day (included) of current period for number of process instances provisioned - Subscription editions only
     * 
     * @return subscriptionStartPeriod
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_START_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSubscriptionStartPeriod() {
        return subscriptionStartPeriod;
    }

    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_START_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubscriptionStartPeriod(String subscriptionStartPeriod) {
        this.subscriptionStartPeriod = subscriptionStartPeriod;
    }

    public SystemInformation subscriptionEndPeriod(String subscriptionEndPeriod) {

        this.subscriptionEndPeriod = subscriptionEndPeriod;
        return this;
    }

    /**
     * date in milliseconds timestamp since Epoch - last day (included) of current period for number of process instances provisioned - Subscription editions only
     * 
     * @return subscriptionEndPeriod
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_END_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSubscriptionEndPeriod() {
        return subscriptionEndPeriod;
    }

    @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_END_PERIOD)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setSubscriptionEndPeriod(String subscriptionEndPeriod) {
        this.subscriptionEndPeriod = subscriptionEndPeriod;
    }

    public SystemInformation caseCounterLimit(Long caseCounterLimit) {

        this.caseCounterLimit = caseCounterLimit;
        return this;
    }

    /**
     * number of maximum process instances that can be started - Community &amp; Subscription editions
     * 
     * @return caseCounterLimit
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CASE_COUNTER_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getCaseCounterLimit() {
        return caseCounterLimit;
    }

    @JsonProperty(JSON_PROPERTY_CASE_COUNTER_LIMIT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCaseCounterLimit(Long caseCounterLimit) {
        this.caseCounterLimit = caseCounterLimit;
    }

    public SystemInformation caseCounter(Long caseCounter) {

        this.caseCounter = caseCounter;
        return this;
    }

    /**
     * number of consumed process instances - Community &amp; Subscription editions
     * 
     * @return caseCounter
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CASE_COUNTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Long getCaseCounter() {
        return caseCounter;
    }

    @JsonProperty(JSON_PROPERTY_CASE_COUNTER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCaseCounter(Long caseCounter) {
        this.caseCounter = caseCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SystemInformation systemInformation = (SystemInformation) o;
        return Objects.equals(this.licenseStartDate, systemInformation.licenseStartDate) &&
                Objects.equals(this.duration, systemInformation.duration) &&
                Objects.equals(this.licenseExpirationDate, systemInformation.licenseExpirationDate) &&
                Objects.equals(this.numberOfCPUCores, systemInformation.numberOfCPUCores) &&
                Objects.equals(this.edition, systemInformation.edition) &&
                Objects.equals(this.subscriptionType, systemInformation.subscriptionType) &&
                Objects.equals(this.licenseMode, systemInformation.licenseMode) &&
                Objects.equals(this.managedAppsLimit, systemInformation.managedAppsLimit) &&
                Objects.equals(this.licensee, systemInformation.licensee) &&
                Objects.equals(this.contactInfo, systemInformation.contactInfo) &&
                Objects.equals(this.expirationDate, systemInformation.expirationDate) &&
                Objects.equals(this.activeFeatures, systemInformation.activeFeatures) &&
                Objects.equals(this.requestKey, systemInformation.requestKey) &&
                Objects.equals(this.subscriptionStartPeriod, systemInformation.subscriptionStartPeriod) &&
                Objects.equals(this.subscriptionEndPeriod, systemInformation.subscriptionEndPeriod) &&
                Objects.equals(this.caseCounterLimit, systemInformation.caseCounterLimit) &&
                Objects.equals(this.caseCounter, systemInformation.caseCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseStartDate, duration, licenseExpirationDate, numberOfCPUCores, edition,
                subscriptionType, licenseMode, managedAppsLimit, licensee, contactInfo, expirationDate, activeFeatures,
                requestKey, subscriptionStartPeriod, subscriptionEndPeriod, caseCounterLimit, caseCounter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SystemInformation {\n");
        sb.append("    licenseStartDate: ").append(toIndentedString(licenseStartDate)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    licenseExpirationDate: ").append(toIndentedString(licenseExpirationDate)).append("\n");
        sb.append("    numberOfCPUCores: ").append(toIndentedString(numberOfCPUCores)).append("\n");
        sb.append("    edition: ").append(toIndentedString(edition)).append("\n");
        sb.append("    subscriptionType: ").append(toIndentedString(subscriptionType)).append("\n");
        sb.append("    licenseMode: ").append(toIndentedString(licenseMode)).append("\n");
        sb.append("    managedAppsLimit: ").append(toIndentedString(managedAppsLimit)).append("\n");
        sb.append("    licensee: ").append(toIndentedString(licensee)).append("\n");
        sb.append("    contactInfo: ").append(toIndentedString(contactInfo)).append("\n");
        sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
        sb.append("    activeFeatures: ").append(toIndentedString(activeFeatures)).append("\n");
        sb.append("    requestKey: ").append(toIndentedString(requestKey)).append("\n");
        sb.append("    subscriptionStartPeriod: ").append(toIndentedString(subscriptionStartPeriod)).append("\n");
        sb.append("    subscriptionEndPeriod: ").append(toIndentedString(subscriptionEndPeriod)).append("\n");
        sb.append("    caseCounterLimit: ").append(toIndentedString(caseCounterLimit)).append("\n");
        sb.append("    caseCounter: ").append(toIndentedString(caseCounter)).append("\n");
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
