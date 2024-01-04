package aircraftservice.com.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aircraftservice.com.dto.AircraftResponseDto;
import aircraftservice.com.entity.Aircraft;
import aircraftservice.com.exceptionHandalling.AircraftAlreadyExistsException;
import aircraftservice.com.service.AircraftService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

	@Autowired
	private AircraftService aircraftService;

	@GetMapping("/")
	public String testing() {
		return "Aircraft service is running..!";
	}

	@PostMapping("/saveaircraft")
	public ResponseEntity<AircraftResponseDto> saveAircraft(@Valid @RequestBody Aircraft aircraft)
			throws AircraftAlreadyExistsException {

		if (aircraftService.isExistsAircraftByModelNo(aircraft.getModel())) {
			throw new AircraftAlreadyExistsException();
		}

		try {
			aircraftService.saveAircraft(aircraft);
			return new ResponseEntity<AircraftResponseDto>(
					new AircraftResponseDto("Success", "Aircraft save successfully", HttpStatus.OK.value()),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<AircraftResponseDto>(
					new AircraftResponseDto("Error", "Aircraft not saved", HttpStatus.INTERNAL_SERVER_ERROR.value()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAllAircrafts")
	public ResponseEntity<List<Aircraft>> findAllAircrafts(){
		
		return new ResponseEntity<List<Aircraft>>(aircraftService.findAllAircrafts(),HttpStatus.OK);
	}
	
 @GetMapping("/findAllByManufacturerCharacter/{cha}")
 public ResponseEntity<List<Aircraft>> findAllAircraftByFirstMenufacturerLetter(@PathVariable("cha") char cha){
	 
	 List<Aircraft> menofacturerAircrafts= aircraftService.findAllAircraftByFirstMenufacturerLetter(cha);
	 if(menofacturerAircrafts.isEmpty() && menofacturerAircrafts !=null) {
		 return new ResponseEntity<List<Aircraft>>(menofacturerAircrafts.parallelStream()
				 .filter(f-> f.getModel() != null && !f.getModel().isBlank())
				   .sorted(Comparator.comparing(Aircraft::getModel, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER)))
				   .toList(), HttpStatus.OK);
	 }else {
		 return new ResponseEntity<List<Aircraft>>(menofacturerAircrafts,HttpStatus.OK); 
	 }
		
		
	}
 
 
 
 
 
 
 
 
 
 
 

}
