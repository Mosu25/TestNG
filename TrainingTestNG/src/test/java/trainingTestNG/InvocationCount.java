package trainingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class InvocationCount {
	
	
	/**
	 * invocationCount is used run the multiple times 
	 * invocationCount update as - (ex. -1,-2, 0) value, throw the Exception --- No tests found. Nothing was run
	 * 
	   * int invocationCount() default 1;
	   * The size of the thread pool for this method. The method will be invoked from multiple threads
	   * as specified by invocationCount. Note: this attribute is ignored if invocationCount is not
	   * specified
	   *
	   * @return the value (default 0)
	   */
	
	

	  /**
	   * long invocationTimeOut() default 0;
	   * The number of times this method should be invoked.
	   * 
	   * @return the value (default 1)
	   */

	@Test(invocationCount = 3, invocationTimeOut = 15000)
	public void Google() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();
		
	
	}
	
}
