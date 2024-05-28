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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * the current state of the activity
 */
public enum ActivityState {

    FAILED("failed"),

    INITIALIZING("initializing"),

    READY("ready"),

    EXECUTING("executing"),

    COMPLETING("completing"),

    COMPLETED("completed"),

    WAITING("waiting"),

    SKIPPED("skipped"),

    CANCELLED("cancelled"),

    ABORTED("aborted"),

    CANCELLING_SUBTASKS("cancelling subtasks"),

    ABORTING_ACTIVITY_WITH_BOUNDARY("aborting activity with boundary"),

    COMPLETING_ACTIVITY_WITH_BOUNDARY("completing activity with boundary");

    private String value;

    ActivityState(String value) {
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
    public static ActivityState fromValue(String value) {
        for (ActivityState b : ActivityState.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
