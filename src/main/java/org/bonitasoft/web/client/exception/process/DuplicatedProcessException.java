/** 
 * Copyright (C) 2023 BonitaSoft S.A.
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
package org.bonitasoft.web.client.exception.process;

import org.bonitasoft.web.client.exception.ClientException;

import lombok.Getter;

public class DuplicatedProcessException extends ClientException {

    private static final String MESSAGE_TEMPLATE = "Process '%s' in version '%s' already exists.";

    @Getter
    private final String processName;

    @Getter
    private final String processVersion;

    public DuplicatedProcessException(String message, String processName, String processVersion) {
        super(String.format(MESSAGE_TEMPLATE, processName, processVersion) + " " + message);
        this.processName = processName;
        this.processVersion = processVersion;
    }
}
