package week4.day2;
import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetInterface {

	public static boolean uniqueMobPrice;

	public static boolean uniqueMobInsetOrder;

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		int len = list.size();
		Set<Integer> uniqueAndInsertOrder = new LinkedHashSet<Integer>();
		Set<Integer> randomOrder = new HashSet<Integer>();
		for (int i = 0; i <= len - 1; i++) {
			String pricevalue = list.get(i).getText();
			String value = pricevalue.replaceAll("[,\\s]", "");
			int price = Integer.parseInt(value);
			uniqueMobPrice = uniqueAndInsertOrder.add(price);
			uniqueMobInsetOrder = randomOrder.add(price);

		}

		if (uniqueMobPrice) {
			System.out.println("Unique Price with Insort Order " + uniqueAndInsertOrder);

		}

		if (uniqueMobInsetOrder) {
			System.out.println("Mobile Price in Random Order " + randomOrder);

		}

	}

}


