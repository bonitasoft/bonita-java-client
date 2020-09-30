# ProcessSupervisorApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProcessSupervisor**](ProcessSupervisorApi.md#createProcessSupervisor) | **POST** API/bpm/processSupervisor | Create the ProcessSupervisor
[**deleteProcessSupervisorById**](ProcessSupervisorApi.md#deleteProcessSupervisorById) | **DELETE** API/bpm/processSupervisor | Delete the ProcessSupervisor by ID
[**findProcessSupervisors**](ProcessSupervisorApi.md#findProcessSupervisors) | **GET** API/bpm/processSupervisor | Finds ProcessSupervisors



## createProcessSupervisor

> ProcessSupervisor createProcessSupervisor(body)

Create the ProcessSupervisor

Create the ProcessSupervisor 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProcessSupervisorApi;

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

        ProcessSupervisorApi apiInstance = new ProcessSupervisorApi(defaultClient);
        ProcessSupervisor body = {"process_id":"5777042023671752656","user_id":"11"}; // ProcessSupervisor | The process definition id and either the user, role and/or group id.
        try {
            ProcessSupervisor result = apiInstance.createProcessSupervisor(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessSupervisorApi#createProcessSupervisor");
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
 **body** | [**ProcessSupervisor**](ProcessSupervisor.md)| The process definition id and either the user, role and/or group id. |

### Return type

[**ProcessSupervisor**](ProcessSupervisor.md)

### Authorization

[bonita_auth](../README.md#bonita_auth), [bonita_token](../README.md#bonita_token)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **5XX** | Unexpected error. |  -  |


## deleteProcessSupervisorById

> deleteProcessSupervisorById(requestBody)

Delete the ProcessSupervisor by ID

Delete the ProcessSupervisor for the given compoound IDs  You can delete a process supervisor by specifying its compound Id in the body of the request with the following format: &#x60;process_id/user_id/role_id/group_id&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProcessSupervisorApi;

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

        ProcessSupervisorApi apiInstance = new ProcessSupervisorApi(defaultClient);
        List<String> requestBody = ["8040901857674754544/11/-1/-1","8040901857674754544/12/-1/-1"]; // List<String> | The process definition id and either the user, role and/or group id.
        try {
            apiInstance.deleteProcessSupervisorById(requestBody);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessSupervisorApi#deleteProcessSupervisorById");
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
 **requestBody** | [**List&lt;String&gt;**](String.md)| The process definition id and either the user, role and/or group id. |

### Return type

null (empty response body)

### Authorization

[bonita_auth](../README.md#bonita_auth), [bonita_token](../README.md#bonita_token)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **404** | The resource for the specified ID was not found. |  -  |
| **5XX** | Unexpected error. |  -  |


## findProcessSupervisors

> List&lt;ProcessSupervisor&gt; findProcessSupervisors(p, c, f, o, s)

Finds ProcessSupervisors

Finds ProcessSupervisors with pagination params and filters  To filter, you need to specify the &#x60;process_id&#x60;, and then the &#x60;user_id&#x60;, &#x60;group_id&#x60; and &#x60;role_id&#x60; with one of them (two if you want to filter on group and role) set to &#x60;&gt;0&#x60; and the other ones set to &#x60;-1&#x60;. E.g.: &#x60;f&#x3D;process_id%3D8040901857674754544&amp;f&#x3D;user_id%3D&gt;0&amp;f&#x3D;group_id%3D-1&amp;f&#x3D;role_id%3D-1&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProcessSupervisorApi;

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

        ProcessSupervisorApi apiInstance = new ProcessSupervisorApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        String s = "s_example"; // String | can search on attributes
        try {
            List<ProcessSupervisor> result = apiInstance.findProcessSupervisors(p, c, f, o, s);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProcessSupervisorApi#findProcessSupervisors");
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
 **p** | **Integer**| index of the page to display |
 **c** | **Integer**| maximum number of elements to retrieve |
 **f** | **String**| can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. | [optional]
 **o** | **String**| can order on attributes | [optional]
 **s** | **String**| can search on attributes | [optional]

### Return type

[**List&lt;ProcessSupervisor&gt;**](ProcessSupervisor.md)

### Authorization

[bonita_auth](../README.md#bonita_auth), [bonita_token](../README.md#bonita_token)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  * Content-Range - The total number of matching items <br>  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **5XX** | Unexpected error. |  -  |

