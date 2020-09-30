

# ArchivedFlowNode

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | the flow node id  |  [optional]
**displayDescription** | **String** | the human readable flow node description  |  [optional]
**executedBySubstitute** | **String** | the id of the user who really performed this flow node in case where a substitute did it, or 0 if the flow node was not performed by a substitute |  [optional]
**caseId** | **String** | the case id that is associated with this flow node |  [optional]
**parentCaseId** | **String** | the parent case id that is associated with this flow node&#39;s case |  [optional]
**rootCaseId** | **String** | the root case initiator id that is associated with this flow node&#39;s case |  [optional]
**processId** | **String** | the process id that is associated with this flow node |  [optional]
**rootContainerId** | **String** | the root process id of the root case that is associated with this flow node |  [optional]
**state** | **String** | the current state of the flow node (ready, completed, failed) |  [optional]
**type** | **String** | the flow node type  |  [optional]
**assignedId** | **String** | the user id that this flow node is assigned to, or 0 if it is unassigned |  [optional]
**assignedDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current flow node was assigned, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**executedBy** | **String** | the id of the user who executed the flow node, or 0 if the flow node has not been executed |  [optional]
**priority** | **String** | the priority of the current flow node |  [optional]
**actorId** | **String** | the id of the actor that can execute this flow node, null otherwise |  [optional]
**description** | **String** | the flow node description  |  [optional]
**name** | **String** | the flow node name  |  [optional]
**reachedStateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this flow node reached the current state, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**displayName** | **String** | the display name of this flow node |  [optional]
**dueDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this flow node is due, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**lastUpdateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this flow node was last updated, for example &#39;2014-10-17 16:05:42.626) |  [optional]
**parentTaskIdDoubleQuote** | **String** | in the case of a subtask, the parent task id  |  [optional]
**sourceObjectId** | **String** | the original id of the flowNode before it was archived |  [optional]
**archivedDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]


## Implemented Interfaces

* Serializable


