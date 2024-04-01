package marathontestcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.sukgu.Shadow;


public class ServiceNow 
{
	public static void main(String[] args) throws IOException 
	{
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://dev251277.service-now.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		//input credentials and click log in button
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("tdY0ES=5luW-");
		driver.findElement(By.id("sysverb_login")).click();







		//Intialize shadow 

		Shadow shadow = new Shadow(driver);

		shadow.setImplicitWait(10);

		//	Click All

		shadow.findElementByXPath("//div[text()='All']").click();

		//Click service catalog

		shadow.findElementByXPath("//span[text()='Service Catalog']").click();

		//Click on mobiles

		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");

		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//table[@id='homepage_grid']//h2[contains(text(),'Mobiles')]")).click();

		//Click Apple iphone 13 pro
		driver.findElement(By.xpath("//Strong[text()='Apple iPhone 13 pro']")).click();

		//Click yes for lost or broken iphone
		driver.findElement(By.xpath("//label[text()='Yes']")).click();

		//Give Phone Number
		driver.findElement(By.xpath("(//div[@class='row sc-row'])[2]//input[2]")).sendKeys("99");

		//Choose monthly data allowance

		WebElement allowance = driver.findElement(By.xpath("(//div[@class='row sc-row'])[3]//select"));

		Select select=new Select(allowance);

		select.selectByValue("unlimited");

		//Select colour as Sierra Blue

		driver.findElement(By.xpath("//label[contains(text(),'Sierra Blue')]")).click();

		//Select storage as 512 GB
		driver.findElement(By.xpath("//label[contains(text(),'512 GB')]")).click();

		//Click order now button
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();

		//Verify order placed
		boolean displayed = driver.findElement(By.xpath("//span[contains(text(),'your request has been submitted')]")).isDisplayed();

		if(displayed) 
		{
			System.out.println("order placed successfully");
		}
		else 
		{
			System.out.println("oredr not placed");

		}

		//Get request number
		String text = driver.findElement(By.xpath("//a[@id='requesturl']//b")).getText();

		System.out.println("The request number is: "+text);

		//Take SnapShot
		TakesScreenshot scrShot =((TakesScreenshot)driver);

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File("C:\\Users\\kausi\\Documents\\Test Leaf\\eclipse\\MavenProject\\src\\main\\java\\marathontestcases\\order.png");

		FileUtils.copyFile(SrcFile, DestFile);


		driver.close();
	}
}





