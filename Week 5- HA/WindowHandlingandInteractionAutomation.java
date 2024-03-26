package week5.HA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

public class WindowHandlingandInteractionAutomation {

	public static void main(String[] args) throws InterruptedException  {

		// Create a new instance of the ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		//Maximize the browser window
		driver.manage().window().maximize();

		//Add an implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Enter the user name
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		//Enter the Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//Click Login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//Click on the "CRM/SFA" link.
		driver.findElement(By.partialLinkText("CRM")).click();

		//Click on the Contacts button
		driver.findElement(By.linkText("Contacts")).click();

		//Click on Merge Contacts.
		driver.findElement(By.linkText("Merge Contacts")).click();

		//Click on the widget of the "From Contact".
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();

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

		//Click on the first resulting contact
		WebElement firstresultingContact= driver.findElement(By.xpath("//a[@class='linktext']"));
		firstresultingContact.click();

		// Switch back to the main window
		driver.switchTo().window(mainWindow);


		// Click on the widget of the "To Contact".
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		// Switch back to the main window
		driver.switchTo().window(mainWindow);

		// Get the handles again as opening the new window might have changed the handles
		windows = driver.getWindowHandles();

		// Switch to the new window again

		for (String window : windows) 
		{

			if (!window.equals(mainWindow)) 

			{
				driver.switchTo().window(window);

				break;
			}
		}


		//Click on the second resulting contact.
		WebElement secondresultingContact= driver.findElement(By.linkText("DemoLBCust"));
		secondresultingContact.click();

		// Switch back to the main window
		driver.switchTo().window(mainWindow);

		//Click on the Merge button.
		driver.findElement(By.linkText("Merge")).click();

		//Accept the alert
		driver.switchTo().alert().accept();

		//Verify the title of the page
		String pageTitle = driver.getTitle();
		System.out.println("Page title: " + pageTitle);

		// Close the browser
		driver.quit();
	}
}

