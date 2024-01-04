package aircraftservice.com.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aircraftservice.com.entity.Aircraft;
import aircraftservice.com.exceptionHandalling.AircraftAlreadyExistsException;
import aircraftservice.com.repository.AircraftRepository;
import aircraftservice.com.service.AircraftService;

@Service
public class AircraftServiceImpl implements AircraftService{
    
	@Autowired
	private AircraftRepository aircraftRepository;
	
	
	@Override
	public Aircraft saveAircraft(Aircraft aircraft) throws AircraftAlreadyExistsException{
		return aircraftRepository.save(aircraft);
	}

	@Override
	public Optional<Aircraft> findByAirportId(Long aiportId) {
		 
		
		return Optional.empty();
	}

	@Override
	public List<Aircraft> findAllAircrafts() {
		 
		return aircraftRepository.findAll().parallelStream()
				.sorted(Comparator.comparing(Aircraft::getModel, Comparator.nullsLast(String::compareTo)))
				.collect(Collectors.toList());
                     
	}

	@Override
	public Aircraft updateAircraft(Long airportId, Aircraft aircraft) {
		 
		return null;
	}

	@Override
	public void deleteAirport(Long airportid) {
		 
		
	}

	@Override
	public List<Aircraft> findAllAircraftByMenufacturerAndModel(String menufacturer, String modelNo) {
		 
		return null;
	}

	@Override
	public List<Aircraft> findAllAircraftByMenufacturerOrModel(String menufacturer, String modelNo) {
	 
		return null;
	}

	@Override
	public List<Aircraft> findAllAircraftByFirstModelLetter(String modelno) {
		 
		return null;
	}

	@Override
	public List<Aircraft> findAllAircraftByFirstMenufacturerLetter(Character menufacturer) {
		Character chaar = null;
		if(menufacturer != null) {
			 chaar = Character.toUpperCase(menufacturer);
			
		}
	     Map<Character, List<Aircraft>> aircraftsByManufacturer= aircraftRepository.findAll()
	    		 .parallelStream().filter(a-> a.getManufacturer() != null)
	    		    .collect(Collectors.groupingBy(g-> g.getManufacturer().charAt(0)));
	     
	     return aircraftsByManufacturer.getOrDefault(chaar, Collections.emptyList());
	}

	@Override
	public Optional<Aircraft> findAircraftByModelno(String modelNo) {
		 
		return Optional.empty();
	}

	@Override
	public Optional<Aircraft> findAircraftbyMenufacturer(String menofacturer) {
	 
		return Optional.empty();
	}

	@Override
	public boolean isExistsAircraftByModelNo(String modelNo) {
		  Aircraft aircraft = aircraftRepository.findAll().parallelStream()
				  .filter(filter-> filter.getModel() != null)
				  .filter(ai-> ai.getModel().equalsIgnoreCase(modelNo))
				     .findFirst().orElse(null);
		  if(aircraft != null){
			 return true; 
		  }else {
			  return false; 
		  }
		  
                  
		
	}

	@Override
	public List<Aircraft> findAllAircraftInAircraftIds(List<Long> aircraftIds) {
		 
		return null;
	}

}
