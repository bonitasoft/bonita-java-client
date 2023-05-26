package org.bonitasoft.web.client.feign.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UsernamePasswordCredentials implements Credentials {

	private final String username;

	private final String password;

	private String tenant;
}
