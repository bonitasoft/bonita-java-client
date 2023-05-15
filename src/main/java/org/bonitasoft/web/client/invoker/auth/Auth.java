package org.bonitasoft.web.client.invoker.auth;

import org.bonitasoft.web.client.feign.auth.Credentials;

public interface Auth {

	void login(Credentials credentials);
	void logout();
}
