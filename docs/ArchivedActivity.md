

# ArchivedActivity

Use this resource to retrieve finished activities (human or service tasks), call activities, and subprocesses.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | the archived activity id |  [optional]
**type** | [**ActivityTypeEnum**](ActivityTypeEnum.md) |  |  [optional]
**name** | **String** | the archived activity technical name |  [optional]
**displayName** | **String** | the human readable archived activity name |  [optional]
**description** | **String** | the archived activity description |  [optional]
**displayDescription** | **String** | the human readable archived activity description |  [optional]
**state** | [**ActivityStateEnum**](ActivityStateEnum.md) |  |  [optional]
**reachedStateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity reached the current state, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**lastUpdateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity was last updated, for example &#39;2014-10-17 16:05:42.626) |  [optional]
**dueDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this archived activity is due, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**priority** | [**ActivityPriorityEnum**](ActivityPriorityEnum.md) |  |  [optional]
**processId** | **String** | the process definition id of the case which define this archived activity |  [optional]
**parentCaseId** | **String** | the immediate containing case id (a.k.a process instance id) |  [optional]
**rootCaseId** | **String** | the top/root case id (a.k.a process instance id). In the case of an event sub process, &#x60;parentCaseId&#x60; will the id of the case called while &#x60;rootCaseId&#x60; will be the one from the caller case |  [optional]
**rootContainerId** | **String** | same as &#x60;rootCaseId&#x60; |  [optional]
**executedBy** | **String** | the id of the user who performed this archived activity. The archived activity has to be a human task otherwise its value will be 0 |  [optional]
**executedBySubstitute** | **String** | the id of the user who did actually performed the archived activity in the case of has been done in the name of someone else. Value is 0 otherwise |  [optional]
**actorId** | **String** | the id of the actor that can execute this archived activity, null otherwise |  [optional]
**assignedId** | **String** | the user id that this archived activity is assigned to, or 0 if it is unassigned |  [optional]
**assignedDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current archived activity was assigned, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**sourceObjectId** | **String** | the original id of the archived activity before it was archived |  [optional]
**archivedDate** | **String** | the date ((&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;)) when this archived activity was archived, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]


## Implemented Interfaces

* Serializable


