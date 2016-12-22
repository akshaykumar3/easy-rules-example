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
//@Rule(name = "Shop Category Rule", description = "Takes action based on category of the shop")
public class ShopCategoryRule extends BasicRule {
	
	public ShopCategoryRule(Request request) {
		super("Shop Category Rule", "Takes action based on category of the shop", 3);
		this.request = request;
	}
	
	private Request request;
	public Response response = new Response();
	
	private List<String> allowedCategory = Arrays.asList("grocery", "apparael");
	
	@Condition
	public boolean evaluate() {
		return allowedCategory.contains(request.getShopCategory());
	}
	
	@Action
	public void execute() {
		System.out.println("ShopCategoryRule is OK.");
		this.response = new Response(true, "ABC", 10);
	}
	
}
