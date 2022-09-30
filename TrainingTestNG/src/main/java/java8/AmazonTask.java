package java8;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * 1. Open Amazon.in
 * 2. Fetch all the link in the amazon.in homepage
 * 3. Fetch the text from the links and remove the empty link
 * 4. remove the duplicates
 * 5. sort the text in the alphabetical order
 * 6. Print only the text starting with character "C" and "D"
 *  
 * @author Mosu
 *
 */



public class AmazonTask {

	public static void main(String[] args) {

		RemoteWebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		List<WebElement> list = driver.findElements(By.xpath("//a"));

		List<String> text = new ArrayList<>();

		for (WebElement webElement : list) {

			String temp = webElement.getText();
			if(!temp.isBlank()) {
				text.add(temp);
			}
		}
		//removing duplicate values in the list
		// Set<String> removeDuplicates = new HashSet<String>(text);
		List<String> listAfterRemovingDuplicates = new ArrayList<>( new HashSet<String>(text));
		Collections.sort(listAfterRemovingDuplicates);

		//all links fetching loop
		//		for (String list1 : listAfterRemovingDuplicates) {
		//		System.out.println(list1);	
		//		}

		// Start wiht C and D char matched list
		// using foreach loop
		for (String list2 : listAfterRemovingDuplicates) {

			if (list2.startsWith("C") || list2.startsWith("D")) {
				System.out.println(list2);
			}
		}

		// for loop using
		for (int i=0; i<listAfterRemovingDuplicates.size() ; i++) {

			if(listAfterRemovingDuplicates.get(i).startsWith("C") || listAfterRemovingDuplicates.get(i).startsWith("D")) {

				System.out.println(listAfterRemovingDuplicates.get(i));
			}
		}

		driver.quit();

	}

}
