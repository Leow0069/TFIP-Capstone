package springbootbackend.serialisers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import springbootbackend.entity.Details;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomCardDeserialiser extends JsonDeserializer<Details> {

    // adding  new record to an owner that alr own some cars.
    @Override
    public Details deserialize(JsonParser parser, DeserializationContext deCtxt)
            throws IOException, JacksonException {
//        Owner carOwner = null;
        Details cDetails = null;
        JsonNode jsonNode = parser.readValueAsTree();

        try {
            cDetails = new Details();
            if (jsonNode.get("speciesName").isValueNode())
                cDetails.setSpcNameComposite(jsonNode.get("speciesName").asText());
            if (jsonNode.get("powerType").isValueNode())
                cDetails.setPwrTypeComposite(jsonNode.get("powerType").asText());
            if (jsonNode.get("boughtFrom").isValueNode())
                cDetails.setBuyFrom(jsonNode.get("boughtFrom").asText());
            if (jsonNode.get("shopName").isValueNode())
                cDetails.setShopName(jsonNode.get("shopName").asText());
            if (jsonNode.get("buyingCost").isValueNode())
                cDetails.setBuyPrice(BigDecimal.valueOf(jsonNode.get("buyingCost").asDouble()));
            if (jsonNode.get("highPrice").isValueNode())
                cDetails.setHighSellPrice(BigDecimal.valueOf(jsonNode.get("highPrice").asDouble()));
            if (jsonNode.get("quantity").isValueNode())
                cDetails.setQuantity(jsonNode.get("quantity").asInt());

//            List<Car> cars = new ArrayList<>();
//            if (jsonNode.get("cars").isContainerNode() && jsonNode.get("cars").isArray()) {
//                for (JsonNode carNode: jsonNode.get("cars")) {
//                    Car obj = new Car();
//                    obj.setBrand(carNode.get("brand").asText());
//                    obj.setModel(carNode.get("model").asText());
//                    obj.setMakeYear(carNode.get("makeYear").asText());
//                    obj.setPrice(carNode.get("price").asDouble());
//                    obj.setOwner(carOwner);
//
//                    cars.add(obj);
//                }
//            }
//            carOwner.setCars(cars);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cDetails;
    }

}
