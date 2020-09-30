

# CaseDocument

A document in an active case
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | documentId |  [optional]
**creationDate** | **String** | date and time |  [optional]
**author** | **String** | submittorUserId |  [optional]
**index** | **String** | index in a list of documents, or -1 for a single document |  [optional]
**contentMimetype** | **String** | MIME type |  [optional]
**caseId** | **String** | caseId |  [optional]
**contentStorageId** | **String** | storageId |  [optional]
**isInternal** | **Boolean** | &#x60;true&#x60; if  the the document object contains the content directly. &#x60;false&#x60; if the document is specified by URL so the document object contains a reference to the content, not the content itself. |  [optional]
**description** | **String** | description |  [optional]
**name** | **String** | name |  [optional]
**fileName** | **String** | filename |  [optional]
**submittedBy** | **String** | submittorUserId |  [optional]
**url** | **String** | urlForDownload |  [optional]
**version** | **String** | version |  [optional]


## Implemented Interfaces

* Serializable


