package springbootbackend.controller;

import org.springframework.web.bind.annotation.*;
import springbootbackend.entity.Details;
import springbootbackend.entity.DetailsId;
import springbootbackend.entity.PowerType;
import springbootbackend.entity.Species;
import springbootbackend.exception.ResourceNotFoundException;
import springbootbackend.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import springbootbackend.repository.PowerTypeRepository;
import springbootbackend.repository.SpeciesRepository;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController // to specify these are all rest endpoints
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class CardController {
    @Autowired
    private DetailsRepository detailsRepository;
    @Autowired
    private PowerTypeRepository powerTypeRepository;
    @Autowired
    private SpeciesRepository speciesRepository;

    @GetMapping("/allCards")
    public List<Details> getAllCards() {
        List<Details> detailsList = this.detailsRepository.findAll();
        return detailsList;
        }


        // TODO if card has same species, powertype, shop and price name, then increment the quantity by 1

//    @PostMapping("/addCard")
//    public Details createDetails (@RequestBody Details details) {
//        // Check if the composite key parameters are null
//        if (details.getSpcNameComposite() == null ||
//                details.getPwrTypeComposite() == null ||
//                details.getBuyFrom() == null ||
//                details.getShopName() == null ||
//                details.getBuyPrice() == null
////                || details.getQuantity() == null
//        ) {
//            throw new IllegalArgumentException("Invalid composite key parameters");
//        }
//
//        Species species = this.speciesRepository.findById(details.getSpcNameComposite()).orElseThrow(()->new IllegalArgumentException());
//        PowerType powerType = this.powerTypeRepository.findById(details.getPwrTypeComposite()).orElseThrow(()-> new IllegalArgumentException());
//        details.setSpcName(species);
//        details.setPwrType(powerType);
//        return detailsRepository.save(details);
//    }

    @PostMapping("/addCard")
    public Details createDetails(@RequestBody Details details) {
        // Check if the composite key parameters are null
//        if (details.getSpcNameComposite() == null ||
//                details.getPwrTypeComposite() == null ||
//                details.getBuyFrom() == null ||
//                details.getShopName() == null ||
//                details.getBuyPrice() == null
//        ) {
//            throw new IllegalArgumentException("Invalid composite key parameters");
//        }

        // Create a Details object with the composite key params
        DetailsId detailsId = new DetailsId(
                details.getSpcNameComposite(),
                details.getPwrTypeComposite(),
                details.getBuyFrom(),
                details.getShopName(),
                details.getBuyPrice());

        // Check if the card already exists based on the composite key
        Details existingDetails = detailsRepository.findById(detailsId).orElse(null);

        if (existingDetails != null) {
            // Card already exists, increment the quantity
//            existingDetails.setQuantity(existingDetails.getQuantity() + details.getQuantity());
//            return detailsRepository.save(existingDetails);
            throw new ResourceNotFoundException("Card already exists");
        } else {
            // Card does not exist, save it as a new entry
            Species species = this.speciesRepository.findById(details.getSpcNameComposite())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid species"));
            PowerType powerType = this.powerTypeRepository.findById(details.getPwrTypeComposite())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid power type"));
            details.setSpcName(species);
            details.setPwrType(powerType);
            return detailsRepository.save(details);
        }
    }


    // ResponseEntity represents the whole HTTP response: status code, headers, and body.
    // As a result, we can use it to fully configure the HTTP response.
    @GetMapping("/detailsId") //TODO https://chat.openai.com/share/8d523a41-8ab1-4de6-a4e8-b57f3e7a5923
    public ResponseEntity<Details> getSpecificCard(
            @RequestParam("spcName") String spcName,
            @RequestParam("pwrType") String pwrType,
            @RequestParam("buyFrom") String buyFrom,
            @RequestParam("shopName") String shopName,
            @RequestParam("buyPrice") BigDecimal buyPrice
//            ,
//            @RequestParam("quantity") int quantity
    ) {
        // Create a DetailsId object with the composite key parameters
        DetailsId detailsId = new DetailsId(spcName, pwrType, buyFrom, shopName, buyPrice
//                , quantity
        );

        // Retrieve the specific card using the composite key from the database
        // If the card is not found, return a response with a status code of 404 (Not Found)
        Details details = detailsRepository.findById(detailsId).orElseThrow(() -> new ResourceNotFoundException("Card not exist"));

        // Return the card with a status code of 200 (OK)
        return ResponseEntity.ok(details);
    }


    @PutMapping("/updateCard")
    public ResponseEntity<Details> updateDetails(
//            @RequestParam("spcName") String spcName,
//            @RequestParam("pwrType") String pwrType,
//            @RequestParam("buyFrom") String buyFrom,
//            @RequestParam("shopName") String shopName,
//            @RequestParam("buyPrice") BigDecimal buyPrice,
//            @RequestParam("quantity") int quantity,
            @RequestBody Details updatedDetails
    ) {
        // Create a DetailsId object with the composite key parameters
        DetailsId detailsId = new DetailsId(updatedDetails.getSpcNameComposite(),
                updatedDetails.getPwrTypeComposite(),
                updatedDetails.getBuyFrom(),
                updatedDetails.getShopName(),
                updatedDetails.getBuyPrice());

        // Retrieve the existing details from the database based on the composite key
       Details details = detailsRepository.findById(detailsId).orElseThrow(()-> new IllegalArgumentException());
//        if (details != null) {

            // Check if the details match the existing details
//            if (existingDetails.getSpcNameComposite().equals(updatedDetails.getSpcNameComposite()) &&
//                    existingDetails.getPwrTypeComposite().equals(updatedDetails.getPwrTypeComposite()) &&
//                    existingDetails.getBuyFrom().equals(updatedDetails.getBuyFrom()) &&
//                    existingDetails.getShopName().equals(updatedDetails.getShopName()) &&
//                    existingDetails.getBuyPrice().equals(updatedDetails.getBuyPrice())) {

//                // Details already exist, increment the quantity
//                int newQuantity = details.getQuantity() + updatedDetails.getQuantity();
//            details.setQuantity(newQuantity);
                // Update other fields as needed
            details.setQuantity(updatedDetails.getQuantity());
            details.setHighSellPrice(updatedDetails.getHighSellPrice());
                // Update other fields as needed

                // Save the updated details back to the database
                Details savedDetails = detailsRepository.save(details);

                return ResponseEntity.ok(savedDetails);
//            }
//        else {
                // Details are different, update all fields
//                existingDetails.setSpcNameComposite(updatedDetails.getSpcNameComposite());
//                existingDetails.setPwrTypeComposite(updatedDetails.getPwrTypeComposite());
//                existingDetails.setBuyFrom(updatedDetails.getBuyFrom());
//                existingDetails.setShopName(updatedDetails.getShopName());
//                existingDetails.setBuyPrice(updatedDetails.getBuyPrice());
//                existingDetails.setQuantity(updatedDetails.getQuantity());
//                existingDetails.setHighSellPrice(updatedDetails.getHighSellPrice());
                // Update other fields as needed

                // Save the updated details back to the database
//                Details savedDetails = detailsRepository.save(existingDetails);

//                return ResponseEntity.ok(savedDetails);
//            }

//        else {
//            return ResponseEntity.notFound().build();
//        }
    }
}
