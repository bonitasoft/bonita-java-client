# ArchivedTaskApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findArchivedTasks**](ArchivedTaskApi.md#findArchivedTasks) | **GET** API/bpm/archivedTask | Finds ArchivedTasks
[**getArchivedTaskById**](ArchivedTaskApi.md#getArchivedTaskById) | **GET** API/bpm/archivedTask/{id} | Finds the ArchivedTask by ID



## findArchivedTasks

> List&lt;ArchivedTask&gt; findArchivedTasks(p, c, f, o)

Finds ArchivedTasks

Finds ArchivedTasks with pagination params and filters  - Can order on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60; - Can filter on &#x60;caseId&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processId&#x60;, &#x60;state&#x60;, &#x60;type&#x60;, &#x60;archivedDate&#x60;, &#x60;reached_state_date&#x60;, &#x60;assigned_id&#x60;, &#x60;isTerminal&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ArchivedTaskApi;

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

        ArchivedTaskApi apiInstance = new ArchivedTaskApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        try {
            List<ArchivedTask> result = apiInstance.findArchivedTasks(p, c, f, o);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ArchivedTaskApi#findArchivedTasks");
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

### Return type

[**List&lt;ArchivedTask&gt;**](ArchivedTask.md)

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


## getArchivedTaskById

> ArchivedTask getArchivedTaskById(id)

Finds the ArchivedTask by ID

Returns the single ArchivedTask for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ArchivedTaskApi;

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

        ArchivedTaskApi apiInstance = new ArchivedTaskApi(defaultClient);
        String id = "id_example"; // String | ID of the ArchivedTask to return
        try {
            ArchivedTask result = apiInstance.getArchivedTaskById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ArchivedTaskApi#getArchivedTaskById");
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
 **id** | **String**| ID of the ArchivedTask to return |

### Return type

[**ArchivedTask**](ArchivedTask.md)

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
| **404** | The resource for the specified ID was not found. |  -  |
| **5XX** | Unexpected error. |  -  |

