package step_definitions;

import apiModels.QuoteResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.Map;


public class Etrade_stepDefs {

    //validate status code when hitting api with valid consumerKey
    @Given("hit api with valid consumerKey and value and validate status code")
    public void hit_api_with_valid_consumerKey_and_value_and_validate_status_code() {
        Response response = RestAssured.given().header("consumerKey", "86c5adbf00b21eb70db2e9cad2a46995").get("https://apisb.etrade.com/v1/market/quote/GOOG");
        System.out.println("Status Code: " + response.statusCode());
        Assert.assertEquals("Status code verification failed", response.statusCode(), 200);
       // response.prettyPrint();
    }

    // validate status code when hitting api without consumerKey
    @Given("hit api without consumerKey and validate status code")
    public void hit_api_without_consumerKey_and_validate_status_code() {
        Response response = RestAssured.given().get("https://apisb.etrade.com/v1/market/quote/GOOG");
        System.out.println("Status Code: " + response.statusCode());
        Assert.assertEquals("Status code verification failed", response.statusCode(), 401);

    }

    // validate status code when hitting api with invalid consumerKey
    @Given("hit api with invalid consumerKey and validate status code")
    public void hit_api_with_invalid_consumerKey_and_validate_status_code() {
        Response response = RestAssured.given().header("consumerKey", "abc").get("https://apisb.etrade.com/v1/market/quote/GOOG");
        System.out.println("Status Code: " + response.statusCode());
        Assert.assertEquals("Status code verification failed", response.statusCode(), 401);
    }

    // validate that all attribute values are as expected
    @Then("validate response data")
    public void validate_response_data(io.cucumber.datatable.DataTable dataTable) throws JsonProcessingException {

        Response response = RestAssured.given().header("consumerKey", "86c5adbf00b21eb70db2e9cad2a46995").get("https://apisb.etrade.com/v1/market/quote/GOOG");

        Map<String, String> data = dataTable.asMap(String.class, String.class);

        XmlMapper xmlMapper = new XmlMapper();

        QuoteResponse quoteResponse = xmlMapper.readValue(response.asString(), QuoteResponse.class);

        //quoteResponse attribute values validation
        Assert.assertEquals(data.get("dateTime"), quoteResponse.getQuoteData().getDateTime());
        Assert.assertEquals(data.get("dateTimeUTC"), quoteResponse.getQuoteData().getDateTimeUTC());
        Assert.assertEquals(data.get("quoteStatus"), quoteResponse.getQuoteData().getQuoteStatus());
        Assert.assertEquals(data.get("ahFlag"), quoteResponse.getQuoteData().getAhFlag());

        // quoteStatus validation
        String quoteStatus = "REALTIME, DELAYED, CLOSING, EH_REALTIME, EH_BEFORE_OPEN, EH_CLOSED";
        Assert.assertTrue(quoteStatus.contains(quoteResponse.getQuoteData().getQuoteStatus()));
        System.out.println("Valid quoteStatus");

        //securityType validation
        String [] arr = {"BOND", "EQ", "INDX", "MF", "MMF", "OPTN"};
        for (int i=0; i<arr.length; i++) {
            if (arr[i].equals(quoteResponse.getQuoteData().getProduct().getSecurityType())) {
                System.out.println("Valid securutyType");
                Assert.assertEquals(data.get("securityType"),quoteResponse.getQuoteData().getProduct().getSecurityType());
            }
        }


        Assert.assertEquals(data.get("symbol"), quoteResponse.getQuoteData().getProduct().getSymbol());

        //all attribute values validation
        Assert.assertEquals(data.get("adjustedFlag"), quoteResponse.getQuoteData().getAll().getAdjustedFlag());
       // Assert.assertEquals(data.get("ask"), quoteResponse.getQuoteData().getAll().getAsk());
        Assert.assertEquals(data.get("askSize"), quoteResponse.getQuoteData().getAll().getAskSize());
        Assert.assertEquals(data.get("askTime"), quoteResponse.getQuoteData().getAll().getAskTime());
        //Assert.assertEquals(data.get("bid"), quoteResponse.getQuoteData().getAll().getBid());
        Assert.assertEquals(data.get("bidSize"), quoteResponse.getQuoteData().getAll().getBidSize());
        Assert.assertEquals(data.get("bidTime"), quoteResponse.getQuoteData().getAll().getBidTime());
        Assert.assertEquals(data.get("changeClose"), quoteResponse.getQuoteData().getAll().getChangeClose());
        Assert.assertEquals(data.get("changeClosePercentage"), quoteResponse.getQuoteData().getAll().getChangeClosePercentage());
        Assert.assertEquals(data.get("companyName"), quoteResponse.getQuoteData().getAll().getCompanyName());
        Assert.assertEquals(data.get("daysToExpiration"), quoteResponse.getQuoteData().getAll().getDaysToExpiration());
        Assert.assertEquals(data.get("dirLast"), quoteResponse.getQuoteData().getAll().getDirLast());
        Assert.assertEquals(data.get("dividend"), quoteResponse.getQuoteData().getAll().getDividend());
        Assert.assertEquals(data.get("eps"), quoteResponse.getQuoteData().getAll().getEps());
        Assert.assertEquals(data.get("estEarnings"), quoteResponse.getQuoteData().getAll().getEstEarnings());
        Assert.assertEquals(data.get("exDividendDate"), quoteResponse.getQuoteData().getAll().getExDividendDate());
        Assert.assertEquals(data.get("high"), quoteResponse.getQuoteData().getAll().getHigh());
        //Assert.assertEquals(data.get("high52"), quoteResponse.getQuoteData().getAll().getHigh52());
        Assert.assertEquals(data.get("lastTrade"), quoteResponse.getQuoteData().getAll().getLastTrade());
        Assert.assertEquals(data.get("low"), quoteResponse.getQuoteData().getAll().getLow());
       // Assert.assertEquals(data.get("low52"), quoteResponse.getQuoteData().getAll().getLow52());
        Assert.assertEquals(data.get("open"), quoteResponse.getQuoteData().getAll().getOpen());
        Assert.assertEquals(data.get("openInterest"), quoteResponse.getQuoteData().getAll().getOpenInterest());
        Assert.assertEquals(data.get("previousClose"), quoteResponse.getQuoteData().getAll().getPreviousClose());
        //Assert.assertEquals(data.get("previousDayVolume"), quoteResponse.getQuoteData().getAll().getPreviousDayVolume());
        Assert.assertEquals(data.get("primaryExchange"), quoteResponse.getQuoteData().getAll().getPrimaryExchange());
        Assert.assertEquals(data.get("symbolDescription"), quoteResponse.getQuoteData().getAll().getSymbolDescription());
        Assert.assertEquals(data.get("totalVolume"), quoteResponse.getQuoteData().getAll().getTotalVolume());
        Assert.assertEquals(data.get("upc"), quoteResponse.getQuoteData().getAll().getUpc());
        Assert.assertEquals(data.get("cashDeliverable"), quoteResponse.getQuoteData().getAll().getCashDeliverable());
        Assert.assertEquals(data.get("marketCap"), quoteResponse.getQuoteData().getAll().getMarketCap());
        Assert.assertEquals(data.get("sharesOutstanding"), quoteResponse.getQuoteData().getAll().getSharesOutstanding());
        Assert.assertEquals(data.get("beta"), quoteResponse.getQuoteData().getAll().getBeta());
        Assert.assertEquals(data.get("yield"), quoteResponse.getQuoteData().getAll().getYield());
        Assert.assertEquals(data.get("declaredDividend"), quoteResponse.getQuoteData().getAll().getDeclaredDividend());
        Assert.assertEquals(data.get("dividendPayableDate"), quoteResponse.getQuoteData().getAll().getDividendPayableDate());
        Assert.assertEquals(data.get("pe"), quoteResponse.getQuoteData().getAll().getPe());
        Assert.assertEquals(data.get("week52LowDate"), quoteResponse.getQuoteData().getAll().getWeek52LowDate());
        Assert.assertEquals(data.get("week52HiDate"), quoteResponse.getQuoteData().getAll().getWeek52HiDate());
        Assert.assertEquals(data.get("intrinsicValue"), quoteResponse.getQuoteData().getAll().getIntrinsicValue());
        Assert.assertEquals(data.get("timePremium"), quoteResponse.getQuoteData().getAll().getTimePremium());
        Assert.assertEquals(data.get("optionMultiplier"), quoteResponse.getQuoteData().getAll().getOptionMultiplier());
        Assert.assertEquals(data.get("contractSize"), quoteResponse.getQuoteData().getAll().getContractSize());
        Assert.assertEquals(data.get("expirationDate"), quoteResponse.getQuoteData().getAll().getExpirationDate());
        Assert.assertEquals(data.get("timeOfLastTrade"), quoteResponse.getQuoteData().getAll().getTimeOfLastTrade());
        Assert.assertEquals(data.get("averageVolume"), quoteResponse.getQuoteData().getAll().getAverageVolume());

    }



    // about dynamic attributes


    /*
    Since I don't have data to assert against to, I am not sure how to implement the additional bonus task
     for these dynamic attributes :
     ask, bid, previousDayVolume, high52, low52
     But theoretically I would do something like this:

     String expectedAsk = getFromDB("ask");
     String actualAsk = quoteResponse.getQuoteData().getAll().getAsk();
     Assert.assertEquals(expectedAsk, actualAsk)


     String expectedBid = getFromDB("bid");
     String actualBid = quoteResponse.getQuoteData().getAll().getBid();
     Assert.assertEquals(expectedBid, actualBid)


    and the same for the rest



     */


    // validate headers: contentType, Connection, Cache-Control
    @Then("validate headers")
    public void validate_headers() {

       Response response = RestAssured.given().header("consumerKey", "86c5adbf00b21eb70db2e9cad2a46995").get("https://apisb.etrade.com/v1/market/quote/GOOG");


        String expectedContentType = "application/xml";
        String actualContentType = response.contentType();
        Assert.assertEquals(expectedContentType,actualContentType);

        String expectedConnection = "Keep-Alive";
        String actualConnection = response.getHeader("Connection");
        Assert.assertEquals(expectedConnection, actualConnection);

        String expectedCacheControl = "no-cache, no-store";
        String actualCacheControl = response.getHeader("Cache-Control");
        Assert.assertEquals(expectedCacheControl, actualCacheControl);

    }

    //validate that response time is less than 5 seconds
    @Then("validate response time")
    public void validate_response_time() {

        Response response = RestAssured.given().header("consumerKey", "86c5adbf00b21eb70db2e9cad2a46995").get("https://apisb.etrade.com/v1/market/quote/GOOG");
        int maxresponseTime = 5000;
        Assert.assertTrue(response.getTime()<maxresponseTime);
        System.out.println("Response time ===>  "+ response.getTime());
    }

    // validate query parameters
    @Then("validate query parameter {string}")
    public void validate_query_parameter(String parameter) {

        Response response = RestAssured.given().header("consumerKey", "86c5adbf00b21eb70db2e9cad2a46995").get("https://apisb.etrade.com/v1/market/quote/GOOG?detailFlag="+ parameter);

        //response.prettyPrint();

        Assert.assertTrue(response.print().contains(parameter));

       // System.out.println(response.statusCode());


    }

}
