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
 * the contract input type (string)
 */
public enum ContractInputType {

    TEXT("TEXT"),

    BOOLEAN("BOOLEAN"),

    DATE("DATE"),

    INTEGER("INTEGER"),

    DECIMAL("DECIMAL"),

    BYTE_ARRAY("BYTE_ARRAY"),

    FILE("FILE"),

    LONG("LONG"),

    LOCALDATE("LOCALDATE"),

    LOCALDATETIME("LOCALDATETIME"),

    OFFSETDATETIME("OFFSETDATETIME");

    private String value;

    ContractInputType(String value) {
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
    public static ContractInputType fromValue(String value) {
        for (ContractInputType b : ContractInputType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
