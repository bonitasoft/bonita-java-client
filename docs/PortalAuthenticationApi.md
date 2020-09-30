# PortalAuthenticationApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**login**](PortalAuthenticationApi.md#login) | **POST** loginservice | Login
[**logout**](PortalAuthenticationApi.md#logout) | **GET** logoutservice | Logout the current user



## login

> login(username, password, redirect, redirectURL)

Login

A call to the &#x60;/loginservice&#x60; will generates a set-cookie header in the response.  The &#x60;JSESSIONID&#x60; cookie must be transfered with each subsequent calls. (If the REST API is used in an application running in a web browser, this is handled automatically by the web browser just like any cookies).  Additional protection agains CSRF attacks is enabled by default for all fresh installations This security relies on &#x60;X-Bonita-API-Token&#x60; information. The &#x60;X-Bonita-API-Token&#x60; value can be found in the cookie named: &#x60;X-Bonita-API-Token&#x60;.  All the subsequence REST API calls performing changes in the system using DELETE, POST, or PUT HTTP methods must contain the **HTTP header** below:  &#x60;&#x60;&#x60; X-Bonita-API-Token: example-dummy-not-be-used-value &#x60;&#x60;&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PortalAuthenticationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/bonita");

        PortalAuthenticationApi apiInstance = new PortalAuthenticationApi(defaultClient);
        String username = "username_example"; // String | the username
        String password = "password_example"; // String | the password
        String redirect = "redirect_example"; // String | \\\"true\\\" or \\\"false\\\". \\\"false\\\" indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure).
        String redirectURL = "redirectURL_example"; // String | the URL of the page to be displayed after login
        try {
            apiInstance.login(username, password, redirect, redirectURL);
        } catch (ApiException e) {
            System.err.println("Exception when calling PortalAuthenticationApi#login");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| the username | [optional]
 **password** | **String**| the password | [optional]
 **redirect** | **String**| \\\&quot;true\\\&quot; or \\\&quot;false\\\&quot;. \\\&quot;false\\\&quot; indicates that the service should not redirect to Bonita Portal (after a successful login) or to the login page (after a login failure). | [optional]
 **redirectURL** | **String**| the URL of the page to be displayed after login | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Login success |  * Set-Cookie - Session cookie <br>  * X-Bonita-API-Token - X-Bonita-API-Token - CSRF token (also present in the cookie response) <br>  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **5XX** | Unexpected error. |  -  |


## logout

> logout(redirect)

Logout the current user

Logout the current user from the system 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PortalAuthenticationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/bonita");
        
        // Configure API key authorization: bonita_auth
        ApiKeyAuth bonita_auth = (ApiKeyAuth) defaultClient.getAuthentication("bonita_auth");
        bonita_auth.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //bonita_auth.setApiKeyPrefix("Token");

        // Configure API key authorization: bonita_token
        ApiKeyAuth bonita_token = (ApiKeyAuth) defaultClient.getAuthentication("bonita_token");
        bonita_token.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //bonita_token.setApiKeyPrefix("Token");

        PortalAuthenticationApi apiInstance = new PortalAuthenticationApi(defaultClient);
        String redirect = {"redirect":"false","redirectURL":null}; // String | Setting the redirect parameter to false indicates that the service should not redirect to the login page after logging out.
        try {
            apiInstance.logout(redirect);
        } catch (ApiException e) {
            System.err.println("Exception when calling PortalAuthenticationApi#logout");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **redirect** | **String**| Setting the redirect parameter to false indicates that the service should not redirect to the login page after logging out. | [optional]

### Return type

null (empty response body)

### Authorization

[bonita_auth](../README.md#bonita_auth), [bonita_token](../README.md#bonita_token)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **5XX** | Unexpected error. |  -  |

