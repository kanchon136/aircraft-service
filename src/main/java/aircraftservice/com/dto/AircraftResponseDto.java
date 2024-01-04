package aircraftservice.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AircraftResponseDto {
	private String status;
	private String message;
	private int statusCode;

}
