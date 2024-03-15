package marathontestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// Initialize the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load the URL
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Maximize the browser window
		driver.manage().window().maximize();
		//Type "Bags for boys" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
		//Click the Search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		//Print the total number of results
		WebElement TotalNumberofResultsElement= driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small')]//span"));
		// Retrieve the text from the element
		String TotalNumberofResults = TotalNumberofResultsElement.getText();
		// Output the text
		System.out.println("TotalNumberofResults: " + TotalNumberofResults);
		//  Select the first 2 brands in the left menu
		driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::i)[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Safari')]")).click();
		Thread.sleep(2000);
		//Choose New Arrivals (Sort)
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		driver.findElement(By.linkText("Newest Arrivals")).click();
		//Print the first resulting bag info
		WebElement BagnameElement = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base']"));
		// Retrieve the text from the element
		String Bagname = BagnameElement.getText();
		// Output the text
		System.out.println("Bagname: " + Bagname);
		//Print the first resulting bag info
		WebElement DiscountedPriceElement = driver.findElement(By.xpath("//div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/span[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]/span[1]/span[2]/span[2]"));
		// Retrieve the text from the element
		String DiscountedPrice = DiscountedPriceElement.getText();
		// Output the text
		System.out.println("Discounted Price: " + DiscountedPrice);
		//Get the Title of the page
		System.out.println(driver.getTitle());
		//Close the browser window.
		driver.close();









	}

}
