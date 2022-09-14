package trainingTestNG;

import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test()
	public void signup() {
		
		System.out.println("Signup completed");
	}
	
	
	@Test(dependsOnMethods = "signup")
	public void signin() {
		
		System.out.println("Signin Completed");
	}
	
	/**
	 * dependsOnMethods and priority both using same method dependsOnMethod having higher precedence
	 * if using dependsOnMethod from other package method, must use package.classname.methodname when 
	 * 
	 * ex.addToCart
	 */
	
	@Test(dependsOnMethods = "signin")
public void searchProduct() {
		
				System.out.println("Product Search");
				throw new  RuntimeException();
	}
	
	
	@Test(dependsOnMethods = "trainingTestNG.DependsOnMethod.searchProduct",priority = 1)
	public void addToCart() {
		
		System.out.println("Product added to cart");
	}
	
}
