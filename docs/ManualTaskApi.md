# ManualTaskApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createManualTask**](ManualTaskApi.md#createManualTask) | **POST** API/bpm/manualTask | Create the ManualTask
[**findManualTasks**](ManualTaskApi.md#findManualTasks) | **GET** API/bpm/manualTask | Finds ManualTasks
[**getManualTaskById**](ManualTaskApi.md#getManualTaskById) | **GET** API/bpm/manualTask/{id} | Finds the ManualTask by ID
[**updateManualTaskById**](ManualTaskApi.md#updateManualTaskById) | **PUT** API/bpm/manualTask/{id} | Update the ManualTask by ID



## createManualTask

> ManualTask createManualTask(body)

Create the ManualTask

Create the ManualTask. Use a POST method to create a new subtask. A subtask is attached to a parent task and it needs to be immediately assigned to a user. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ManualTaskApi;

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

        ManualTaskApi apiInstance = new ManualTaskApi(defaultClient);
        InlineObject8 body = new InlineObject8(); // InlineObject8 | 
        try {
            ManualTask result = apiInstance.createManualTask(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ManualTaskApi#createManualTask");
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
 **body** | [**InlineObject8**](InlineObject8.md)|  |

### Return type

[**ManualTask**](ManualTask.md)

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


## findManualTasks

> List&lt;ManualTask&gt; findManualTasks(p, c, f, o, s)

Finds ManualTasks

Finds ManualTasks with pagination params and filters  You can filter on:  * &#x60;assigned_id&#x3D;{user_id}&#x60;: retrieve only the manual tasks assigned to the specified user. For example, retrieve the manual tasks assigned to user with id 1: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;assigned_id%3d1&#x60;. * &#x60;state&#x3D;skipped | ready | completed | failed&#x60; : retrieve only the manual tasks with the specified state. For example, retrieve the ready tasks: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;state%3dready&#x60;. * &#x60;caseId&#x3D;{case_id}&#x60;: retrieve only the manual tasks created in the specified case. For example, retrieve the manual tasks for the case\\_id 2: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;caseId%3d2&#x60;. * &#x60;parentTaskId&#x3D;{parentTask_id}&#x60;: retrieve only the manual tasks for a specific parentTask. For example, retrieve the manual tasks for the parentTask\\_id 40001: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;parentTaskId%3d40001&#x60;.  You can search on:  * name: search all manual tasks with a name that starts with the search string. For example, search for all manual tasks that have a name that starts with MySubTask: &#x60;/API/bpm/manualTask?p&#x3D;0&amp;c&#x3D;10&amp;s&#x3D;MySubTask&#x60;. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ManualTaskApi;

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

        ManualTaskApi apiInstance = new ManualTaskApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        String s = "s_example"; // String | can search on attributes
        try {
            List<ManualTask> result = apiInstance.findManualTasks(p, c, f, o, s);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ManualTaskApi#findManualTasks");
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

[**List&lt;ManualTask&gt;**](ManualTask.md)

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


## getManualTaskById

> ManualTask getManualTaskById(id)

Finds the ManualTask by ID

Returns the single ManualTask for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ManualTaskApi;

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

        ManualTaskApi apiInstance = new ManualTaskApi(defaultClient);
        String id = "id_example"; // String | ID of the ManualTask to return
        try {
            ManualTask result = apiInstance.getManualTaskById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ManualTaskApi#getManualTaskById");
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
 **id** | **String**| ID of the ManualTask to return |

### Return type

[**ManualTask**](ManualTask.md)

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


## updateManualTaskById

> updateManualTaskById(id, inlineObject9)

Update the ManualTask by ID

Update the ManualTask for the given ID. Use a PUT method to execute a subtask. Executing a subtask basically means changing its state to completed and providing an executedBy value. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ManualTaskApi;

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

        ManualTaskApi apiInstance = new ManualTaskApi(defaultClient);
        String id = "id_example"; // String | ID of the ManualTask to return
        InlineObject9 inlineObject9 = new InlineObject9(); // InlineObject9 | 
        try {
            apiInstance.updateManualTaskById(id, inlineObject9);
        } catch (ApiException e) {
            System.err.println("Exception when calling ManualTaskApi#updateManualTaskById");
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
 **id** | **String**| ID of the ManualTask to return |
 **inlineObject9** | [**InlineObject9**](InlineObject9.md)|  |

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

