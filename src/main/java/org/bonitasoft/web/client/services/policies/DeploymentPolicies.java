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
package org.bonitasoft.web.client.services.policies;

import lombok.AllArgsConstructor;
import lombok.Data;

/** @author Emmanuel Duchastenier */
@Data
@AllArgsConstructor
public class DeploymentPolicies {

    public static final DeploymentPolicies ProductionDefaults = new DeploymentPolicies(
            "PRODUCTION",
            OrganizationImportPolicy.IGNORE_DUPLICATES,
            ProcessImportPolicy.IGNORE_DUPLICATES,
            ProfileImportPolicy.IGNORE_IF_ANY_EXISTS,
            ApplicationImportPolicy.REPLACE_DUPLICATES);

    public static final DeploymentPolicies DevelopmentDefaults = new DeploymentPolicies(
            "DEVELOPMENT",
            OrganizationImportPolicy.MERGE_DUPLICATES,
            ProcessImportPolicy.REPLACE_DUPLICATES,
            ProfileImportPolicy.REPLACE_DUPLICATES,
            ApplicationImportPolicy.REPLACE_DUPLICATES);

    private String name;

    private OrganizationImportPolicy organizationImportPolicy;

    private ProcessImportPolicy processImportPolicy;

    private ProfileImportPolicy profileImportPolicy;

    private ApplicationImportPolicy applicationImportPolicy;
}
