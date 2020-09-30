

# ProcessSupervisor

The process supervisor has management rights over a process. He can configure and monitor it. You can give the ProcessSupervisor rights to some users by specifying a role and or a group, or a specific user. In order to be able to manage the processes he supervises in the portal, a user should also have the profile `Process Manager`
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**processId** | **String** | Id of the process |  [optional]
**roleId** | **String** | Id of role, or -1 if the supervisor type is not role or membership |  [optional]
**groupId** | **String** | Id of group, or -1 if the supervisor type is not group or membership |  [optional]
**userId** | **String** | Id of user, or -1 if the supervisor type is not user |  [optional]


## Implemented Interfaces

* Serializable


