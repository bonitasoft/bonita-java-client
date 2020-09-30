# HumanTaskApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findHumanTasks**](HumanTaskApi.md#findHumanTasks) | **GET** API/bpm/humanTask | Finds HumanTasks
[**getHumanTaskById**](HumanTaskApi.md#getHumanTaskById) | **GET** API/bpm/humanTask/{id} | Finds the HumanTask by ID
[**updateHumanTaskById**](HumanTaskApi.md#updateHumanTaskById) | **PUT** API/bpm/humanTask/{id} | Update the HumanTask by ID



## findHumanTasks

> List&lt;HumanTask&gt; findHumanTasks(p, c, f, o, s)

Finds HumanTasks

Finds HumanTasks with pagination params and filters  - can order on &#x60;name&#x60;, &#x60;priority&#x60;, &#x60;dueDate&#x60;, &#x60;state&#x60;, &#x60;userId&#x60;, &#x60;groupId&#x60;, &#x60;roleId&#x60;, &#x60;processDefinitionId&#x60;, &#x60;processInstanceId&#x60;, &#x60;parentActivityInstanceId&#x60;, &#x60;assigneeId&#x60;, &#x60;parentContainerId&#x60;, &#x60;displayName&#x60;, &#x60;reachedStateDate&#x60; - can search on any field that can be used to order results - can filter on &#x60;assigned_id&#x60;, &#x60;state&#x60;, &#x60;name&#x60;, &#x60;displayName&#x60;, &#x60;processDefinitionId&#x60;, &#x60;parentContainerId&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.HumanTaskApi;

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

        HumanTaskApi apiInstance = new HumanTaskApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        String s = "s_example"; // String | can search on attributes
        try {
            List<HumanTask> result = apiInstance.findHumanTasks(p, c, f, o, s);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HumanTaskApi#findHumanTasks");
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

[**List&lt;HumanTask&gt;**](HumanTask.md)

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


## getHumanTaskById

> HumanTask getHumanTaskById(id)

Finds the HumanTask by ID

Returns the single HumanTask for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.HumanTaskApi;

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

        HumanTaskApi apiInstance = new HumanTaskApi(defaultClient);
        String id = "id_example"; // String | ID of the HumanTask to return
        try {
            HumanTask result = apiInstance.getHumanTaskById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HumanTaskApi#getHumanTaskById");
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
 **id** | **String**| ID of the HumanTask to return |

### Return type

[**HumanTask**](HumanTask.md)

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


## updateHumanTaskById

> updateHumanTaskById(id, inlineObject7)

Update the HumanTask by ID

Update the HumanTask for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.HumanTaskApi;

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

        HumanTaskApi apiInstance = new HumanTaskApi(defaultClient);
        String id = "id_example"; // String | ID of the HumanTask to return
        InlineObject7 inlineObject7 = new InlineObject7(); // InlineObject7 | 
        try {
            apiInstance.updateHumanTaskById(id, inlineObject7);
        } catch (ApiException e) {
            System.err.println("Exception when calling HumanTaskApi#updateHumanTaskById");
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
 **id** | **String**| ID of the HumanTask to return |
 **inlineObject7** | [**InlineObject7**](InlineObject7.md)|  |

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

