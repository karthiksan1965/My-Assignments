package week4.HA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class AjioAutomation {

	public static void main(String[] args) throws InterruptedException  {


		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.ajio.com/");

		//Maximize the browser window
		driver.manage().window().maximize();

		// Type "bags" in the search box and press enter
		driver.findElement(By.xpath("//input[@placeholder='Search AJIO']")).sendKeys("bags");

		driver.findElement(By.xpath("//button[@type='submit']//span[1]")).click();



		// Click on "Men" under "Gender"
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();

		// Click on Category
		driver.findElement(By.xpath ("//span[contains(text(),'category')]")).click();

		// Click on Category
		driver.findElement(By.xpath ("//span[contains(text(),'category')]")).click();


		// Click on "Fashion Bags" under "Category"
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();

		Thread.sleep(2000);



		// Print the count of items found
		List<WebElement> items = driver.findElements(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/strong[1]"));
		System.out.println("Count of items found: " + items.get(0).getText());

		// Get the list of brands
		List<WebElement> brandElements = driver.findElements(By.xpath("//div[@class='brand']"));
		System.out.println("List of brands:");
		for (WebElement brand : brandElements) {
			System.out.println(brand.getText());
		}

		// Get the list of names of the bags
		List<WebElement> bagNameElements = driver.findElements(By.xpath("//div[@class='nameCls']"));
		System.out.println("List of bag names:");
		for (WebElement bagName : bagNameElements) {
			System.out.println(bagName.getText());
		}

		// Close the browser
		driver.close();
	}
}



