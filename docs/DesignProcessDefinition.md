

# DesignProcessDefinition

Represents the Design Definition of a process. It gives access to process attributes.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**displayName** | **String** | The process definition display name |  [optional]
**displayDescription** | **String** | The process definition display description name |  [optional]
**flowElementContainer** | [**FlowElementContainerDefinition**](FlowElementContainerDefinition.md) |  |  [optional]
**parameters** | [**List&lt;DesignProcessDefinitionParameters&gt;**](DesignProcessDefinitionParameters.md) | The process parameter definitions |  [optional]
**actorsList** | [**List&lt;ActorDefinition&gt;**](ActorDefinition.md) | The list of process actor definitions |  [optional]
**actorInitiator** | [**ActorDefinition**](ActorDefinition.md) |  |  [optional]
**stringIndexLabels** | **List&lt;String&gt;** | The process definition labels |  [optional]
**stringIndexValues** | [**List&lt;Expression&gt;**](Expression.md) | The process definition expressions |  [optional]
**contract** | [**DesignProcessDefinitionContract**](DesignProcessDefinitionContract.md) |  |  [optional]
**context** | [**List&lt;DesignProcessDefinitionContext&gt;**](DesignProcessDefinitionContext.md) | The process definition expressions |  [optional]


## Implemented Interfaces

* Serializable


