# BusinessDataQueryApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findBusinessData**](BusinessDataQueryApi.md#findBusinessData) | **GET** API/bdm/businessData/{businessDataType} | Finds Business Data



## findBusinessData

> List&lt;BusinessData&gt; findBusinessData(businessDataType, q, p, c, f)

Finds Business Data

Finds Business Data with pagination params and filters by calling a &#x60;Named Query&#x60;. The business data query REST API resource is used to call a default or custom business data query. It is available from version 6.5.  **Data parameters**:    * businessDataType - the fully-qualified business data type name   * q&#x3D;queryName - the query name   * p&#x3D;0 - the page number   * c&#x3D;10 - the maximum number of results in the page   * f&#x3D;parameter&#x3D;value - sets the parameter value according to business data query parameters defined in Bonita Studio   For a Boolean parameter, the accepted values are &#x60;true&#x60; or &#x60;false&#x60;.    By default, for a Date parameter can use the following formats:    * yyyy-MM-dd   * HH:mm:ss   * yyyy-MM-dd HH:mm:ss   * yyyy-MM-dd&#39;T&#39;HH:mm:ss   * yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.BusinessDataQueryApi;

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

        BusinessDataQueryApi apiInstance = new BusinessDataQueryApi(defaultClient);
        String businessDataType = com.company.model.Employee; // String | Business Data Type
        String q = findEmployeeByFirstNameAndLastName; // String | Named query to use
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        try {
            List<BusinessData> result = apiInstance.findBusinessData(businessDataType, q, p, c, f);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BusinessDataQueryApi#findBusinessData");
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
 **businessDataType** | **String**| Business Data Type |
 **q** | **String**| Named query to use |
 **p** | **Integer**| index of the page to display |
 **c** | **Integer**| maximum number of elements to retrieve |
 **f** | **String**| can filter on attributes with the format f&#x3D;{filter\\_name}&#x3D;{filter\\_value} with the name/value pair as url encoded string. | [optional]

### Return type

[**List&lt;BusinessData&gt;**](BusinessData.md)

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
| **404** | The resource for the specified ID was not found. |  -  |
| **5XX** | Unexpected error. |  -  |

