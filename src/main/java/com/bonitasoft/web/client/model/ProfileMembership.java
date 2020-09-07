package com.bonitasoft.web.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileMembership {

    @JsonProperty("id")
    private long id;
    @JsonProperty("profile_id")
    private long profileId;
    @JsonProperty("role_id")
    private long roleId;
    @JsonProperty("group_id")
    private long groupId;
    @JsonProperty("user_id")
    private long userId;
}
