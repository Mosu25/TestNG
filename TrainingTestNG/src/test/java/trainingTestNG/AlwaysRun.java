package trainingTestNG;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class AlwaysRun {
	
	
	//@Test annotation having 24 methods
	// enabled = false, alwaysRun = true both using same method enabled having high priority

	@Test(enabled = false, alwaysRun = true)
	public void signUp() {
		
		System.out.println("signUp");
	}
	
	@Test(description = "this method used to login the user")
	public void login() {
		
		System.out.println("login");
		throw new NoSuchElementException("Element Not Found");
		
	}
	
	
	  /**
	   * boolean alwaysRun() default false;
	   * The description for this method. The string used will appear in the HTML report and also on
	   * standard output if verbose &gt; 2.
	   *
	   * @return the value (default empty)
	   */
	
	@Test(dependsOnMethods = "trainingTestNG.AlwaysRun.login", alwaysRun = true)
	public void searchProduct() {
		
		System.out.println("Search Product");
	}
	
	
}
