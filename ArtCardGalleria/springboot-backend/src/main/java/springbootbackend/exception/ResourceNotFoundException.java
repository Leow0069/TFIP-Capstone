package springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException (String message) {
        super(message);
    }
}

// should be placed in the controller folder since its for the controller.
//@RestControllerAdvice <<< 05_restServices_02
//public class ExceptionControllerAdvice {
//    @ExceptionHandler(NotEnoughMoneyException.class)
//    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
//        ErrorDetails errorDetails = new ErrorDetails();
//        errorDetails.setMessage("Not enough money to make the payment.");
//        return ResponseEntity.badRequest().body(errorDetails);
//    }
//}