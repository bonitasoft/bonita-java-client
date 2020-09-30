

# FormMapping

Form Mapping specifies the mapping of a form to a process or a task. The mapping indicates the technology used to create the form, in the `target` attribute.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | the form mapping identifier |  [optional]
**processDefinitionId** | **String** | the process identifier related to this form mapping |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | the form mapping type |  [optional]
**target** | [**TargetEnum**](#TargetEnum) | the target |  [optional]
**task** | **String** | the task name when type is TASK - null otherwise |  [optional]
**pageId** | **String** | the custom page identifier when type is INTERNAL - null otherwise |  [optional]
**pageMappingKey** | **String** | the page mapping key part used to generate the form URL |  [optional]
**lastUpdateBy** | **String** | the identifier of the user who last updated this form mapping - 0 if no update has been done yet |  [optional]
**lastUpdateDate** | **String** | the last update date in milliseconds - null if no update has been done yet |  [optional]
**url** | **String** | the external URL (string) when type is URL - null otherwise |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
PROCESSSTART | &quot;PROCESSSTART&quot;
PROCESSOVERVIEW | &quot;PROCESSOVERVIEW&quot;
TASK | &quot;TASK&quot;



## Enum: TargetEnum

Name | Value
---- | -----
URL | &quot;URL&quot;
INTERNAL | &quot;INTERNAL&quot;
LEGACY | &quot;LEGACY&quot;
UNDEFINED | &quot;UNDEFINED&quot;
NONE | &quot;NONE&quot;


## Implemented Interfaces

* Serializable


