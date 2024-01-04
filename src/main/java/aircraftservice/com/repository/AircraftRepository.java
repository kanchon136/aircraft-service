package aircraftservice.com.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import aircraftservice.com.entity.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, UUID> {

	boolean existsByModel(String modelNo);

}
