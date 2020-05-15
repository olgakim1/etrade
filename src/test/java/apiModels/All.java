package apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class All {
    @JacksonXmlProperty(localName = "totalVolume")
    private String totalVolume;
    @JacksonXmlProperty(localName = "cashDeliverable")
    private String cashDeliverable;
    @JacksonXmlProperty(localName = "companyName")
    private String companyName;
    @JacksonXmlProperty(localName = "lastTrade")
    private String lastTrade;
    @JacksonXmlProperty(localName = "primaryExchange")
    private String primaryExchange;
    @JacksonXmlProperty(localName = "bidTime")
    private String bidTime;
    @JacksonXmlProperty(localName = "high")
    private String high;
    @JacksonXmlProperty(localName = "bidExchange")
    private String bidExchange;
    @JacksonXmlProperty(localName = "askSize")
    private String askSize;
    @JacksonXmlProperty(localName = "dividendPayableDate")
    private String dividendPayableDate;
    @JacksonXmlProperty(localName = "marketCap")
    private String marketCap;
    @JacksonXmlProperty(localName = "previousDayVolume")
    private String previousDayVolume;
    @JacksonXmlProperty(localName = "daysToExpiration")
    private String daysToExpiration;
    @JacksonXmlProperty(localName = "eps")
    private String eps;
    @JacksonXmlProperty(localName = "upc")
    private String upc;
    @JacksonXmlProperty(localName = "symbolDescription")
    private String symbolDescription;
    @JacksonXmlProperty(localName = "adjustedFlag")
    private String adjustedFlag;
    @JacksonXmlProperty(localName = "nextEarningDate")
    private String nextEarningDate;
    @JacksonXmlProperty(localName = "timeOfLastTrade")
    private String timeOfLastTrade;
    @JacksonXmlProperty(localName = "timePremium")
    private String timePremium;
    @JacksonXmlProperty(localName = "estEarnings")
    private String estEarnings;
    @JacksonXmlProperty(localName = "openInterest")
    private String openInterest;
    @JacksonXmlProperty(localName = "dirLast")
    private String dirLast;
    @JacksonXmlProperty(localName = "optionStyle")
    private String optionStyle;
    @JacksonXmlProperty(localName = "declaredDividend")
    private String declaredDividend;
    @JacksonXmlProperty(localName = "high52")
    private String high52;
    @JacksonXmlProperty(localName = "week52LowDate")
    private String week52LowDate;
    @JacksonXmlProperty(localName = "previousClose")
    private String previousClose;
    @JacksonXmlProperty(localName = "low")
    private String low;
    @JacksonXmlProperty(localName = "low52")
    private String low52;
    @JacksonXmlProperty(localName = "yield")
    private String yield;
    @JacksonXmlProperty(localName = "dividend")
    private String dividend;
    @JacksonXmlProperty(localName = "contractSize")
    private String contractSize;
    @JacksonXmlProperty(localName = "changeClosePercentage")
    private String changeClosePercentage;
    @JacksonXmlProperty(localName = "sharesOutstanding")
    private String sharesOutstanding;
    @JacksonXmlProperty(localName = "beta")
    private String beta;
    @JacksonXmlProperty(localName = "expirationDate")
    private String expirationDate;
    @JacksonXmlProperty(localName = "askTime")
    private String askTime;
    @JacksonXmlProperty(localName = "bidSize")
    private String bidSize;
    @JacksonXmlProperty(localName = "exDividendDate")
    private String exDividendDate;
    @JacksonXmlProperty(localName = "optionMultiplier")
    private String optionMultiplier;
    @JacksonXmlProperty(localName = "pe")
    private String pe;
    @JacksonXmlProperty(localName = "averageVolume")
    private String averageVolume;
    @JacksonXmlProperty(localName = "ask")
    private String ask;
    @JacksonXmlProperty(localName = "bid")
    private String bid;
    @JacksonXmlProperty(localName = "changeClose")
    private String changeClose;
    @JacksonXmlProperty(localName = "intrinsicValue")
    private String intrinsicValue;
    @JacksonXmlProperty(localName = "week52HiDate")
    private String week52HiDate;
    @JacksonXmlProperty(localName = "open")
    private String open;


}
