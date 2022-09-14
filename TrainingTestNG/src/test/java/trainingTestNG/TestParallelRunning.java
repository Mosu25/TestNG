package trainingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestParallelRunning {

	@Test
	public void Google() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();

	}

	@Test
	public void Facebook() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
	}

	@Test
	public void Amazon() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.quit();
	}

	@Test
	public void Google1() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();

	}
	
	@Test
	public void Google2() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();

	}
	
	@Test
	public void Google3() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();

	}
	
	@Test
	public void Google4() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();

	}
	
	@Test
	public void Google5() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();

	}
	
	@Test
	public void Google6() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();

	}
}
