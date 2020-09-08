/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.Objects;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TenantResourceStatus {

    public static final TenantResourceStatus UNKNOWN = new TenantResourceStatus()
            .setState("UNKNOWN")
            .setLastUpdateDate(OffsetDateTime.MIN);

    private int id;
    private String name;
    private String type;
    private String state;
    private String lastUpdatedBy;
    private OffsetDateTime lastUpdateDate;

    public boolean isStateInstalled() {
        return Objects.equals(state, "INSTALLED");
    }

}
