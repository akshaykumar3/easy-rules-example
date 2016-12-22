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
public class Request {
	private String city;
	private String shopCategory;
	private boolean forceAllow;
}
