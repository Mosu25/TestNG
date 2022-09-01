package trainingTestNG;

import org.testng.annotations.Test;

public class DemoPriority {
	
	//Default running flow is alphabetical order
	//priority minus (ex. -1, -2 ) values accepted
	//Same priority given for multiple test method will run on alphabetical order
	//Same priority given- (not showing the exception)
	//priority default value is 0.
	

	@Test (priority=1)
	public void testRegistration() {
		
		System.out.println("Registration has been completed");
	}
	
	@Test (priority=2)
	public void TestLogin() {
		
		System.out.println("Login has been compelted");
	}
	
	@Test (priority=3)
	public void TestHomepage() {
		
		System.out.println("Homepage is Visible");
	}
		
}
