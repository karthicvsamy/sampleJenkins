package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[text()='Slider']/../..")).click();
		WebElement sliderBar = driver.findElement(By.xpath("//input[@type='range']"));
		Actions slideAction = new Actions(driver);
		for(int i=-440;i<446;i++) {
		slideAction.clickAndHold(sliderBar).moveByOffset(i,0).build().perform();
		i+=8;
		}
		driver.quit();
	}

}
