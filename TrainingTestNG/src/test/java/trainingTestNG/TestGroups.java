package trainingTestNG;

import org.testng.annotations.Test;

public class TestGroups {
	
	
	/**
	 * <include name="smoke"> </include>
	 * <include name="sanity"> </include>
	 * <exclude name="sanity"></exclude> 
	 * output --- add to cart
	 */
	
	
	/**
	 * <include name="sanity"> </include>
	 * <exclude name="sanity"></exclude> 
	 * output--- Total tests run: 0 
	 * high precedence for exclude
	 * 
	 */
	
	
	/**
	 * <exclude name="sanity"></exclude>
	 * output---add to cart, search product
	 * 
	 */

	@Test(groups = {"smoke", "sanity"})
	public void signUp() {
		System.out.println("signUp");
	}

	@Test(groups = {"sanity"})
	public void signIn() {

		System.out.println("signIn");
	}

	@Test(groups = {"reg"})
	public void searchProduct() {

		System.out.println("search product");
	}

	@Test(groups = {"smoke"})
	public void addToCart() {
		System.out.println("add to cart");
	}

	@Test(groups = {"sanity"})
	public void signOut() {
		System.out.println("signOut");
	}


}
