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
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @author Laurent Leseigneur
 */

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {

    private long id;
    private String name;
    private String description;
    @JsonProperty("is_default")
    private boolean isDefault;

    /**
     * Profiles available as default in Bonita
     */
    public enum Profiles {
        /**
         * Default 'User' profile name
         */
        USER("User"),
        /**
         * Default 'Administrator' profile name
         */
        ADMINISTRATOR("Administrator");

        @Getter
        private final String value;

        Profiles(String value) {
            this.value = value;
        }
    }

}
