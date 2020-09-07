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
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    // TODO implement date format with "2017-12-18 12:55:14.673"
    // @JsonProperty("last_connection")
    // private Instant lastConnection;

    @JsonProperty("created_by_user_id")
    private int createdByUserId;

    // TODO implement date format with "2017-12-18 12:55:14.673"
    // @JsonProperty("creation_date")
    // private Instant creationDate;

    private int id;

    private String icon;

    private boolean enabled;

    private String title;

    @JsonProperty("job_title")
    private String jobIitle;

    private String userName;

    private String lastname;

    private String firstname;

    private String password;

    // TODO implement date format with "2017-12-18 12:55:14.673"
    // @JsonProperty("last_update_date")
    // private Instant lastUpdateDate;

}
