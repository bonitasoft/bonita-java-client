

# BusinessData

Retrieve business data value. Depending on the object attribute loading policy, the API returns either the full object in JSON representation or the HATEOAS links to the object attributes.  Long attributes use a string representation added in 7.0.1 as a workaround for the JavaScript integer spectrum issue.  Representation of object attributes with an _always load_ policy:  ```json {   \"persistenceId\": _number_, // <-- deprecated   \"persistenceId_string\": \"_number_\"   \"persistenceVersion\": _number_, // <-- deprecated   \"persistenceVersion_string\": \"_number_\"   \"attributeName\":_attributeType_   ... } ```  The string representation added in 7.0.1 for Long attributes is a workaround for the JavaScript integer spectrum issue.  HATEOAS representation of object attribute with a _load when needed_ policy: ```json \"links\":[    {    \"rel\":_string_    \"href\":_uri_    } ] ``` 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**persistenceIdString** | **String** | Id of the business data object |  [optional]
**persistenceVersionString** | **String** | Version of the business data object instance |  [optional]


## Implemented Interfaces

* Serializable


