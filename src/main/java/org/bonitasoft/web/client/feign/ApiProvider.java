package org.bonitasoft.web.client.feign;

import org.bonitasoft.web.client.invoker.ApiClient;

public interface ApiProvider {

	/**
	 * Return the underlying raw http client API. <br>
	 * <br>
	 * <b>Beware that raw API access directly map to http request !! </b> <br>
	 * <br>
	 * <p>You won't benefit from bonita client facilities ( ie. request and payload validation, ...)
	 * and that <b>your code</b> will be <b>highly coupled to the underlying client technology</b> !
	 * <p>This access is provided to avoid people being blocked by the current limited Bonita client
	 * implementation. This may be removed in the future.
	 *
	 * @param apiClass the class of the requested API instance type
	 * @param <T> the specific API type
	 * @return an API instance of type T
	 */
	<T extends ApiClient.Api> T get(Class<T> apiClass);
}
