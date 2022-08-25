package org.bonitasoft.web.client.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NoPasswordLeakTest {

	@Test
	void no_tenant_password_should_leak_via_toString() {
		// Given
		String password = "secret";
		Tenant tenant = new Tenant().password(password);
		TenantCreateRequest tenantCreateRequest = new TenantCreateRequest().password(password);
		TenantUpdateRequest tenantUpdateRequest = new TenantUpdateRequest().password(password);

		// When
		String log = String.format("tenantCreateRequest: %s, tenantUpdateRequest: %s, tenant: %s", tenantCreateRequest, tenantUpdateRequest, tenant);

		// Then
		assertThat(log).doesNotContain(password).contains("***");
	}

	@Test
	void no_user_password_should_leak_via_toString() {
		// Given
		String password = "top-secret";
		User user = new User().password(password);
		UserCreateRequest userCreateRequest = new UserCreateRequest().password(password).passwordConfirm(password);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest().password(password);

		// When
		String log = String.format("userCreateRequest: %s, userUpdateRequest: %s, user: %s", userCreateRequest, userUpdateRequest, user);

		// Then
		assertThat(log).doesNotContain(password).contains("***");
	}
}
