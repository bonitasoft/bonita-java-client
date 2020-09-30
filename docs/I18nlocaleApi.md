# I18nlocaleApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**findI18nlocales**](I18nlocaleApi.md#findI18nlocales) | **GET** API/system/i18nlocale | Finds I18nlocales



## findI18nlocales

> List&lt;I18nlocale&gt; findI18nlocales(p, c)

Finds I18nlocales

List the available I18nlocales with pagination params and filters 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.I18nlocaleApi;

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

        I18nlocaleApi apiInstance = new I18nlocaleApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        try {
            List<I18nlocale> result = apiInstance.findI18nlocales(p, c);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling I18nlocaleApi#findI18nlocales");
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

### Return type

[**List&lt;I18nlocale&gt;**](I18nlocale.md)

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

