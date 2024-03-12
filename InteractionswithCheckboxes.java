package week3.day2.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractionswithCheckboxes {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load the URL
		driver.get("https://leafground.com/checkbox.xhtml");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Click on the "Basic Checkbox
		driver.findElement(By.xpath("//span[contains(text(),'Basic')]")).click();
		//Click on the "Notification Checkbox
		driver.findElement(By.xpath("//span[contains(text(),'Ajax')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement messageElement = driver.findElement(By.xpath("//span[text()='Checked']"));
		// Capture the text of the element
		String actualMessage = messageElement.getText();
		// Expected message
		String expectedMessage = "Checked";
		// Verify that the expected message is displayed
		if (actualMessage.contains(expectedMessage)) {
			System.out.println("Expected message is displayed: " + expectedMessage);
		} else {
			System.out.println("Expected message is not displayed. Actual message: " + actualMessage);
		}
		//Click on your favorite language
		driver.findElement(By.xpath ("(//div[contains(@class,'ui-chkbox-box ui-widget')])[3]")).click();
		//Click on the "Tri-State Checkbox
		driver.findElement(By.xpath ("//div[@data-iconstates='[\"\",\"ui-icon ui-icon-check\",\"ui-icon ui-icon-closethick\"]']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement messageElement2 = driver.findElement(By.xpath("//p[text()='State = 1']"));
		// Capture the text of the element
		String actualMessage2 = messageElement2.getText();
		// Expected message
		String expectedMessage2 = "State = 1";
		// Verify that the expected message is displayed
		if (actualMessage2.contains(expectedMessage2)) {
			System.out.println("Expected message is displayed: " + expectedMessage2);
		} else {
			System.out.println("Expected message is not displayed. Actual message: " + actualMessage);
		}
		//Click on the "Toggle Switch
		driver.findElement(By.className("ui-toggleswitch-slider")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement messageElement3 = driver.findElement(By.xpath("//span[text()='Checked']"));
		// Capture the text of the element
		String actualMessage3 = messageElement3.getText();
		// Expected message
		String expectedMessage3 = "Checked";
		// Verify that the expected message is displayed
		if (actualMessage3.contains(expectedMessage)) {
			System.out.println("Expected message is displayed: " + expectedMessage3);
		} else {
			System.out.println("Expected message is not displayed. Actual message: " + actualMessage);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//Verify if the Checkbox is disabled
			WebElement checkbox = driver.findElement(By.xpath("(//div[contains(@class,'ui-selectbooleancheckbox ui-chkbox')])[3]"));
			if (checkbox.isEnabled()) {
				// Check if the checkbox is selected
				if (checkbox.isSelected()) {
					System.out.println("Checkbox is already selected.");
				} else {
					System.out.println("Checkbox is disabled. ");
				} 

			}
		}

		//Select multiple options on the page
		driver.findElement(By.xpath("//ul[contains(@class,'ui-selectcheckboxmenu-multiple-container ui-widget')]")).click();
		//Select the Search bar
		driver.findElement(By.xpath("//input[@role='textbox']")).sendKeys("London");
		//Select the Check box
		driver.findElement(By.xpath("//div[@id='j_idt87:multiple_panel']/div[2]/ul[1]/li[2]/div[1]/div[2]")).click();
		// To click outside the dropdown to select the value
		driver.findElement(By.xpath("(//i[@class='pi pi-cog'])[2]")).click();
		//Close the browser window.
		driver.close();



	}
}


