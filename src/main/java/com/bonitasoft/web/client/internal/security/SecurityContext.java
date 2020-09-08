package com.bonitasoft.web.client.internal.security;

import okhttp3.ResponseBody;

public interface SecurityContext {
    void authenticate(retrofit2.Response<ResponseBody> response);

    void clear();

    void isAuthenticated();
}
