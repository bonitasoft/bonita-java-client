package org.bonitasoft.web.client.api;

import feign.Headers;
import feign.RequestLine;
import feign.Response;
import org.bonitasoft.web.client.invoker.ApiClient;

public interface SessionApi extends ApiClient.Api {

    /**
     * Get the current user session Returns session information for the current user
     *
     * @return Session
     */
    @RequestLine("GET /API/system/session/unusedId")
    @Headers({
            "Accept: application/json",
    })
    Response getSession();
}
