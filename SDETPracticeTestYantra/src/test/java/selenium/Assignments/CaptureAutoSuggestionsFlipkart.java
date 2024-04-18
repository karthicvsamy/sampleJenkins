package selenium.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureAutoSuggestionsFlipkart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Shirt");
		Thread.sleep(1000);
		WebElement target = null;
		List<WebElement> suggestions = driver.findElements(By.xpath("//button[@type='submit']/../../ul/li/div/a/div[2]"));
		for(WebElement element: suggestions) {
			if(element.getText().contains("for boys")) {
				target = element;
			}
			System.out.println(element.getText());
		}
		target.click();
	}
}
