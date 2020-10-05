package com.bonitasoft.web.client.internal.services.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUser {
    private String userName;
    private String password;
    @JsonProperty("password_confirm")
    private String passwordConfirm;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    private String title;
    @JsonProperty("job_title")
    private String jobTitle;
    @JsonProperty("manager_id")
    private String managerId;
    private String enabled = "true";
}
