package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropNewWindow {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=1");
		WebElement mobile = driver.findElement(By.xpath("//div[.='Mobile Charger']"));
		WebElement target = driver.findElement(By.xpath("//div[.='Mobile Accessories']/div/.."));
		Actions action = new Actions(driver);
		action.clickAndHold(mobile).pause(1000).moveToElement(target).release().build().perform();
		
	}

}
