/**
 * 
 */
package kick;


import pojos.Request;
import pojos.Response;
import rules.CityRule;
import rules.ForceAllowRule;
import rules.ShopCategoryRule;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

import org.easyrules.api.RulesEngine;

import java.util.List;

/**
 * @author akshay.kumar
 *
 */
public class Initiator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		failureRule();
		forceAllowRule();
		shopCategoryRule();
		cityRule();
	}

	private static void cityRule() {
		Request request = new Request();
		request.setCity("delhi");
		request.setShopCategory("bar");
		request.setForceAllow(false);
		
		ShopCategoryRule categoryRule = new ShopCategoryRule(request);
		CityRule cityRule = new CityRule(request);
		ForceAllowRule forceAllowRule = new ForceAllowRule(request);
		
		RulesEngine rulesEngine = aNewRulesEngine()
				.withSkipOnFirstAppliedRule(true)
				.build();
		rulesEngine.registerRule(categoryRule);
		rulesEngine.registerRule(cityRule);
		rulesEngine.registerRule(forceAllowRule);
		
		rulesEngine.fireRules();

		Response response = cityRule.response;
		System.out.println("response = "+response.toString());
	}

	private static void shopCategoryRule() {
		Request request = new Request();
		request.setCity("bangalore");
		request.setShopCategory("grocery");
		request.setForceAllow(false);

		ShopCategoryRule categoryRule = new ShopCategoryRule(request);
		CityRule cityRule = new CityRule(request);
		ForceAllowRule forceAllowRule = new ForceAllowRule(request);

		RulesEngine rulesEngine = aNewRulesEngine()
				.withSkipOnFirstAppliedRule(true)
				.build();
		rulesEngine.registerRule(categoryRule);
		rulesEngine.registerRule(cityRule);
		rulesEngine.registerRule(forceAllowRule);

		rulesEngine.fireRules();

		Response response = categoryRule.response;
		System.out.println("response = "+response.toString());
	}

	private static void forceAllowRule() {
		Request request = new Request();
		request.setCity("bangalore");
		request.setShopCategory("bar");
		request.setForceAllow(true);

		ShopCategoryRule categoryRule = new ShopCategoryRule(request);
		CityRule cityRule = new CityRule(request);
		ForceAllowRule forceAllowRule = new ForceAllowRule(request);

		RulesEngine rulesEngine = aNewRulesEngine()
				.withSkipOnFirstAppliedRule(true)
				.build();
		rulesEngine.registerRule(categoryRule);
		rulesEngine.registerRule(cityRule);
		rulesEngine.registerRule(forceAllowRule);

		rulesEngine.fireRules();

		Response response = forceAllowRule.response;
		System.out.println("response = "+response.toString());
	}

	private static void failureRule() {
		Request request = new Request();
		request.setCity("bangalore");
		request.setShopCategory("bar");
		request.setForceAllow(false);

		ShopCategoryRule categoryRule = new ShopCategoryRule(request);
		CityRule cityRule = new CityRule(request);
		ForceAllowRule forceAllowRule = new ForceAllowRule(request);

		RulesEngine rulesEngine = aNewRulesEngine()
				.withSkipOnFirstAppliedRule(true)
				.build();
		rulesEngine.registerRule(categoryRule);
		rulesEngine.registerRule(cityRule);
		rulesEngine.registerRule(forceAllowRule);

		rulesEngine.fireRules();

		Response response = forceAllowRule.response;
		System.out.println("response = "+response.toString());
	}

}
