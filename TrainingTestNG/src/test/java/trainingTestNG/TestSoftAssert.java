package trainingTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssert {

	@Test
	public void facebook() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("formathtyhappier",Keys.ENTER);
		Thread.sleep(3000);
		
		SoftAssert sa = new SoftAssert(); //object creation

		// Title Assertion

		String expectedTitle = "Log in to Facebook";
		String actualTitle = driver.getTitle();
		sa.assertEquals(actualTitle, expectedTitle, "Title is Mismatched");

		//URL Assertion

		String expectedUrl = "https://www.facebook.com/";
		String actualUrl = driver.getCurrentUrl();
		sa.assertNotEquals(actualUrl, expectedUrl, "URL is Mismatched");

		//Text Assertion

		String expectedText = "";
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		sa.assertEquals(actualText, expectedText, "User Name Text is Mismatched");

		//Border Assertion
		//Border Hex value #f02849 convert to RGB value

		String expectedBorder = "1px solid rgb(240, 40, 73)";
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		sa.assertEquals(actualBorder, expectedBorder, "User Name Border is Mismatched");

		//Error Message Assertion

		String expectedErrorMsg = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualErrorMsg = driver.findElement(By.xpath("//div[@id='email_container']/div[last()]")).getText();
		sa.assertEquals(actualErrorMsg, expectedErrorMsg, "User Name Border is Mismatched");

		driver.quit();
		sa.assertAll();

	}
}

