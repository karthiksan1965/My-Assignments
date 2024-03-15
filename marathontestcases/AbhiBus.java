package marathontestcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AbhiBus {

	public static void main(String[] args) throws InterruptedException {
		// Initialize the ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		//Load the URL
		driver.get("https://www.abhibus.com/");
		Thread.sleep(2000);
		//Maximize the browser window
		driver.manage().window().maximize();
		//Click the From Station textbox
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).click();
		//Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Chennai");
		//Perform click option 
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		//Include the wait statement
		Thread.sleep(2000);
		//Click the To Station textbox
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).click();
		//Type "Bangalore" in the to text box
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Bangalore");
		//Perform click option 
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		//Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//button[text()='Tomorrow']")).click();
		//Include the wait statement
		Thread.sleep(5000);
		//Print the name of the first resulting bus
		WebElement firstresultingbusElement  = driver.findElement(By.xpath("//h5[@class='title']"));
		// Retrieve the text from the element
		String Firstresultingbus = firstresultingbusElement.getText();
		// Output the text
		System.out.println("First resulting bus: " + Firstresultingbus);
		//  Choose SLEEPER in the left menu from Bus Type
		driver.findElement(By.xpath("//span[text()='Sleeper']")).click();
		//Print the first resulting bus seat count(Example:35 Seats Available)
		WebElement firstresultingbusseatcountElement  = driver.findElement(By.xpath("//div[@class='text-grey']//small"));
		// Retrieve the text from the element
		String Firstresultingbusseatcount = firstresultingbusseatcountElement.getText();
		// Output the text
		System.out.println("First resulting bus seat count: " + Firstresultingbusseatcount);
		//Click Show Seats
		driver.findElement(By.xpath("//button[text()='Show Seats']")).click();
		Thread.sleep(2000);
		//Choose any one Available seat
		driver.findElement (By.xpath("//div[@id='seating-container']/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/button[1]/span[1]")).click();
		// Select the first resulting checkbox from the Boarding Point
		driver.findElement(By.xpath("(//span[text()='L16']/following::input)[2]")).click();
		// Select the first resulting checkbox from the Dropping Point
		driver.findElement(By.xpath("(//span[text()=' 20:20  sholinganallur infront of royal enfield show room, -9398699704, 9398699708']/following::input)[2]")).click();
		//Print Seleceted Seat
		WebElement PrintSelectedSeatElement  = driver.findElement(By.xpath("//span[@class='text-primary']"));
		// Retrieve the text from the element
		String PrintSelectedseat = PrintSelectedSeatElement.getText();
		// Output the text
		System.out.println("Print Selected seat: " + PrintSelectedseat);
		//  Print Total Fare
		WebElement TotalFareElement  = driver.findElement(By.xpath("(//span[@class='text-primary'])[2]"));
		// Retrieve the text from the element
		String TotalFare = TotalFareElement.getText();
		// Output the text
		System.out.println("Total Fare: " + TotalFare);
		//Get the Title of the page
		System.out.println(driver.getTitle());
		//Close the browser window.
		driver.close();

	}

}
