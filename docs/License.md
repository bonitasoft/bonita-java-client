

# License

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**licenseStartDate** | **String** | date with format &#x60;yyyy-MM-dd&#x60; - first day (included) of license file validity |  [optional]
**duration** | **String** | number of days for license file validity |  [optional]
**licenseExpirationDate** | **String** | date with format &#x60;yyyy-MM-dd&#x60; - last day (included) of license file validity |  [optional]
**numberOfCPUCores** | **String** | number of CPUs |  [optional]
**edition** | **String** | name of the Bonita edition enabled by the license |  [optional]
**licenseMode** | **String** | available mode enabled by the license |  [optional]
**requestKey** | **String** | request key to use to generate a new license on the customer portal If you have a subscription that specifies case-counter licensing, additional fields are present:  |  [optional]
**subscriptionStartPeriod** | **String** | date with format &#x60;yyyy-MM-dd&#x60; - first day (included) of current period for number of cases provisioned |  [optional]
**subscriptionEndPeriod** | **String** | date with format &#x60;yyyy-MM-dd&#x60; - last day (included) of current period for number of cases provisioned |  [optional]
**caseCounterLimit** | **Long** | number of cases provisioned for period between &#x60;subscriptionStartPeriod&#x60; and &#x60;subscriptionEndPeriod&#x60; |  [optional]
**caseCounter** | **Long** | number of consumed cases for period between &#x60;subscriptionStartPeriod&#x60; and &#x60;subscriptionEndPeriod&#x60; |  [optional]


## Implemented Interfaces

* Serializable


