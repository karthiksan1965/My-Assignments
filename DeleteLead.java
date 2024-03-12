package week3.day2.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/.");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Enter the user name
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		//Enter the Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//Click Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on the "CRM/SFA" link.
		driver.findElement(By.partialLinkText("CRM")).click();
		//Click the "Leads" link.
		driver.findElement(By.linkText("Leads")).click();
		//Click "Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on the "Phone" tab
		driver.findElement(By.name("primaryPhoneCountryCode")).click();
		driver.findElement(By.name("primaryPhoneCountryCode")).clear();
		//Enter the phone number
		WebElement countryCodeinput = driver.findElement(By.name("primaryPhoneCountryCode"));
		WebElement areaCodeinput = driver.findElement(By.name("primaryPhoneAreaCode"));
		WebElement phoneNumberInput = driver.findElement(By.name("primaryPhoneNumber"));
		String countryCode = "91"; 
		String areaCode = "969";   
		String phoneNumber= "8193856"; 
		countryCodeinput.sendKeys(countryCode);
		// Move to the next input field (for example, using TAB key)
		countryCodeinput.sendKeys(Keys.TAB);
		// Enter area code
		areaCodeinput.sendKeys(areaCode);
		// Move to the next input field
		areaCodeinput.sendKeys(Keys.TAB);
		// Enter phone number
		phoneNumberInput.sendKeys(phoneNumber);
		//Click the "Find leads" button.
		driver.findElement(By.linkText("Find Leads")).click();
		// Capture the lead ID of the first resulting lead
		WebElement firstElement= driver.findElement(By.linkText("10043"));
		String Leadid = firstElement.getText();
		System.out.println("Lead id: " + Leadid);
		//Click the first resulting lead.
		driver.findElement(By.linkText("10043")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Click the "Delete" button.
		driver.findElement(By.linkText("Delete")).click();
		//Click "Find leads" again.
		driver.findElement(By.linkText("Find Leads")).click();
		//Enter the captured lead ID.
		driver.findElement(By.name("id")).sendKeys("10043");
		// Click the "Find leads" button.
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		WebElement messageElement = driver.findElement(By.xpath("//div[text()='No records to display']"));
		// Capture the text of the element
		String actualMessage = messageElement.getText();
		// Expected message
		String expectedMessage = "No records to display";
		// Verify that the expected message is displayed
		if (actualMessage.contains(expectedMessage)) {
			System.out.println("Expected message is displayed: " + expectedMessage);
		} else {
			System.out.println("Expected message is not displayed. Actual message: " + actualMessage);
		}


	}

}
