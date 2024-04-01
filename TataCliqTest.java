package marathontestcases;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliqTest 

{
	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		// Initialize Chrome driver
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("https://www.tatacliq.com/");


		// Maximize browser window
		driver.manage().window().maximize();



		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));



		//close special deals pop up
		WebElement element = driver.findElement(By.xpath("(//iframe[@id='wiz-iframe-intent'])[1]"));

		driver.switchTo().frame(element);

		driver.findElement(By.xpath("(//span[@class='CT_InterstitialClose'])[1]")).click();

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//button[@id='wzrk-confirm']")).click();




		// MouseHover on 'Brands'
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));

		Actions action = new Actions(driver);

		action.moveToElement(brands).perform();

		// MouseHover on 'Watches & Accessories'
		WebElement watchesMenu = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));

		action.moveToElement(watchesMenu).perform();

		// Choose the first option from the 'Featured brands'.

		driver.findElement(By.xpath("(//div[@class='DesktopHeader__brandsDetails'])[1]")).click();


		// Select sortby: New Arrivals

		WebElement sortByDropdown = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));

		Select select = new Select(sortByDropdown);

		select.selectByVisibleText("New Arrivals");

		// Choose men from categories filter

		driver.findElement(By.xpath("(//div[text()='Men'])[1]")).click();

		Thread.sleep(3000);

		// Print all prices of watches
		List<WebElement> watchPrices = driver.findElements(By.xpath("//div[@class='productDetail']/div[@class='price']"));

		for (WebElement price : watchPrices) 

		{
			System.out.println(price.getText());
		}

		// Click on the first resulting watch
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']//h3"));

		String comparePrice1=priceList.get(0).getText().replaceAll("[^0-9]", "");

		System.out.println("Prices of listed watches:");

		for(WebElement each:priceList) 

		{
			System.out.println(each.getText().replaceAll("[^0-9]", ""));
		}

		//click on first resulting watch

		WebElement firstWatch = driver.findElement(By.xpath("(//div[@class='ProductModule__base']//a)[1]"));

		driver.executeScript("arguments[0].click();", firstWatch);

		//Switch to new window
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windows=new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));

		//get the price of watch
		String comparePrice2 = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']//h3")).getText();

		comparePrice2=comparePrice2.replaceAll("[^0-9]", "");

		if(comparePrice1.equals(comparePrice2)) 
		{
			System.out.println("The price "+comparePrice1+ " and "+comparePrice2+" is similar");
		}
		else 
		{
			System.out.println("The prices "+comparePrice1+ " and "+comparePrice2+ "are not similar");
		}


		// Take a snap of the resulting page
		TakesScreenshot scrShot =((TakesScreenshot)driver);

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File("C:\\Users\\kausi\\Documents\\Test Leaf\\eclipse\\MavenProject\\src\\main\\java\\marathontestcases\\test.png");

		FileUtils.copyFile(SrcFile, DestFile);


		// Close the all opened windows one by one

		driver.close();


		driver.switchTo().window(windows.get(0));



		driver.quit();
	}
}


