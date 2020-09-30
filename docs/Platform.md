

# Platform

The bonita platform
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**state** | [**StateEnum**](#StateEnum) | platform state |  [optional]
**version** | **String** | the current version of the platform |  [optional]
**initialVersion** | **String** | the version in which the platform was created |  [optional]
**previousVersion** | **String** | the previous version the platform was in or empty if there is none |  [optional]
**createdBy** | **String** | the user name of the platform administrator |  [optional]
**created** | **String** | the creation date |  [optional]



## Enum: StateEnum

Name | Value
---- | -----
STARTED | &quot;STARTED&quot;
STOPPED | &quot;STOPPED&quot;


## Implemented Interfaces

* Serializable


