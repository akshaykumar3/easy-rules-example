/**
 * 
 */
package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author akshay.kumar
 *
 */
@Getter
@Setter
@ToString
public class Response {
	
	public Response() {
		
	}
	
	public Response(boolean allowParkingSpace, String parkingId, int spaceLength) {
		this.allowParkingSpace = allowParkingSpace;
		this.parkingId = parkingId;
		this.spaceLength = spaceLength;
	}
	
	private boolean allowParkingSpace;
	private String parkingId;
	private int spaceLength;
}
