package trainingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class ThreadPoolSize {


	/**
	 * The size of the thread pool for this method.
	 * The method will be invoked from multiple threads as specified by invocationCount. 
	 * Note: this attribute is ignored if invocationCount is notspecified
		Returns:the value (default 0)
	 * 
	 */

	@Test(invocationCount = 2, threadPoolSize = 2)
	public void Google() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();
	}

	// invocationTimeout only using for if having invocation count
	// Timeout using without invocation count
	
	
	  /**
	   * long timeOut() default 0;
	   * The maximum number of milliseconds that the total number of invocations on this test method
	   * should take. 
	   * This annotation will be ignored if the attribute invocationCount is not specified
	   * on this method. If it hasn't returned after this time, it will be marked as a FAIL.
	   *
	   * @return the value (default 0)
	   */
	
	@Test(timeOut = 10000, expectedExceptions = {ThreadTimeoutException.class})
	public void facebook() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
	
}
}
