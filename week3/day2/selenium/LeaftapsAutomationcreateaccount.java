package week3.day2.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeaftapsAutomationcreateaccount {

	public static void main(String[] args)  {

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
		//Click on the "Accounts" tab
		driver.findElement(By.linkText("Accounts")).click();
		//Click on the "Create Account" button.
		driver.findElement(By.linkText("Create Account")).click();
		//Enter an account name
		driver.findElement(By.id("accountName")).sendKeys("New Demo Test account");
		//Enter a description
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		//Select the industry.
		WebElement  industry= driver.findElement(By.name("industryEnumId"));
		Select sec = new Select(industry);
		sec.selectByIndex(3);
		//Select the Ownership.
		WebElement  Ownership= driver.findElement(By.name("ownershipEnumId"));
		Select sec2 = new Select(Ownership);
		sec2.selectByVisibleText("S-Corporation");
		//Select the Source.
		WebElement Source= driver.findElement(By.id("dataSourceId"));
		Select sec3 = new Select(Source);
		sec3.selectByValue("LEAD_EMPLOYEE");
		//Select the Marketing Campaign
		WebElement MarketingCampaign= driver.findElement(By.id("marketingCampaignId"));
		Select sec4 = new Select(MarketingCampaign);
		sec4.selectByIndex(6);
		// Select the State/Province
		WebElement State= driver.findElement(By.id("generalStateProvinceGeoId"));
		Select sec5 = new Select(State);
		sec5.selectByValue("TX");
		//Click on the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();
		//Verify that the account name is displayed correctly
		String expectedAccountName = "New Demo Test account";
		WebElement actualAccountNameElement = driver.findElement(By.xpath("//span[contains(text(),'" + expectedAccountName + "')]"));
		if (actualAccountNameElement.isDisplayed()) {
			System.out.println("Account name '" + expectedAccountName + "' is displayed correctly.");
		} else {
			System.out.println("Account name verification failed!");
		}
		//Close the browser window.
		driver.close();

	}
}
