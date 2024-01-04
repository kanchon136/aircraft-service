package aircraftservice.com.service;

import java.util.List;
import java.util.Optional;

import aircraftservice.com.entity.Aircraft;
import aircraftservice.com.exceptionHandalling.AircraftAlreadyExistsException;
import aircraftservice.com.exceptionHandalling.AircraftNotFoundException;

public interface AircraftService {

	Aircraft saveAircraft(Aircraft aircraft) throws AircraftAlreadyExistsException;
	Optional<Aircraft> findByAirportId(Long aiportId) throws AircraftNotFoundException;
	List<Aircraft> findAllAircrafts();
	Aircraft updateAircraft(Long airportId, Aircraft aircraft);
	void deleteAirport(Long airportid);
	
	List<Aircraft> findAllAircraftByMenufacturerAndModel(String menufacturer, String modelNo);
	List<Aircraft> findAllAircraftByMenufacturerOrModel(String menufacturer, String modelNo);
	List<Aircraft> findAllAircraftByFirstModelLetter(String modelno);
	List<Aircraft> findAllAircraftByFirstMenufacturerLetter(Character menufacturer);
	Optional<Aircraft> findAircraftByModelno(String modelNo);
	Optional<Aircraft> findAircraftbyMenufacturer(String menofacturer);
	boolean isExistsAircraftByModelNo(String modelNo);
	List<Aircraft>findAllAircraftInAircraftIds(List<Long> aircraftIds);
	
}
