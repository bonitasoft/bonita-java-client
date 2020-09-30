# PageApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPage**](PageApi.md#createPage) | **POST** API/portal/page | Create the Page
[**deletePageById**](PageApi.md#deletePageById) | **DELETE** API/portal/page/{id} | Delete the Page by ID
[**findPages**](PageApi.md#findPages) | **GET** API/portal/page | Finds Pages
[**getPageById**](PageApi.md#getPageById) | **GET** API/portal/page/{id} | Finds the Page by ID
[**updatePageById**](PageApi.md#updatePageById) | **PUT** API/portal/page/{id} | Update the Page by ID
[**uploadPage**](PageApi.md#uploadPage) | **POST** portal/pageUpload | Upload a Page



## createPage

> Page createPage(body)

Create the Page

Upload the page content using the &#x60;portal/pageUpload&#x60; . This returns a temporary file name that can be used as input for this operation. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PageApi;

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

        PageApi apiInstance = new PageApi(defaultClient);
        InlineObject39 body = new InlineObject39(); // InlineObject39 | 
        try {
            Page result = apiInstance.createPage(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PageApi#createPage");
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
 **body** | [**InlineObject39**](InlineObject39.md)|  |

### Return type

[**Page**](Page.md)

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


## deletePageById

> deletePageById(id)

Delete the Page by ID

Delete the single Page for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PageApi;

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

        PageApi apiInstance = new PageApi(defaultClient);
        String id = "id_example"; // String | ID of the Page to delete
        try {
            apiInstance.deletePageById(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling PageApi#deletePageById");
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
 **id** | **String**| ID of the Page to delete |

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


## findPages

> List&lt;Page&gt; findPages(p, c, f, o, s)

Finds Pages

Finds Pages with pagination params and filters  - can search on &#x60;displayName&#x60;,&#x60;description&#x60; - can filter on &#x60;createdBy&#x60;,&#x60;contentType&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PageApi;

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

        PageApi apiInstance = new PageApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        String s = "s_example"; // String | can search on attributes
        try {
            List<Page> result = apiInstance.findPages(p, c, f, o, s);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PageApi#findPages");
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

[**List&lt;Page&gt;**](Page.md)

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


## getPageById

> Page getPageById(id)

Finds the Page by ID

Returns the single Page for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PageApi;

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

        PageApi apiInstance = new PageApi(defaultClient);
        String id = "id_example"; // String | ID of the Page to return
        try {
            Page result = apiInstance.getPageById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PageApi#getPageById");
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
 **id** | **String**| ID of the Page to return |

### Return type

[**Page**](Page.md)

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


## updatePageById

> updatePageById(id, inlineObject40)

Update the Page by ID

Use the PUT method to update an existing custom page. To update a custom page, upload the new page content using the pageUpload servlet, which returns a temporary file name, and then call this API with the temporary file name. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PageApi;

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

        PageApi apiInstance = new PageApi(defaultClient);
        String id = "id_example"; // String | ID of the Page to return
        InlineObject40 inlineObject40 = new InlineObject40(); // InlineObject40 | 
        try {
            apiInstance.updatePageById(id, inlineObject40);
        } catch (ApiException e) {
            System.err.println("Exception when calling PageApi#updatePageById");
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
 **id** | **String**| ID of the Page to return |
 **inlineObject40** | [**InlineObject40**](InlineObject40.md)|  |

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


## uploadPage

> InlineResponse2002 uploadPage(file)

Upload a Page

Upload Page 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.PageApi;

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

        PageApi apiInstance = new PageApi(defaultClient);
        File file = new File("/path/to/file"); // File | 
        try {
            InlineResponse2002 result = apiInstance.uploadPage(file);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PageApi#uploadPage");
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
 **file** | **File**|  | [optional]

### Return type

[**InlineResponse2002**](InlineResponse2002.md)

### Authorization

[bonita_auth](../README.md#bonita_auth), [bonita_token](../README.md#bonita_token)

### HTTP request headers

- **Content-Type**: multipart/form-data
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | sucessful operation |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **5XX** | Unexpected error. |  -  |

