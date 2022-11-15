package org.bonitasoft.web.client.api;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.bonitasoft.web.client.invoker.ApiClient;
import org.bonitasoft.web.client.model.ApiResponse;
import org.bonitasoft.web.client.model.Platform;
import org.bonitasoft.web.client.model.PlatformUpdateRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public interface PlatformApi extends ApiClient.Api {


	/**
	 * Finds the Platform by ID
	 * Returns the current Platform
	 * @return Platform
	 */
	@RequestLine("GET /API/platform/platform/unusedid")
	@Headers({
			"Accept: application/json",
	})
	Platform getPlatformById();

	/**
	 * Finds the Platform by ID
	 * Similar to <code>getPlatformById</code> but it also returns the http response headers .
	 * Returns the current Platform
	 * @return A ApiResponse that wraps the response boyd and the http headers.
	 */
	@RequestLine("GET /API/platform/platform/unusedid")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<Platform> getPlatformByIdWithHttpInfo();


	/**
	 * Platform Login
	 * The username and password are in &#x60;bonita-platform-community-custom.properties&#x60; file.
	 * @param username the username (optional)
	 * @param password the password (optional)
	 * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional)
	 */
	@RequestLine("POST /platformloginservice")
	@Headers({
			"Content-Type: application/x-www-form-urlencoded",
			"Accept: application/json",
	})
	void platformLogin(@Param("username") String username, @Param("password") String password, @Param("redirect") String redirect);

	/**
	 * Platform Login
	 * Similar to <code>platformLogin</code> but it also returns the http response headers .
	 * The username and password are in &#x60;bonita-platform-community-custom.properties&#x60; file.
	 * @param username the username (optional)
	 * @param password the password (optional)
	 * @param redirect \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). (optional)
	 */
	@RequestLine("POST /platformloginservice")
	@Headers({
			"Content-Type: application/x-www-form-urlencoded",
			"Accept: application/json",
	})
	ApiResponse<Void> platformLoginWithHttpInfo(@Param("username") String username, @Param("password") String password, @Param("redirect") String redirect);


	/**
	 * Platform Logout
	 *
	 */
	@RequestLine("POST /platformlogoutservice")
	@Headers({
			"Accept: application/json",
	})
	void platformLogout();

	/**
	 * Platform Logout
	 * Similar to <code>platformLogout</code> but it also returns the http response headers .
	 *
	 */
	@RequestLine("POST /platformlogoutservice")
	@Headers({
			"Accept: application/json",
	})
	ApiResponse<Void> platformLogoutWithHttpInfo();


	/**
	 * Update the Platform by ID
	 * Start or stop the current node, that is, start or stop all services of the current JVM.
	 * @param platformUpdateRequest Start or stop all services of the current JVM. (required)
	 */
	@RequestLine("PUT /API/platform/platform/unusedid")
	@Headers({
			"Content-Type: application/json",
			"Accept: application/json",
	})
	void updatePlatformById(PlatformUpdateRequest platformUpdateRequest);

	/**
	 * Update the Platform by ID
	 * Similar to <code>updatePlatformById</code> but it also returns the http response headers .
	 * Start or stop the current node, that is, start or stop all services of the current JVM.
	 * @param platformUpdateRequest Start or stop all services of the current JVM. (required)
	 */
	@RequestLine("PUT /API/platform/platform/unusedid")
	@Headers({
			"Content-Type: application/json",
			"Accept: application/json",
	})
	ApiResponse<Void> updatePlatformByIdWithHttpInfo(PlatformUpdateRequest platformUpdateRequest);

}
