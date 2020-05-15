package apiModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteData {

    @JacksonXmlProperty(localName = "dateTime")
    private String dateTime;
    @JacksonXmlProperty(localName = "All")
    private All All;
    @JacksonXmlProperty(localName = "ahFlag")
    private String ahFlag;
    @JacksonXmlProperty(localName = "dateTimeUTC")
    private String dateTimeUTC;
    @JacksonXmlProperty(localName = "Product")
    private Product Product;
    @JacksonXmlProperty(localName = "quoteStatus")
    private String quoteStatus;


    }
