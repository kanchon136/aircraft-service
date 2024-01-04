package aircraftservice.com.exceptionHandalling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import aircraftservice.com.dto.AircraftResponseDto;
@RestControllerAdvice
public class AircraftAlreadyExistsException  extends RuntimeException{
 
	private static final long serialVersionUID = 1L;
	
	private String message;

	public AircraftAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

   public AircraftAlreadyExistsException() {
	   
   }
   
   @ExceptionHandler(value = AircraftAlreadyExistsException.class)
   public ResponseEntity<?> handleAircraftAlreadyExistsException(AircraftAlreadyExistsException ex) {
	   
	   return new ResponseEntity<>(new AircraftResponseDto("Error", "Aircraft Already Exists", HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
   }
	

}
