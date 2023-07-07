package springbootbackend.serialisers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import springbootbackend.entity.Details;

import java.io.IOException;
import java.util.List;

public class CustomDetailsSerialiser extends JsonSerializer<Details> {

    @Override
    public void serialize(Details value, JsonGenerator jgen, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
//        jgen.writeString("card details");
        if (value != null) {
            jgen.writeStartObject();
            jgen.writeStringField("speciesName", value.getSpcNameComposite());
            jgen.writeStringField("powerType", value.getPwrTypeComposite());
            jgen.writeStringField("boughtFrom", value.getBuyFrom());
            jgen.writeStringField("shopName", value.getShopName());
            jgen.writeNumberField("buyingCost", value.getBuyPrice());
            jgen.writeNumberField("highPrice", value.getHighSellPrice());
            jgen.writeNumberField("quantity", value.getQuantity());
            jgen.writeStringField("back_story", value.getSpcName().getSpcBackground());

//            // Writing nested JSON information for array of generation types the card can be found in
//            List<Details> details = value.getSpcName().getDetailsList();
//            jgen.writeFieldName("card details");
//            jgen.writeStartArray();
//            for (Details detail : details) {
//                jgen.writeStartObject();
//                jgen.writeStringField("pokemon species", detail.getSpcNameComposite());
//                jgen.writeStringField("power type", detail.getPwrTypeComposite());
//                jgen.writeStringField("bought from", detail.getBuyFrom());
//                jgen.writeStringField("shop name", detail.getShopName());
//                jgen.writeNumberField("buying cost", detail.getBuyPrice());
//                jgen.writeNumberField("TCG pricing", detail.getHighSellPrice());
//                jgen.writeNumberField("cards on hand", detail.getQuantity());
//
//                jgen.writeEndObject();
//            }
//            jgen.writeEndArray();
//
//            // Writing nested JSON information for array of details of each card
//            List<CardDetails> cdet = value.getCardDetailsList();
//            jgen.writeFieldName("details");
//            jgen.writeStartArray();
//            for (CardDetails cardDetails : cdet) {
//                jgen.writeStartObject();
//                jgen.writeNumberField("cardDetailsId", cardDetails.getCardDetailsId());
//                jgen.writeStringField("boughtFrom", cardDetails.getPlatformBought());
//                jgen.writeNumberField("buyingCost", cardDetails.getPriceBought());
//                jgen.writeEndObject();
//            }
//            jgen.writeEndArray();
//
            jgen.writeEndObject();
        }
//    }
    }
}
