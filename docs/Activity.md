

# Activity

Use this resource to retrieve activities (human or service tasks), call activities, and subprocesses currently running on the platform. It enables you to perform maintenance tasks like skipping or replaying a failed task and modifying variables. 
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | the activity id |  [optional]
**type** | [**ActivityTypeEnum**](ActivityTypeEnum.md) |  |  [optional]
**name** | **String** | the activity technical name |  [optional]
**displayName** | **String** | the human readable activity name |  [optional]
**description** | **String** | the activity description |  [optional]
**displayDescription** | **String** | the human readable activity description |  [optional]
**state** | [**ActivityStateEnum**](ActivityStateEnum.md) |  |  [optional]
**reachedStateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this activity reached the current state, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**lastUpdateDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this activity was last updated, for example &#39;2014-10-17 16:05:42.626) |  [optional]
**dueDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when this activity is due, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]
**priority** | [**ActivityPriorityEnum**](ActivityPriorityEnum.md) |  |  [optional]
**processId** | **String** | the process definition id of the case which define this activity |  [optional]
**parentCaseId** | **String** | the immediate containing case id (long, a.k.a process instance id) |  [optional]
**rootCaseId** | **String** | the top/root case id (long, a.k.a process instance id). In the case of an event sub process, parentCaseId will the id of the case called while rootCaseId will be the one from the caller case |  [optional]
**rootContainerId** | **String** | same as rootCaseId |  [optional]
**executedBy** | **String** | the id of the user who performed this activity. The activity has to be a human task otherwise its value will be 0 |  [optional]
**executedBySubstitute** | **String** | the id of the user who did actually performed the activity in the case of has been done in the name of someone else. Value is 0 otherwise |  [optional]
**actorId** | **String** | the id of the actor that can execute this activity, null otherwise |  [optional]
**assignedId** | **String** | the user id that this activity is assigned to, or 0 if it is unassigned |  [optional]
**assignedDate** | **String** | the date (&#39;yyyy-MM-dd HH:mm:ss.SSS&#39;) when the current activity was assigned, for example &#39;2014-10-17 16:05:42.626&#39; |  [optional]


## Implemented Interfaces

* Serializable


