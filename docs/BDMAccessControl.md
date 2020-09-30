

# BDMAccessControl

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Id of the BDM access control |  [optional]
**name** | **String** | BDM access control name |  [optional]
**state** | [**StateEnum**](#StateEnum) | BDM access control |  [optional]
**lastUpdatedBy** | **String** | If &#x60;lastUpdatedBy: -1&#x60; it means that the access control were last installed or updated by tenant_technical_user. |  [optional]
**lastUpdateDate** | **String** | Last date when the access control were installed or updated. |  [optional]



## Enum: StateEnum

Name | Value
---- | -----
INSTALLED | &quot;INSTALLED&quot;


## Implemented Interfaces

* Serializable


