

# MessageMessageContent

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**value** | **String** |  | 
**type** | [**TypeEnum**](#TypeEnum) | Date types must be in the ISO-8601 format. When not set, the type is guessed using the value. Be careful as it can lead to type inconsistency in the target process (eg: a java.lang.Long is expected and the guessed type is a java.lang.Integer)  |  [optional]



## Enum: TypeEnum

Name | Value
---- | -----
LANG_STRING | &quot;java.lang.String&quot;
LANG_BOOLEAN | &quot;java.lang.Boolean&quot;
LANG_INTEGER | &quot;java.lang.Integer&quot;
LANG_DOUBLE | &quot;java.lang.Double&quot;
LANG_FLOAT | &quot;java.lang.Float&quot;
LANG_LONG | &quot;java.lang.Long&quot;
UTIL_DATE | &quot;java.util.Date&quot;
TIME_LOCALDATE | &quot;java.time.LocalDate&quot;
TIME_LOCALDATETIME | &quot;java.time.LocalDateTime&quot;
TIME_OFFSETDATETIME | &quot;java.time.OffsetDateTime&quot;


## Implemented Interfaces

* Serializable


