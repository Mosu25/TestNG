package trainingTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoAnnotation1 {

	@BeforeClass

	public void Browser() {

		System.out.println("Browser has been launched");
	}

	@AfterClass

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
