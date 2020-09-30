# ActorMemberApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteActorMemberById**](ActorMemberApi.md#deleteActorMemberById) | **DELETE** API/bpm/actorMemberEntry/{id} | Delete the ActorMember by ID
[**findActorMembers**](ActorMemberApi.md#findActorMembers) | **GET** API/bpm/actorMemberEntry | Finds ActorMembers
[**getActorMemberById**](ActorMemberApi.md#getActorMemberById) | **GET** API/bpm/actorMemberEntry/{id} | Finds the ActorMember by ID



## deleteActorMemberById

> deleteActorMemberById(id)

Delete the ActorMember by ID

Delete the single ActorMember for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ActorMemberApi;

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

        ActorMemberApi apiInstance = new ActorMemberApi(defaultClient);
        String id = "id_example"; // String | ID of the ActorMember to delete
        try {
            apiInstance.deleteActorMemberById(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActorMemberApi#deleteActorMemberById");
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
 **id** | **String**| ID of the ActorMember to delete |

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
| **200** | OK |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **404** | The resource for the specified ID was not found. |  -  |
| **5XX** | Unexpected error. |  -  |


## findActorMembers

> List&lt;ActorMember&gt; findActorMembers(p, c, f, o)

Finds ActorMembers

Finds ActorMembers with pagination params and filters  There is a **mandatory** filter on:  * &#x60;actor_id&#x60; For example, retrieve the actorMembers related to the specified actor_id. http://localhost:8080/bonita/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1  You can also filter also on:  * &#x60;member_type&#x60; (user|role|group|roleAndGroup) retrieve only the actorMembers of type user. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;member_type%3duser&#x60; * &#x60;user_id&#x60;: retrieve only the actorMembers related to the specified user_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;user_id%3d101&#x60; * &#x60;role_id&#x60;: retrieve only the actorMembers related to the specified role_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;role_id%3d101&#x60; * &#x60;group_id&#x60;: retrieve only the actorMembers related to the specified group_id. &#x60;/API/bpm/actorMember?p&#x3D;0&amp;c&#x3D;10&amp;f&#x3D;actor_id%3d1&amp;f&#x3D;group_id%3d101&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ActorMemberApi;

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

        ActorMemberApi apiInstance = new ActorMemberApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        try {
            List<ActorMember> result = apiInstance.findActorMembers(p, c, f, o);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActorMemberApi#findActorMembers");
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

[**List&lt;ActorMember&gt;**](ActorMember.md)

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


## getActorMemberById

> ActorMember getActorMemberById(id)

Finds the ActorMember by ID

Returns the single ActorMember for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ActorMemberApi;

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

        ActorMemberApi apiInstance = new ActorMemberApi(defaultClient);
        String id = "id_example"; // String | ID of the ActorMember to return
        try {
            ActorMember result = apiInstance.getActorMemberById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActorMemberApi#getActorMemberById");
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
 **id** | **String**| ID of the ActorMember to return |

### Return type

[**ActorMember**](ActorMember.md)

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

