package org.bonitasoft.web.client.services.policies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

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
