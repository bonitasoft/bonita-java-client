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
        ProfessionalContactData.JSON_PROPERTY_ID,
        ProfessionalContactData.JSON_PROPERTY_FAX_NUMBER,
        ProfessionalContactData.JSON_PROPERTY_BUILDING,
        ProfessionalContactData.JSON_PROPERTY_PHONE_NUMBER,
        ProfessionalContactData.JSON_PROPERTY_WEBSITE,
        ProfessionalContactData.JSON_PROPERTY_ZIPCODE,
        ProfessionalContactData.JSON_PROPERTY_STATE,
        ProfessionalContactData.JSON_PROPERTY_CITY,
        ProfessionalContactData.JSON_PROPERTY_COUNTRY,
        ProfessionalContactData.JSON_PROPERTY_MOBILE_NUMBER,
        ProfessionalContactData.JSON_PROPERTY_ADDRESS,
        ProfessionalContactData.JSON_PROPERTY_ROOM,
        ProfessionalContactData.JSON_PROPERTY_EMAIL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0")
public class ProfessionalContactData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_FAX_NUMBER = "fax_number";
    private String faxNumber;

    public static final String JSON_PROPERTY_BUILDING = "building";
    private String building;

    public static final String JSON_PROPERTY_PHONE_NUMBER = "phone_number";
    private String phoneNumber;

    public static final String JSON_PROPERTY_WEBSITE = "website";
    private String website;

    public static final String JSON_PROPERTY_ZIPCODE = "zipcode";
    private String zipcode;

    public static final String JSON_PROPERTY_STATE = "state";
    private String state;

    public static final String JSON_PROPERTY_CITY = "city";
    private String city;

    public static final String JSON_PROPERTY_COUNTRY = "country";
    private String country;

    public static final String JSON_PROPERTY_MOBILE_NUMBER = "mobile_number";
    private String mobileNumber;

    public static final String JSON_PROPERTY_ADDRESS = "address";
    private String address;

    public static final String JSON_PROPERTY_ROOM = "room";
    private String room;

    public static final String JSON_PROPERTY_EMAIL = "email";
    private String email;

    public ProfessionalContactData() {
    }

    public ProfessionalContactData id(String id) {

        this.id = id;
        return this;
    }

    /**
     * user ID
     * 
     * @return id
     **/
    @jakarta.annotation.Nonnull
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setId(String id) {
        this.id = id;
    }

    public ProfessionalContactData faxNumber(String faxNumber) {

        this.faxNumber = faxNumber;
        return this;
    }

    /**
     * fax number
     * 
     * @return faxNumber
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_FAX_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getFaxNumber() {
        return faxNumber;
    }

    @JsonProperty(JSON_PROPERTY_FAX_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public ProfessionalContactData building(String building) {

        this.building = building;
        return this;
    }

    /**
     * building
     * 
     * @return building
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_BUILDING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getBuilding() {
        return building;
    }

    @JsonProperty(JSON_PROPERTY_BUILDING)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBuilding(String building) {
        this.building = building;
    }

    public ProfessionalContactData phoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * phone number
     * 
     * @return phoneNumber
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty(JSON_PROPERTY_PHONE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ProfessionalContactData website(String website) {

        this.website = website;
        return this;
    }

    /**
     * website
     * 
     * @return website
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_WEBSITE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getWebsite() {
        return website;
    }

    @JsonProperty(JSON_PROPERTY_WEBSITE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setWebsite(String website) {
        this.website = website;
    }

    public ProfessionalContactData zipcode(String zipcode) {

        this.zipcode = zipcode;
        return this;
    }

    /**
     * zipcode
     * 
     * @return zipcode
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ZIPCODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getZipcode() {
        return zipcode;
    }

    @JsonProperty(JSON_PROPERTY_ZIPCODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public ProfessionalContactData state(String state) {

        this.state = state;
        return this;
    }

    /**
     * state
     * 
     * @return state
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getState() {
        return state;
    }

    @JsonProperty(JSON_PROPERTY_STATE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setState(String state) {
        this.state = state;
    }

    public ProfessionalContactData city(String city) {

        this.city = city;
        return this;
    }

    /**
     * city
     * 
     * @return city
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCity() {
        return city;
    }

    @JsonProperty(JSON_PROPERTY_CITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCity(String city) {
        this.city = city;
    }

    public ProfessionalContactData country(String country) {

        this.country = country;
        return this;
    }

    /**
     * country
     * 
     * @return country
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COUNTRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCountry() {
        return country;
    }

    @JsonProperty(JSON_PROPERTY_COUNTRY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCountry(String country) {
        this.country = country;
    }

    public ProfessionalContactData mobileNumber(String mobileNumber) {

        this.mobileNumber = mobileNumber;
        return this;
    }

    /**
     * mobile phone number
     * 
     * @return mobileNumber
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MOBILE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMobileNumber() {
        return mobileNumber;
    }

    @JsonProperty(JSON_PROPERTY_MOBILE_NUMBER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public ProfessionalContactData address(String address) {

        this.address = address;
        return this;
    }

    /**
     * address
     * 
     * @return address
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAddress() {
        return address;
    }

    @JsonProperty(JSON_PROPERTY_ADDRESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAddress(String address) {
        this.address = address;
    }

    public ProfessionalContactData room(String room) {

        this.room = room;
        return this;
    }

    /**
     * room
     * 
     * @return room
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ROOM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRoom() {
        return room;
    }

    @JsonProperty(JSON_PROPERTY_ROOM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRoom(String room) {
        this.room = room;
    }

    public ProfessionalContactData email(String email) {

        this.email = email;
        return this;
    }

    /**
     * email
     * 
     * @return email
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEmail() {
        return email;
    }

    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfessionalContactData professionalContactData = (ProfessionalContactData) o;
        return Objects.equals(this.id, professionalContactData.id) &&
                Objects.equals(this.faxNumber, professionalContactData.faxNumber) &&
                Objects.equals(this.building, professionalContactData.building) &&
                Objects.equals(this.phoneNumber, professionalContactData.phoneNumber) &&
                Objects.equals(this.website, professionalContactData.website) &&
                Objects.equals(this.zipcode, professionalContactData.zipcode) &&
                Objects.equals(this.state, professionalContactData.state) &&
                Objects.equals(this.city, professionalContactData.city) &&
                Objects.equals(this.country, professionalContactData.country) &&
                Objects.equals(this.mobileNumber, professionalContactData.mobileNumber) &&
                Objects.equals(this.address, professionalContactData.address) &&
                Objects.equals(this.room, professionalContactData.room) &&
                Objects.equals(this.email, professionalContactData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faxNumber, building, phoneNumber, website, zipcode, state, city, country, mobileNumber,
                address, room, email);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProfessionalContactData {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    faxNumber: ").append(toIndentedString(faxNumber)).append("\n");
        sb.append("    building: ").append(toIndentedString(building)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    website: ").append(toIndentedString(website)).append("\n");
        sb.append("    zipcode: ").append(toIndentedString(zipcode)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    room: ").append(toIndentedString(room)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
