package marathontestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PVRCinemas {

	public static void main(String[] args) throws InterruptedException {
		// Initialize the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load the URL
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Maximize the browser window
		driver.manage().window().maximize();

		//Choose your location as Chennai.
		driver.findElement(By.xpath("(//span[text()='Chennai'])")).click();
		//Click on "Cinema" under Quick Book.
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		//Select the cinema: PVR AEROHUB Chennai.
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		Thread.sleep(3000);
		WebElement clk = driver.findElement(By.xpath("//li[contains(text(),'PVR AEROHUB Chennai')]"));
		driver.executeScript("arguments[0].click();",clk);
		Thread.sleep(2000);
		WebElement clk1 =driver.findElement(By.xpath("//li[contains(text(),'Tomorrow, 16 Mar')]"));
		driver.executeScript("arguments[0].click();",clk1);
		Thread.sleep(2000);
		WebElement clk2 =driver.findElement(By.xpath("//li[contains(text(),'KUNG FU PANDA 4')]"));
		Thread.sleep(2000);
		driver.executeScript("arguments[0].click();",clk2);
		// Select the timing: The first available timing.
		WebElement clk3=driver.findElement(By.xpath("//span[text()='11:10 AM']"));
		driver.executeScript("arguments[0].click();",clk3);
		Thread.sleep(2000);
		//Click on "Book".
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		//Click on "Accept" for Terms and Conditions.
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		//Click on "First Available Seat".
		driver.findElement(By.xpath("//span[@class='seat-current-pvr']")).click();
		//Print the Booking Summary.
		String BookingSummary = driver.findElement(By.xpath("//div[@class='summary-movies-content']")).getText();
		System.out.println("Book Summary ");
		System.out.println(BookingSummary);
		// print the Grand Total
		String grandTotal = driver.findElement(By.xpath("//div[@class='grand-prices']//h6[1]")).getText();
		System.out.println("Grand Total " + grandTotal);
		//Close the browser window.
		driver.close();




	}

}
