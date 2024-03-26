package week5.HA;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;


public class AmazonActions {
	public static void main(String[] args) throws InterruptedException, IOException  {

		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.amazon.in/");

		//Maximize the browser window
		driver.manage().window().maximize();

		//Add an implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		////Type "Bags for boys" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");

		//Click the Search button
		driver.findElement(By.id("nav-search-submit-button")).click();

		// Get the price of the first product

		WebElement firstProductPrice = driver.findElement(By.xpath("(//span[@class='a-price'])"));

		String price = firstProductPrice.getText();

		System.out.println("Price of the first product: " + price);

		// Print the number of customer ratings for the first displayed product

		WebElement customerRatings = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']"));

		String ratings = customerRatings.getText();

		System.out.println("Number of customer ratings: " + ratings);

		// Click the first text link of the first image
		WebElement firstProductImage = driver.findElement(By.xpath("(//img[@data-image-index='1'])[1]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(firstProductImage).perform();

		WebElement quickViewLink = driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]"));
		actions.moveToElement(quickViewLink).click().perform();

		// Switch to the new window
		String mainWindow = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) 
		{

			if (!window.equals(mainWindow)) 
			{

				driver.switchTo().window(window);
				break;
			}
		}

		//Use TakesScreenshot method to capture screenshot

		TakesScreenshot screenshot = (TakesScreenshot)driver;

		//Saving the screenshot in desired location
		File source = screenshot.getScreenshotAs(OutputType.FILE);

		//Path to the location to save screenshot
		FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));

		System.out.println("Screenshot is captured");


		// Click the 'Add to Cart' button
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.click();

		//// Get the cart subtotal and verify if it is correct
		WebElement cartSubtotal = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String subtotal = cartSubtotal.getText();

		// Verify the subtotal
		System.out.println("subtotal: " + subtotal);

		// Close the browser
		driver.quit();
	}
}