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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Lifecycle status of a delegation rule, derived at query time from the rule&#39;s &#x60;startDate&#x60; / &#x60;endDate&#x60; compared against the current
 * time. There is no stored activation flag. - &#x60;scheduled&#x60;: &#x60;startDate&#x60; is in the future. The delegate does not yet have access. -
 * &#x60;active&#x60;: the current time is within &#x60;[startDate, endDate]&#x60;. The delegate has access. - &#x60;expired&#x60;: &#x60;endDate&#x60; is in
 * the past. The delegate no longer has access. Serialized in lowercase.
 */
public enum DelegationStatus {

    SCHEDULED("scheduled"),

    ACTIVE("active"),

    EXPIRED("expired");

    private String value;

    DelegationStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static DelegationStatus fromValue(String value) {
        for (DelegationStatus b : DelegationStatus.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
