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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeploymentPoliciesTest {

    @Test
    void development_defaults() {
        // Given
        final DeploymentPolicies policies = DeploymentPolicies.DevelopmentDefaults;

        // Then
        assertThat(policies.getName()).isEqualTo("DEVELOPMENT");
        assertThat(policies.getApplicationImportPolicy())
                .isEqualTo(ApplicationImportPolicy.REPLACE_DUPLICATES);
        assertThat(policies.getOrganizationImportPolicy())
                .isEqualTo(OrganizationImportPolicy.MERGE_DUPLICATES);
        assertThat(policies.getProfileImportPolicy()).isEqualTo(ProfileImportPolicy.REPLACE_DUPLICATES);
        assertThat(policies.getProcessImportPolicy()).isEqualTo(ProcessImportPolicy.REPLACE_DUPLICATES);
    }

    @Test
    void production_defaults() {
        // Given
        final DeploymentPolicies policies = DeploymentPolicies.ProductionDefaults;

        // Then
        assertThat(policies.getName()).isEqualTo("PRODUCTION");
        assertThat(policies.getApplicationImportPolicy())
                .isEqualTo(ApplicationImportPolicy.REPLACE_DUPLICATES);
        assertThat(policies.getOrganizationImportPolicy())
                .isEqualTo(OrganizationImportPolicy.IGNORE_DUPLICATES);
        assertThat(policies.getProfileImportPolicy())
                .isEqualTo(ProfileImportPolicy.IGNORE_IF_ANY_EXISTS);
        assertThat(policies.getProcessImportPolicy()).isEqualTo(ProcessImportPolicy.IGNORE_DUPLICATES);
    }
}
