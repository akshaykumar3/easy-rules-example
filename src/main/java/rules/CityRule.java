/**
 * 
 */
package rules;

import java.util.Arrays;
import java.util.List;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.easyrules.core.BasicRule;

import pojos.Request;
import pojos.Response;

/**
 * @author akshay.kumar
 *
 */
//@Rule(name = "City Rule", description = "Takes action based on city of the shop")
public class CityRule extends BasicRule {
	
	public CityRule(Request request) {
		super("City Rule", "Takes action based on city of the shop", 2);
		this.request = request;
	}

	private Request request;
	public Response response = new Response();

	private List<String> allowedCity = Arrays.asList("delhi", "kolkata");
	
	@Condition
	public boolean evaluate() {
		return allowedCity.contains(request.getCity());
	}
	
	@Action
	public void execute() {
		System.out.println("CityRule is OK.");
		this.response = new Response(true, "ABC", 10);
	}
}
