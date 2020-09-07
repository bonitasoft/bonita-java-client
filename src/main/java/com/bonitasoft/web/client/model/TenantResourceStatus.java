/*
 * Copyright (C) 2018 Bonitasoft S.A.
 * Bonitasoft is a trademark of Bonitasoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * or Bonitasoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 */
package com.bonitasoft.web.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantResourceStatus {

    public static final TenantResourceStatus UNKNOWN = builder()
            .state("UNKNOWN")
            .lastUpdateDate(OffsetDateTime.MIN)
            .build();

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
