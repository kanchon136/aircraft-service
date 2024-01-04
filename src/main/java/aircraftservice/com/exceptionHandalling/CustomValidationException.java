package aircraftservice.com.exceptionHandalling;

import java.util.HashMap;
import java.util.Map;

 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import aircraftservice.com.dto.AircraftResponseDto;

 

@RestControllerAdvice 
public class CustomValidationException {
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return ResponseEntity.badRequest().body(errors);
//    }
	
	@ExceptionHandler(value= MethodArgumentNotValidException.class)
	public ResponseEntity<AircraftResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errormap = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errormap.put(fieldName, errorMessage);
		});
		
		int statusCode = HttpStatus.BAD_REQUEST.value();
		String customMessage = "Validation Failed ,Please check the Request";
		
		AircraftResponseDto responseDto = new AircraftResponseDto("Error", customMessage, statusCode);
		
		return new ResponseEntity<>(responseDto,HttpStatus.BAD_REQUEST);
	}

}
