

# ActivityVariable

This resource enables you to retrieve the value of a specific variable name for a specific case (or process instance). Only persistent variables are concerned by this resource, not transient variables.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**tenantId** | **String** | The ID of the tenant where the current user is logged in (technical information) |  [optional]
**tenantIdString** | **String** | number (since 7.0.1) |  [optional]
**id** | **String** | The identifier of the variable |  [optional]
**idString** | **String** | number (since 7.0.1) |  [optional]
**name** | **String** | The name of the activity variable |  [optional]
**description** | **String** | The description of the variable if any |  [optional]
**transientData** | **String** | FALSE |  [optional]
**className** | **String** | The fully qualified class name of the variable type |  [optional]
**containerId** | **String** | The ID of the activity containing this variable (same as the one passed as parameter) if the variable is defined at activity level or ID of the process instance if the variable is defined on the process |  [optional]
**containerIdString** | **String** | number (since 7.0.1) |  [optional]
**containerType** | [**ContainerTypeEnum**](#ContainerTypeEnum) | ACTIVITY_INSTANCE | PROCESS_INSTANCE depending on whether the variable is defined at activity or process level. |  [optional]
**value** | **String** | the value of this variable. The format of the value depends on the type of the variable |  [optional]



## Enum: ContainerTypeEnum

Name | Value
---- | -----
ACTIVITY_INSTANCE | &quot;ACTIVITY_INSTANCE&quot;
PROCESS_INSTANCE | &quot;PROCESS_INSTANCE&quot;


## Implemented Interfaces

* Serializable


