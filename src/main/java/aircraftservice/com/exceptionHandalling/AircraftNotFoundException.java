package aircraftservice.com.exceptionHandalling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import aircraftservice.com.dto.AircraftResponseDto;

@RestControllerAdvice
public class AircraftNotFoundException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;
	
private	AircraftResponseDto aircraftResponseDto;

public AircraftNotFoundException(AircraftResponseDto aircraftResponseDto) {
	super();
	this.aircraftResponseDto = aircraftResponseDto;
}

public AircraftNotFoundException() {
	super();
}

@ExceptionHandler(value = AircraftNotFoundException.class)
public ResponseEntity<AircraftResponseDto> handleAircraftNotFoundException(AircraftNotFoundException ex){
	
	return new ResponseEntity<AircraftResponseDto>(new AircraftResponseDto(getMessage(), getLocalizedMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
	//return null;
	
}



}
