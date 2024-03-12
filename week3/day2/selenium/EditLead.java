package week3.day2.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

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
		//Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		//Enter the CompanyName Field Using Xpath
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TCCT");
		//Enter the FirstName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Rajesh");
		//Enter the LastName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("kumar");
		//Enter the FirstName (Local) Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Rajesh");
		//Enter the Department Field
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Software");
		//Enter the Description Field
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		//Enter your email in the E-mail address Field
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("rajeshkumar@gmail.com");
		//Select State/Province as NewYork Using Visible Text.
		WebElement State= driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sec = new Select(State);
		sec.selectByVisibleText("New York");
		//Click on the Create Button.
		driver.findElement(By.name("submitButton")).click();
		//Click on the edit button
		driver.findElement(By.linkText("Edit")).click();
		//Enter the Description Field
		driver.findElement(By.name("description")).clear();
		//Fill the Important Note Field with Any text
		driver.findElement(By.id("updateLeadForm_description")).sendKeys("Cleared the Wrong Description");
		//Click on the update button
		driver.findElement(By.className("smallSubmit")).click();
		//Get the Title of the Resulting Page
		System.out.println(driver.getTitle());
		//Close the browser window.
		driver.close();
	}

}
