/**
 * 
 */
package rules;

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
//@Rule(name = "Force Allow Rule", description = "Takes action if allowed forcefully")
public class ForceAllowRule extends BasicRule {
	
	public ForceAllowRule(Request request) {
		super("Force Allow Rule", "Takes action if allowed forcefully", 1);
		this.request = request;
	}

	private Request request;
	public Response response = new Response();
	
	@Condition
	public boolean evaluate() {
		return request.isForceAllow();
	}
	
	@Action
	public void execute() {
		System.out.println("ForceAllowRule is OK.");
		this.response = new Response(true, "ABC", 10);
	}
}
