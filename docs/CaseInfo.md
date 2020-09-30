

# CaseInfo

Retrieves information about a case. It returns counters for each flow node in the case, showing the number of flow node instances that are in completed, ready, or failed state. If there are no flow node instances in a given state, no counter is returned for that state for the flow node.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | case identifier |  [optional]
**flowNodeStatesCounters** | [**Map&lt;String, CaseInfoFlowNodeStatesCounters&gt;**](CaseInfoFlowNodeStatesCounters.md) | flow nodes counters |  [optional]


## Implemented Interfaces

* Serializable


