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
        PlatformLicense.JSON_PROPERTY_LICENSE_START_DATE,
        PlatformLicense.JSON_PROPERTY_DURATION,
        PlatformLicense.JSON_PROPERTY_LICENSE_EXPIRATION_DATE,
        PlatformLicense.JSON_PROPERTY_NUMBER_OF_C_P_U_CORES,
        PlatformLicense.JSON_PROPERTY_EDITION,
        PlatformLicense.JSON_PROPERTY_LICENSE_MODE,
        PlatformLicense.JSON_PROPERTY_REQUEST_KEY,
        PlatformLicense.JSON_PROPERTY_SUBSCRIPTION_START_PERIOD,
        PlatformLicense.JSON_PROPERTY_SUBSCRIPTION_END_PERIOD,
        PlatformLicense.JSON_PROPERTY_CASE_COUNTER_LIMIT,
        PlatformLicense.JSON_PROPERTY_CASE_COUNTER
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class PlatformLicense implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_LICENSE_START_DATE = "licenseStartDate";
    @jakarta.annotation.Nullable
    private String licenseStartDate;

    public static final String JSON_PROPERTY_DURATION = "duration";
    @jakarta.annotation.Nullable
    private String duration;

    public static final String JSON_PROPERTY_LICENSE_EXPIRATION_DATE = "licenseExpirationDate";
    @jakarta.annotation.Nullable
    private String licenseExpirationDate;

    public static final String JSON_PROPERTY_NUMBER_OF_C_P_U_CORES = "numberOfCPUCores";
    @jakarta.annotation.Nullable
    private String numberOfCPUCores;

    public static final String JSON_PROPERTY_EDITION = "edition";
    @jakarta.annotation.Nullable
    private String edition;

    public static final String JSON_PROPERTY_LICENSE_MODE = "licenseMode";
    @jakarta.annotation.Nullable
    private String licenseMode;

    public static final String JSON_PROPERTY_REQUEST_KEY = "requestKey";
    @jakarta.annotation.Nullable
    private String requestKey;

    public static final String JSON_PROPERTY_SUBSCRIPTION_START_PERIOD = "subscriptionStartPeriod";
    @jakarta.annotation.Nullable
    private String subscriptionStartPeriod;

    public static final String JSON_PROPERTY_SUBSCRIPTION_END_PERIOD = "subscriptionEndPeriod";
    @jakarta.annotation.Nullable
    private String subscriptionEndPeriod;

    public static final String JSON_PROPERTY_CASE_COUNTER_LIMIT = "caseCounterLimit";
    @jakarta.annotation.Nullable
    private Long caseCounterLimit;

    public static final String JSON_PROPERTY_CASE_COUNTER = "caseCounter";
    @jakarta.annotation.Nullable
    private Long caseCounter;

    public PlatformLicense() {
    }

    public PlatformLicense licenseStartDate(@jakarta.annotation.Nullable String licenseStartDate) {

        this.licenseStartDate = licenseStartDate;
        return this;
    }

    /**
     * date with format &#x60;yyyy-MM-dd&#x60; - first day (included) of license file validity
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
    public void setLicenseStartDate(@jakarta.annotation.Nullable String licenseStartDate) {
        this.licenseStartDate = licenseStartDate;
    }

    public PlatformLicense duration(@jakarta.annotation.Nullable String duration) {

        this.duration = duration;
        return this;
    }

    /**
     * number of days for license file validity
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
    public void setDuration(@jakarta.annotation.Nullable String duration) {
        this.duration = duration;
    }

    public PlatformLicense licenseExpirationDate(@jakarta.annotation.Nullable String licenseExpirationDate) {

        this.licenseExpirationDate = licenseExpirationDate;
        return this;
    }

    /**
     * date with format &#x60;yyyy-MM-dd&#x60; - last day (included) of license file validity
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
    public void setLicenseExpirationDate(@jakarta.annotation.Nullable String licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public PlatformLicense numberOfCPUCores(@jakarta.annotation.Nullable String numberOfCPUCores) {

        this.numberOfCPUCores = numberOfCPUCores;
        return this;
    }

    /**
     * number of CPUs
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
    public void setNumberOfCPUCores(@jakarta.annotation.Nullable String numberOfCPUCores) {
        this.numberOfCPUCores = numberOfCPUCores;
    }

    public PlatformLicense edition(@jakarta.annotation.Nullable String edition) {

        this.edition = edition;
        return this;
    }

    /**
     * name of the Bonita edition enabled by the license
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

    public PlatformLicense licenseMode(@jakarta.annotation.Nullable String licenseMode) {

        this.licenseMode = licenseMode;
        return this;
    }

    /**
     * available mode enabled by the license
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
    public void setLicenseMode(@jakarta.annotation.Nullable String licenseMode) {
        this.licenseMode = licenseMode;
    }

    public PlatformLicense requestKey(@jakarta.annotation.Nullable String requestKey) {

        this.requestKey = requestKey;
        return this;
    }

    /**
     * request key to use to generate a new license on the customer portal If you have a subscription that specifies case-counter licensing, additional fields are
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
    public void setRequestKey(@jakarta.annotation.Nullable String requestKey) {
        this.requestKey = requestKey;
    }

    public PlatformLicense subscriptionStartPeriod(@jakarta.annotation.Nullable String subscriptionStartPeriod) {

        this.subscriptionStartPeriod = subscriptionStartPeriod;
        return this;
    }

    /**
     * date with format &#x60;yyyy-MM-dd&#x60; - first day (included) of current period for number of process instances provisioned
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
    public void setSubscriptionStartPeriod(@jakarta.annotation.Nullable String subscriptionStartPeriod) {
        this.subscriptionStartPeriod = subscriptionStartPeriod;
    }

    public PlatformLicense subscriptionEndPeriod(@jakarta.annotation.Nullable String subscriptionEndPeriod) {

        this.subscriptionEndPeriod = subscriptionEndPeriod;
        return this;
    }

    /**
     * date with format &#x60;yyyy-MM-dd&#x60; - last day (included) of current period for number of process instances provisioned
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
    public void setSubscriptionEndPeriod(@jakarta.annotation.Nullable String subscriptionEndPeriod) {
        this.subscriptionEndPeriod = subscriptionEndPeriod;
    }

    public PlatformLicense caseCounterLimit(@jakarta.annotation.Nullable Long caseCounterLimit) {

        this.caseCounterLimit = caseCounterLimit;
        return this;
    }

    /**
     * number of process instances provisioned for period between &#x60;subscriptionStartPeriod&#x60; and &#x60;subscriptionEndPeriod&#x60;
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
    public void setCaseCounterLimit(@jakarta.annotation.Nullable Long caseCounterLimit) {
        this.caseCounterLimit = caseCounterLimit;
    }

    public PlatformLicense caseCounter(@jakarta.annotation.Nullable Long caseCounter) {

        this.caseCounter = caseCounter;
        return this;
    }

    /**
     * number of consumed process instances for period between &#x60;subscriptionStartPeriod&#x60; and &#x60;subscriptionEndPeriod&#x60;
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
    public void setCaseCounter(@jakarta.annotation.Nullable Long caseCounter) {
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
        PlatformLicense platformLicense = (PlatformLicense) o;
        return Objects.equals(this.licenseStartDate, platformLicense.licenseStartDate) &&
                Objects.equals(this.duration, platformLicense.duration) &&
                Objects.equals(this.licenseExpirationDate, platformLicense.licenseExpirationDate) &&
                Objects.equals(this.numberOfCPUCores, platformLicense.numberOfCPUCores) &&
                Objects.equals(this.edition, platformLicense.edition) &&
                Objects.equals(this.licenseMode, platformLicense.licenseMode) &&
                Objects.equals(this.requestKey, platformLicense.requestKey) &&
                Objects.equals(this.subscriptionStartPeriod, platformLicense.subscriptionStartPeriod) &&
                Objects.equals(this.subscriptionEndPeriod, platformLicense.subscriptionEndPeriod) &&
                Objects.equals(this.caseCounterLimit, platformLicense.caseCounterLimit) &&
                Objects.equals(this.caseCounter, platformLicense.caseCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseStartDate, duration, licenseExpirationDate, numberOfCPUCores, edition, licenseMode,
                requestKey, subscriptionStartPeriod, subscriptionEndPeriod, caseCounterLimit, caseCounter);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PlatformLicense {\n");
        sb.append("    licenseStartDate: ").append(toIndentedString(licenseStartDate)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    licenseExpirationDate: ").append(toIndentedString(licenseExpirationDate)).append("\n");
        sb.append("    numberOfCPUCores: ").append(toIndentedString(numberOfCPUCores)).append("\n");
        sb.append("    edition: ").append(toIndentedString(edition)).append("\n");
        sb.append("    licenseMode: ").append(toIndentedString(licenseMode)).append("\n");
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
