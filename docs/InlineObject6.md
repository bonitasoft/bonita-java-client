

# InlineObject6

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**variables** | **String** | Activity variables to update.  **Note**: if there is no data with the specified name in the activity, the update will be applied to the process data if a variable with the specified name exists.  **Note**: if the task definition includes a connector that is executed on finish and updates the value of a variable, the value set by the REST API call is overwritten.  |  [optional]
**state** | **String** | The target state of the activity - Execute a task: &#x60;completed&#x60; - Skip activity: &#x60;skipped&#x60; - Make this call after all failed connectors have been reset ![edition](https://img.shields.io/badge/edition-entreprise-blue) - Replay activity: &#x60;replay&#x60;  |  [optional]


## Implemented Interfaces

* Serializable


