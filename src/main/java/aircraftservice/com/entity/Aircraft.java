package aircraftservice.com.entity;

 
 

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aircraft {
    
	
	  @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "aircraft_id", updatable = false, nullable = false)
	private UUID aircraftId;
     
	@NotNull(message = "menufacturer is not null")
	private String manufacturer;
	 
	private String model;
	
	@Min(100)
	@Max(700)
	private Integer numberOfSeats;

}
