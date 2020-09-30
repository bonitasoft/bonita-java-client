

# ModelCase

Case is an instance of a process. When you start a process, it creates a case.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | the identifier of the case |  [optional]
**endDate** | **String** | the date set when the case is closed |  [optional]
**failedFlowNodes** | **String** | count of failed flow nodes if parameter n&#x3D;failedFlowNodes is given |  [optional]
**startedBySubstitute** | **String** | the identifier of the substitute user (as Process manager or Administrator) who started the process. It can be also the substitute user if d&#x3D;startedBySubstitute is given. |  [optional]
**start** | **String** | the starting date of the case |  [optional]
**activeFlowNodes** | **String** | count of active flow nodes if parameter n&#x3D;activeFlowNodes is given |  [optional]
**state** | **String** | state: an enum that represent the state of the case, it can be INITIALIZING, STARTED, SUSPENDED, CANCELLED, ABORTED, COMPLETING, COMPLETED, ERROR, ABORTING |  [optional]
**rootCaseId** | **String** | the identifier of the container of the case |  [optional]
**startedBy** | **String** | the identifier of the user who started the case |  [optional]
**processDefinitionId** | **String** | the identifier of the process related of the case |  [optional]
**lastUpdateDate** | **String** | the date of the last update done on the case |  [optional]
**searchIndex1Label** | **String** | the 1st search index label (from 6.5, in Subscription editions only) |  [optional]
**searchIndex2Label** | **String** | the 2nd search index label (from 6.5, in Subscription editions only) |  [optional]
**searchIndex3Label** | **String** | the 3rd search index label (from 6.5, in Subscription editions only) |  [optional]
**searchIndex4Label** | **String** | the 4th search index label (from 6.5, in Subscription editions only) |  [optional]
**searchIndex5Label** | **String** | the 5th search index label (from 6.5, in Subscription editions only) |  [optional]
**searchIndex1Value** | **String** | the 1st search index value (from 6.5, in Subscription editions only) |  [optional]
**searchIndex2Value** | **String** | the 2nd search index value (from 6.5, in Subscription editions only) |  [optional]
**searchIndex3Value** | **String** | the 3rd search index value (from 6.5, in Subscription editions only) |  [optional]
**searchIndex4Value** | **String** | the 4th search index value (from 6.5, in Subscription editions only) |  [optional]
**searchIndex5Value** | **String** | the 5th search index value (from 6.5, in Subscription editions only) |  [optional]


## Implemented Interfaces

* Serializable


