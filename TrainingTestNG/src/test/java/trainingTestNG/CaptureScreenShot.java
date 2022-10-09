package trainingTestNG;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CaptureScreenShot {

	WebDriver driver = null;
	long timeOuts =40;

	@BeforeClass
	public void OpenBrowser() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOuts));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
	}

	/**
	 * Selenium 4 having getScreenshotAs method used to capture the Screenshot 
	 * 	two ways used to copy screenshot in project location 
	 * 1. FileHandler -- org.openqa.selenium.io.FileHandler;
	 * 2. FileUtils --- org.apache.commons.io.FileUtils
	 * 
	 */

	@Test(description = "WebElement Screenshot ", enabled = false)
	public void elementScreenShot() throws IOException {

		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File file = logo.getScreenshotAs(OutputType.FILE);
		File destination = new File("logo.png");
		FileHandler.copy(file, destination);		
	}

	@Test(description = "Section Screenshot ", enabled = false)
	public void sectionScreenshot() throws IOException {

		WebElement sec = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File  srcFile= sec.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile,new File("section.png"));

	}

	/*
	 * TakesScreenshot interface used to type cast the driver and 
	 * using getScreenshotAs method used to capture the screenshot
	 * FileHandler - not possible to create screenshot
	 * FileUtils -While new Folder Created
	 * getFullPageScreenshotAs() -- this only available in Firefox browser
	 * 
	 */

	@Test(description = "Page Screenshot ", enabled = false)
	public void pageScreenShot() throws IOException {

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(sourceFile, new File("./Screenshot/fileutilspage1.jpg"));
		FileHandler.copy(sourceFile, new File("./Screenshot/filehandlerpage2.jpg"));
		WebElement page = driver.findElement(By.xpath("//html[@class='html-home-page']"));
		File source = page.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source,new File("htmlpage3.png"));

	}

	@Test(description = "Full Page Screenshot option only available only Firefox browser ", enabled = false)
	public void fullPageScreenshot() throws IOException {

		//		FirefoxDriver driver= new FirefoxDriver();
		//		File fullPage = driver.getFullPageScreenshotAs(OutputType.FILE);
		//		FileHandler.copy(fullPage, new File("fullpage.png"));

		driver= new FirefoxDriver();
		File fullPage1 = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		FileHandler.copy(fullPage1, new File("fullpage.png"));	
	}


	/*
	 * Robot class advantages:
	 * 
	 * 1. We take screenshots using robot class which includes URL of the application
	 * 2. we can take the screenshots of the displayed alerts
	 * 
	 */

	@Ignore
	@Test(description = "Robot calss take the screenshot")
	public void screenshotRobot () throws AWTException, IOException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOuts));
		driver.get("http://testleaf.herokuapp.com/pages/Alert.html");

		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();

		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
		String destination = System.getProperty("user.dir")+"//Screenshot//robot.jpg";
		ImageIO.write(bufferedImage, "jpg", new File(destination));

		//Handling Alert

		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.quit();		

	}

	/*
	 * Ashot is used to capture full page screenshot  
	 *  
	 */
	@Test(description = "Ashot use to capture fullpage screenshot ")
	public void screenshotAshot() throws IOException {

		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		String destination = System.getProperty("user.dir")+"//Screenshot//AshotFullpage.png";
		ImageIO.write(screenshot.getImage(), "png",new File(destination));
		driver.quit();

	}	

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
