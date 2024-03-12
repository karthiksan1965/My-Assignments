package week3.day2.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load the URL
		driver.get("https://en-gb.facebook.com/");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Click on the "Create New Account" button.
		driver.findElement(By.linkText("Create new account")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Enter the First name
		driver.findElement(By.name("firstname")).sendKeys("karthik");
		//Enter the Surname.
		driver.findElement(By.name("lastname")).sendKeys("san");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Enter the Mobile number or email address.
		driver.findElement(By.name("reg_email__")).sendKeys("karthiksan1965@gmail.com");
		//Enter the New password
		driver.findElement(By.id("password_step_input")).sendKeys("Annakaushik@07");
		//Handle all three dropdowns in Date of birth
		WebElement date= driver.findElement(By.id("day"));
		Select sec = new Select(date);
		sec.selectByIndex(6);
		//Select the Month.
		WebElement Month= driver.findElement(By.id("month"));
		Select sec2 = new Select(Month);
		sec2.selectByIndex(5);
		//Select the Year.
		WebElement Year= driver.findElement(By.id("year"));
		Select sec3 = new Select(Year);
		sec3.selectByValue("1994");
		//Select the radio button in Gender
		WebElement radio_male = driver.findElement(By.xpath("//input[@value='2']"));
		radio_male.click();
		//Close the browser window.
		driver.close();

	}
}





