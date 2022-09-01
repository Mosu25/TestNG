package trainingTestNG;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardAssert {
	
	@Test
	public void Google() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("orangehrm",Keys.ENTER);
		
		String expectedResult = "orangehrm - Google Searchh";
		String actualResult = driver.getTitle();
		
		// Hard Assertion is an assertion which throws the exception immediately upon failure of assertion.
		
		//Assert Methods -- assertEquals, assertNotEquals, assertTrue, assertFalse, assertNull, assertNotNull
		
		assertEquals(actualResult, expectedResult, "Title is Mismatched");
		driver.quit();
		
	}

}
