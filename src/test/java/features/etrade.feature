Feature: etrade get API verification

  @etrade
  Scenario Outline: get quote api
    Given hit api with valid consumerKey and value and validate status code
    Given hit api without consumerKey and validate status code
    Given hit api with invalid consumerKey and validate status code
    Then validate response data
      | dateTime | 16:00:00 EDT 06-20-2012 |
      | dateTimeUTC  | 1340222400 |
      |quoteStatus|REALTIME|
      |ahFlag|false|
      |adjustedFlag|false|
      |ask|579.73|
      |askSize|100|
      |askTime|16:00:00 EDT 06-20-2012|
      |bid|574.04|
      |bidSize|100|
      |bidTime|16:00:00 EDT 06-20-2012|
      |changeClose|0.0|
      |changeClosePercentage|0.0|
      |companyName|GOOGLE INC CL A|
      |daysToExpiration|0|
      |dirLast|1|
      |dividend|0.0|
      |eps|32.99727|
      |estEarnings|43.448|
      |exDividendDate|1344947183|
      |high|0.0|
      |high52|670.25|
      |lastTrade|577.51|
      |low|0.0|
      |low52|473.02|
      |open|0.0|
      |openInterest|0|
      |previousClose|577.51|
      |previousDayVolume|2433786|
      |primaryExchange|NASDAQ NM|
      |symbolDescription|GOOGLE INC CL A|
      |totalVolume|0|
      |upc|0|
      |cashDeliverable|0|
      |marketCap|188282697750.000000|
      |sharesOutstanding|326025|
      |beta|0.93|
      |yield|0.0|
      |declaredDividend|0.0|
      |dividendPayableDate|0|
      |pe|17.5017|
      |week52LowDate|1308908670|
      |week52HiDate|1325673870|
      |intrinsicValue|0.0|
      |timePremium|0.0|
      |optionMultiplier|0.0|
      |contractSize|0.0|
      |expirationDate|0|
      |timeOfLastTrade|1341334800|
      |averageVolume|13896435|
      |securityType|EQ|
      |symbol|GOOG|

    Then validate headers
    Then validate response time
    Then validate query parameter "<param>"
    Examples:
      | param       |
      | Fundamental |
#      | Intraday    |
#      | Options     |
#      | Week_52     |
#      | Mf_detail   |



