# ActivityVariableApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActivityVariableById**](ActivityVariableApi.md#getActivityVariableById) | **GET** API/bpm/activityVariable/{id}/{variableName} | Finds the ActivityVariable by ID



## getActivityVariableById

> ActivityVariable getActivityVariableById(id, variableName)

Finds the ActivityVariable by ID

Returns the single ActivityVariable for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ActivityVariableApi;

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

        ActivityVariableApi apiInstance = new ActivityVariableApi(defaultClient);
        String id = "id_example"; // String | The identifier of the activity from which to retrieve the variable
        oas_any_type_not_mapped variableName = new oas_any_type_not_mapped(); // oas_any_type_not_mapped | The name of the variable to retrieve
        try {
            ActivityVariable result = apiInstance.getActivityVariableById(id, variableName);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ActivityVariableApi#getActivityVariableById");
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
 **id** | **String**| The identifier of the activity from which to retrieve the variable |
 **variableName** | [**oas_any_type_not_mapped**](.md)| The name of the variable to retrieve | [default to null]

### Return type

[**ActivityVariable**](ActivityVariable.md)

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

