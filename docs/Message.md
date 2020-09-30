

# Message

Use this resource to send BPM message events. Message events are caught by processes using `catch message event` flow nodes (Start, intermediate, boundary or receive tasks).
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**messageName** | **String** | the message name |  [optional]
**targetProcess** | **String** | the target process name |  [optional]
**targetFlowNode** | **String** | the target FlowNode name |  [optional]
**messageContent** | [**Map&lt;String, MessageMessageContent&gt;**](MessageMessageContent.md) | the message content |  [optional]
**correlations** | [**Map&lt;String, MessageMessageContent&gt;**](MessageMessageContent.md) | the message correlations |  [optional]


## Implemented Interfaces

* Serializable


