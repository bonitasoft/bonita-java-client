# CaseDocumentApi

All URIs are relative to *http://localhost:8080/bonita*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCaseDocument**](CaseDocumentApi.md#createCaseDocument) | **POST** API/bpm/caseDocument | Create the CaseDocument
[**deleteCaseDocumentById**](CaseDocumentApi.md#deleteCaseDocumentById) | **DELETE** API/bpm/caseDocument/{id} | Delete the CaseDocument by ID
[**findCaseDocuments**](CaseDocumentApi.md#findCaseDocuments) | **GET** API/bpm/caseDocument | Finds CaseDocuments
[**getCaseDocumentById**](CaseDocumentApi.md#getCaseDocumentById) | **GET** API/bpm/caseDocument/{id} | Finds the CaseDocument by ID
[**updateCaseDocumentById**](CaseDocumentApi.md#updateCaseDocumentById) | **PUT** API/bpm/caseDocument/{id} | Update the CaseDocument by ID



## createCaseDocument

> CaseDocument createCaseDocument(body)

Create the CaseDocument

Create the CaseDocument.  Use a POST method to add a document to a case. You can upload a document from the local file system or by URL. Specify the case id and the document name in the payload. The document description is optional: if you do not specify a description, the description in the response is empty. The response contains a version, which is managed automatically. You cannot currently retrieve a specific version of a document, only the most recent version. To retrieve earlier versions of a caseDocument, use the archivedCaseDocument resource. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.CaseDocumentApi;

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

        CaseDocumentApi apiInstance = new CaseDocumentApi(defaultClient);
        InlineObject13 body = new InlineObject13(); // InlineObject13 | 
        try {
            CaseDocument result = apiInstance.createCaseDocument(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CaseDocumentApi#createCaseDocument");
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
 **body** | [**InlineObject13**](InlineObject13.md)|  |

### Return type

[**CaseDocument**](CaseDocument.md)

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


## deleteCaseDocumentById

> deleteCaseDocumentById(id)

Delete the CaseDocument by ID

Delete the single CaseDocument for the given ID 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.CaseDocumentApi;

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

        CaseDocumentApi apiInstance = new CaseDocumentApi(defaultClient);
        String id = "id_example"; // String | ID of the CaseDocument to delete
        try {
            apiInstance.deleteCaseDocumentById(id);
        } catch (ApiException e) {
            System.err.println("Exception when calling CaseDocumentApi#deleteCaseDocumentById");
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
 **id** | **String**| ID of the CaseDocument to delete |

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


## findCaseDocuments

> List&lt;CaseDocument&gt; findCaseDocuments(p, c, f, o)

Finds CaseDocuments

Finds CaseDocuments with pagination params and filters  It is possible to filter on three parameters: &#x60;submittedBy&#x60;, &#x60;name&#x60; and &#x60;description&#x60;.   * &#x60;submittedBy&#x3D;\&quot;id\&quot;&#x60;: search for documents that were submitted by the user with the specified identifier.  * &#x60;name&#x3D;\&quot;string\&quot;&#x60;: search for documents with names that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the name or the start of a word in the name.  * &#x60;description&#x3D;\&quot;string\&quot;&#x60;: search for documents with descriptions that contain _string_.    Depending on the setting for [word-based search](using-list-and-search-methods.md), the search returns documents with _string_ at the start of the description or the start of a word in the description. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.CaseDocumentApi;

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

        CaseDocumentApi apiInstance = new CaseDocumentApi(defaultClient);
        Integer p = 0; // Integer | index of the page to display
        Integer c = 10; // Integer | maximum number of elements to retrieve
        String f = abc%3d123; // String | can filter on attributes with the format f={filter\\_name}={filter\\_value} with the name/value pair as url encoded string.
        String o = myProp%20ASC; // String | can order on attributes
        try {
            List<CaseDocument> result = apiInstance.findCaseDocuments(p, c, f, o);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CaseDocumentApi#findCaseDocuments");
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

[**List&lt;CaseDocument&gt;**](CaseDocument.md)

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


## getCaseDocumentById

> CaseDocument getCaseDocumentById(id)

Finds the CaseDocument by ID

Returns the single CaseDocument for the given ID. Use a GET method to get a document from a case. First you get the document information, then you download the content. To get the document information, specify the document id in the URL. The document id is created when you upload a document to a case. There is no payload. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.CaseDocumentApi;

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

        CaseDocumentApi apiInstance = new CaseDocumentApi(defaultClient);
        String id = "id_example"; // String | ID of the CaseDocument to return
        try {
            CaseDocument result = apiInstance.getCaseDocumentById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CaseDocumentApi#getCaseDocumentById");
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
 **id** | **String**| ID of the CaseDocument to return |

### Return type

[**CaseDocument**](CaseDocument.md)

### Authorization

[bonita_auth](../README.md#bonita_auth), [bonita_token](../README.md#bonita_token)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation. The response includes the \&quot;url\&quot; to use to download the content. Call the documentDownload servlet with this URL: /portal/documentDownload?fileName&#x3D;doc.jpg&amp;contentStorageId&#x3D;4. Note: Since Bonita 7.10, document url fileName is now URL encoded. This will avoid errors when a document to be downloaded contains special characters in its name. In the previous versions, a workaround was necessary client-side using the javascript native function \&quot;encodeURI\&quot; to generate document download url. You can now remove this workaround.  |  -  |
| **400** | Bad request. |  -  |
| **401** | Authorization information is missing or invalid. |  -  |
| **404** | The resource for the specified ID was not found. |  -  |
| **5XX** | Unexpected error. |  -  |


## updateCaseDocumentById

> updateCaseDocumentById(id, inlineObject14)

Update the CaseDocument by ID

Update the CaseDocument for the given ID  You update a document in a case by uploading a new version of the document using a PUT method. You can upload a document version from the local file system or by URL. The document name will be used in all the cases of the process, but the combination of case id and document name is unique. In the URL, you specify to supply the document id. This is included in the response when you first add a document to a case. The response to PUT methods is the same as for POST methods. 

### Example

```java
// Import classes:
import org.bonitasoft.web.client.ApiClient;
import org.bonitasoft.web.client.ApiException;
import org.bonitasoft.web.client.Configuration;
import org.bonitasoft.web.client.auth.*;
import org.bonitasoft.web.client.models.*;
import org.bonitasoft.web.client.internal.api.CaseDocumentApi;

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

        CaseDocumentApi apiInstance = new CaseDocumentApi(defaultClient);
        String id = "id_example"; // String | ID of the CaseDocument to return
        InlineObject14 inlineObject14 = new InlineObject14(); // InlineObject14 | 
        try {
            apiInstance.updateCaseDocumentById(id, inlineObject14);
        } catch (ApiException e) {
            System.err.println("Exception when calling CaseDocumentApi#updateCaseDocumentById");
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
 **id** | **String**| ID of the CaseDocument to return |
 **inlineObject14** | [**InlineObject14**](InlineObject14.md)|  |

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

