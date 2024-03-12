package week3.day2.selenium;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundButtonInteraction {

	public static void main(String[] args) {
		// Initialize the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load the URL
		driver.get("https://leafground.com/button.xhtml");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Click on the button with the text ‘Click and Confirm title.’
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		//Verify that the title of the page is ‘dashboard
		System.out.println(driver.getTitle());
		//To go back to the previous page from the current page
		driver.navigate().back();
		//Check if the button with the text ‘Confirm if the button is disabled’ is disabled.
		// Check if the button is disabled
		boolean isEnabledButton = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/parent::div")).isEnabled();
		assertEquals(isEnabledButton,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Find and print the position of the button with the text ‘Submit
		WebElement button2 = driver.findElement(By.xpath("//span[text()='Submit']"));
		// Get the position of the button
		Point buttonPosition = button2.getLocation();
		// Print the x and y coordinates of the button
		System.out.println("Button position - X: " + buttonPosition.getX() + ", Y: " + buttonPosition.getY());
		//Find and print the background color of the button with the text
		WebElement button3 = driver.findElement(By.xpath("//span[text()='Save']"));
		// Get the background color of the button
		String backgroundColor = button3.getCssValue("background-color");
		// Print the background color
		System.out.println("Button background color: " + backgroundColor);
		// Find and print the height and width of the button with the text
		WebElement button4 = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
		// Get the size (height and width) of the button
		Dimension buttonSize = button4.getSize();
		// Print the height and width of the button
		System.out.println("Button size - Height: " + buttonSize.getHeight() + ", Width: " + buttonSize.getWidth());
		//Close the browser window.
		driver.close();



	}

}


