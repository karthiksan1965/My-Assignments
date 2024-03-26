package week5.HA;



import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealActions 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// Create a new instance of the ChromeDriver

		ChromeDriver driver = new ChromeDriver();

		// Launch Snapdeal website

		driver.get("https://www.snapdeal.com/");



		//Maximize the browser window

		driver.manage().window().maximize();

		//Add an implicit wait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



		// Go to "Men's Fashion"

		//Locate the element
		WebElement MensFashion = driver.findElement(By.xpath("//span[contains(text(),\"Men's Fashion\")]"));

		//Instantiate Actions

		Actions actions = new Actions(driver);

		actions.moveToElement(MensFashion).perform();


		// Go to "Sports Shoes"

		WebElement sportsShoes = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));

		actions.moveToElement(sportsShoes).click().perform();

		// Get the count of sports shoes

		WebElement sportsshoecount = driver.findElement(By.xpath("//span[@class='category-name category-count']"));

		String countofsportsshoes = sportsshoecount.getText();

		System.out.println("countofsportsshoes: " + countofsportsshoes);

		// Click on "Training Shoes"

		WebElement trainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));

		trainingShoes.click();

		// Sort the products by "Low to High"

		WebElement sortDropdown = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"));

		sortDropdown.click();

		WebElement lowToHighOption = driver.findElement(By.xpath("(//li[@data-index='1'])[2]"));

		lowToHighOption.click();

		// Check if the displayed items are sorted correctly

		List<WebElement> productPrices = driver.findElements(By.xpath("//span[text()='Rs. 599']/following-sibling::span"));

		List<Double> prices = new ArrayList<>();

		for (WebElement priceElement : productPrices) 
		{
			String priceText = priceElement.getText().replaceAll("[^\\d.]", ""); 

			double price = Double.parseDouble(priceText);

			prices.add(price);
		}

		//Check if the displayed items are sorted correctly

		boolean sorted = true;
		for (int i = 0; i < prices.size() - 1; i++) 
		{
			if (prices.get(i) > prices.get(i + 1)) 
			{
				sorted = false;
				break;
			}
		}
		System.out.println("Products sorted correctly: " + sorted);

		//Select any price range ex:(500-700)

		WebElement minpriceRangeFilter = driver.findElement(By.name("fromVal"));

		minpriceRangeFilter.clear();

		Thread.sleep(2000);

		minpriceRangeFilter.sendKeys("500");

		Thread.sleep(2000);

		WebElement maxpriceRangeFilter = driver.findElement(By.name("toVal"));

		maxpriceRangeFilter.clear();

		Thread.sleep(2000);

		maxpriceRangeFilter.sendKeys("700");

		Thread.sleep(2000);


		// Filter by color 

		WebElement colorFilter = driver.findElement(By.xpath("//label[@for='Color_s-Black']"));

		colorFilter.click();

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



		// Verify all the applied filters

		String minPriceRange = minpriceRangeFilter.getAttribute("value");

		String maxPriceRange = maxpriceRangeFilter.getAttribute("value");

		String appliedColor = colorFilter.getAttribute("for");

		System.out.println("Min Price Range: " + minPriceRange);

		System.out.println("Max Price Range: " + maxPriceRange);

		System.out.println("Applied Color: " + appliedColor);

		// Optionally, you can add assertions to ensure the applied filters match the expected values

		if (minPriceRange.equals("500")) 
		{
			System.out.println("Price Range filter applied correctly.");
		} 

		else if (maxPriceRange.equals("700")) 
		{
			System.out.println("Price Range filter applied correctly.");
		} 


		else 
		{
			System.out.println("Price Range filter not applied correctly.");
		}

		if (appliedColor.equals("Color_s-Black"))
		{
			System.out.println("Color filter applied correctly.");
		} 

		else 
		{
			System.out.println("Color filter not applied correctly.");
		}

		// Mouse hover on the first resulting "Training Shoes"
		WebElement firstTrainingShoes = driver.findElement(By.xpath("//img[@class='product-image wooble']"));

		actions.moveToElement(firstTrainingShoes).perform();



		// Click the "Quick View" button
		WebElement quickViewButton = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));

		quickViewButton.click();

		// Switch to the new window

		String newWindow = null;
		for (String window : windows) 
		{
			if (!window.equals(mainWindow)) 
			{
				newWindow = window;
				driver.switchTo().window(newWindow);
				break;
			}
		}

		// Print the cost and the discount percentage
		WebElement costElement = driver.findElement(By.className("payBlkBig"));
		String cost = costElement.getText();
		System.out.println("Cost: " + cost);

		WebElement discountElement = driver.findElement(By.className("percent-desc"));
		String discountPercentage = discountElement.getText();
		System.out.println("Discount Percentage: " + discountPercentage);



		//Use TakesScreenshot method to capture screenshot

		TakesScreenshot screenshot = (TakesScreenshot)driver;

		//Saving the screenshot in desired location

		File source = screenshot.getScreenshotAs(OutputType.FILE);

		//Path to the location to save screenshot

		FileUtils.copyFile(source, new File("./Selenium Screenshots1/Screen.png"));

		System.out.println("Screenshot is captured");

		// Switch back to the main window

		driver.switchTo().window(mainWindow);


		// Close the current window
		driver.close();

		// Close the main window
		driver.quit();




	}
}




