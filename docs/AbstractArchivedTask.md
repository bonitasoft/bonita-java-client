

# AbstractArchivedTask

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | the task id |  [optional]
**type** | **String** | the task type |  [optional]
**name** | **String** | the task technical name |  [optional]
**displayName** | **String** | the human readable task name |  [optional]
**description** | **String** | the task description |  [optional]
**displayDescription** | **String** | the human readable task description |  [optional]
**state** | [**StateEnum**](#StateEnum) | the current state of the task |  [optional]
**reachedStateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this task reached the current state for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**lastUpdateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this task was last updated for example &#39;2014-10-17 16:05:42.626) |  [optional]
**dueDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this task is due for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**priority** | **String** | the priority (string) of the current task |  [optional]
**processId** | **String** | the process definition id of the case which define this task |  [optional]
**parentCaseId** | **String** | the immediate containing case id (process instance id) |  [optional]
**parentTaskId** | **String** | the parent Task id |  [optional]
**rootCaseId** | **String** | the top/root case id (process instance id). In the case of an event sub process parentCaseId will the id of the case called while rootCaseId will be the one from the caller case |  [optional]
**rootContainerId** | **String** | same as rootCaseId |  [optional]
**executedBy** | **String** | the id of the user who performed this task. The task has to be a human task otherwise its value will be 0 |  [optional]
**executedBySubstitute** | **String** | the id of the user who did actually performed the task in the case of has been done in the name of someone else. Value is 0 otherwise |  [optional]
**actorId** | **String** | the id of the actor that can execute this task null otherwise |  [optional]
**assignedId** | **String** | the user id that this task is assigned to or 0 if it is unassigned |  [optional]
**assignedDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**isTerminal** | **Boolean** | True if the task is the last one in a flow |  [optional]
**archivedDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current task was assigned for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]



## Enum: StateEnum

Name | Value
---- | -----
READY_COMPLETED_FAILED | &quot;ready completed failed&quot;


## Implemented Interfaces

* Serializable


