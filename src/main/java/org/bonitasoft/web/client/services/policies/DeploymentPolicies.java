package org.bonitasoft.web.client.services.policies;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Emmanuel Duchastenier
 */
@Data
@AllArgsConstructor
public class DeploymentPolicies {

    private String name;
    private OrganizationImportPolicy organizationImportPolicy;
    private ProcessImportPolicy processImportPolicy;
    private ProfileImportPolicy profileImportPolicy;
    private ApplicationImportPolicy applicationImportPolicy;

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
}
