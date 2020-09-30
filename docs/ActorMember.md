

# ActorMember

An actor member represents the association between the organization and the actor af a process. In an organization we have four member_types = USER, GROUP, ROLE and MEMBERSHIP (role in a group). You can assign a actor to a user by specifying a role and or a group, or specific user.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | actor member id |  [optional]
**actorId** | **String** | id of the actor for this mapping |  [optional]
**roleId** | **String** | id of role, or -1 if the member type is not role |  [optional]
**groupId** | **String** | id of group, or -1 if the member type is not group |  [optional]
**userId** | **String** | id of user, or -1 if the member type is not user |  [optional]


## Implemented Interfaces

* Serializable


