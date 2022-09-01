package trainingTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoAnnotation {

	@BeforeMethod

	public void Browser() {

		System.out.println("Browser has been launched");
	}

	@AfterMethod

	public void TearDown() {

		System.out.println("Browser has been closed");
	}
	

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
