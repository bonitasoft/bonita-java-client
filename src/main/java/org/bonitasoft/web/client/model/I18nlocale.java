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
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 */
@JsonPropertyOrder({
        I18nlocale.JSON_PROPERTY_NAME,
        I18nlocale.JSON_PROPERTY_LOCALE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class I18nlocale implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_LOCALE = "locale";
    private String locale;

    public I18nlocale() {
    }

    public I18nlocale name(String name) {

        this.name = name;
        return this;
    }

    /**
     * Name of the language
     * 
     * @return name
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public I18nlocale locale(String locale) {

        this.locale = locale;
        return this;
    }

    /**
     * code of the locale
     * 
     * @return locale
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_LOCALE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLocale() {
        return locale;
    }

    @JsonProperty(JSON_PROPERTY_LOCALE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        I18nlocale i18nlocale = (I18nlocale) o;
        return Objects.equals(this.name, i18nlocale.name) &&
                Objects.equals(this.locale, i18nlocale.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, locale);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class I18nlocale {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
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
