# ProfessionalContactDataApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProfessionalContactData**](ProfessionalContactDataApi.md#createProfessionalContactData) | **POST** API/identity/professionalcontactdata | Create the ProfessionalContactData
[**findProfessionalContactDatas**](ProfessionalContactDataApi.md#findProfessionalContactDatas) | **GET** API/identity/professionalcontactdata | Finds ProfessionalContactData
[**getPersonalContactDataById**](ProfessionalContactDataApi.md#getPersonalContactDataById) | **GET** API/identity/personalcontactdata/{userId} | Finds the PersonalContactData by ID
[**getProfessionalContactDataById**](ProfessionalContactDataApi.md#getProfessionalContactDataById) | **GET** API/identity/professionalcontactdata/{userId} | Finds the ProfessionalContactData by ID
[**updatePersonalContactDataById**](ProfessionalContactDataApi.md#updatePersonalContactDataById) | **PUT** API/identity/personalcontactdata/{userId} | Update the PersonalContactData by ID
[**updateProfessionalContactDataById**](ProfessionalContactDataApi.md#updateProfessionalContactDataById) | **PUT** API/identity/professionalcontactdata/{userId} | Update the ProfessionalContactData by ID



## createProfessionalContactData

> ProfessionalContactData createProfessionalContactData(body)

Create the ProfessionalContactData

Create the ProfessionalContactData 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProfessionalContactDataApi;

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

        ProfessionalContactDataApi apiInstance = new ProfessionalContactDataApi(defaultClient);
        ProfessionalContactData body = {"id":"4","fax_number":"484-302-0766","building":"70","phone_number":"484-302-5766","zipcode":"19108","state":"PA","city":"Philadelphia","country":"United States","address":"Renwick Drive","email":"walter.bates@acme.com"}; // ProfessionalContactData | Partial ProfessionalContactData description including the user ID
        try {
            ProfessionalContactData result = apiInstance.createProfessionalContactData(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProfessionalContactDataApi#createProfessionalContactData");
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
 **body** | [**ProfessionalContactData**](ProfessionalContactData.md)| Partial ProfessionalContactData description including the user ID |

### Return type

[**ProfessionalContactData**](ProfessionalContactData.md)

### Authorization

[bonita_auth](../README.md#bonita_auth), [bonita_token](../README.md#bonita_token)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **403** | Contact information for this user already exists |  -  |
| **5XX** | Unexpected error. |  -  |


## findProfessionalContactDatas

> List&lt;ProfessionalContactData&gt; findProfessionalContactDatas(p, c, f, o, s)

Finds ProfessionalContactData

Finds ProfessionalContactData with pagination params and filters  - can order on &#x60;id&#x60; - can search on &#x60;displayName&#x60; - can filter on &#x60;displayName&#x60; 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProfessionalContactDataApi;

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

        ProfessionalContactDataApi apiInstance = new ProfessionalContactDataApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        String s = "s_example"; // String | can search on attributes
        try {
            List<ProfessionalContactData> result = apiInstance.findProfessionalContactDatas(p, c, f, o, s);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProfessionalContactDataApi#findProfessionalContactDatas");
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

[**List&lt;ProfessionalContactData&gt;**](ProfessionalContactData.md)

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


## getPersonalContactDataById

> ProfessionalContactData getPersonalContactDataById(userId)

Finds the PersonalContactData by ID

Returns the single PersonalContactData for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProfessionalContactDataApi;

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

        ProfessionalContactDataApi apiInstance = new ProfessionalContactDataApi(defaultClient);
        String userId = "userId_example"; // String | User ID of the PersonalContactData to return
        try {
            ProfessionalContactData result = apiInstance.getPersonalContactDataById(userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProfessionalContactDataApi#getPersonalContactDataById");
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
 **userId** | **String**| User ID of the PersonalContactData to return |

### Return type

[**ProfessionalContactData**](ProfessionalContactData.md)

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


## getProfessionalContactDataById

> ProfessionalContactData getProfessionalContactDataById(userId)

Finds the ProfessionalContactData by ID

Returns the single ProfessionalContactData for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProfessionalContactDataApi;

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

        ProfessionalContactDataApi apiInstance = new ProfessionalContactDataApi(defaultClient);
        String userId = "userId_example"; // String | User ID of the ProfessionalContactData to return
        try {
            ProfessionalContactData result = apiInstance.getProfessionalContactDataById(userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProfessionalContactDataApi#getProfessionalContactDataById");
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
 **userId** | **String**| User ID of the ProfessionalContactData to return |

### Return type

[**ProfessionalContactData**](ProfessionalContactData.md)

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


## updatePersonalContactDataById

> updatePersonalContactDataById(userId, professionalContactData)

Update the PersonalContactData by ID

Update the PersonalContactData for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProfessionalContactDataApi;

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

        ProfessionalContactDataApi apiInstance = new ProfessionalContactDataApi(defaultClient);
        String userId = "userId_example"; // String | User ID of the PersonalContactData to update
        ProfessionalContactData professionalContactData = {"id":"4","fax_number":"484-302-0766","building":"70","phone_number":"484-302-5766","zipcode":"19108","state":"PA","city":"Philadelphia","country":"United States","address":"Renwick Drive","email":"walter.bates@acme.com"}; // ProfessionalContactData | Partial PersonalContactData description including the user ID
        try {
            apiInstance.updatePersonalContactDataById(userId, professionalContactData);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProfessionalContactDataApi#updatePersonalContactDataById");
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
 **userId** | **String**| User ID of the PersonalContactData to update |
 **professionalContactData** | [**ProfessionalContactData**](ProfessionalContactData.md)| Partial PersonalContactData description including the user ID |

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


## updateProfessionalContactDataById

> updateProfessionalContactDataById(userId, professionalContactData)

Update the ProfessionalContactData by ID

Update the ProfessionalContactData for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.ProfessionalContactDataApi;

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

        ProfessionalContactDataApi apiInstance = new ProfessionalContactDataApi(defaultClient);
        String userId = "userId_example"; // String | User ID of the ProfessionalContactData to update
        ProfessionalContactData professionalContactData = {"id":"4","fax_number":"484-302-0766","building":"70","phone_number":"484-302-5766","zipcode":"19108","state":"PA","city":"Philadelphia","country":"United States","address":"Renwick Drive","email":"walter.bates@acme.com"}; // ProfessionalContactData | Partial ProfessionalContactData description including the user ID
        try {
            apiInstance.updateProfessionalContactDataById(userId, professionalContactData);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProfessionalContactDataApi#updateProfessionalContactDataById");
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
 **userId** | **String**| User ID of the ProfessionalContactData to update |
 **professionalContactData** | [**ProfessionalContactData**](ProfessionalContactData.md)| Partial ProfessionalContactData description including the user ID |

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

