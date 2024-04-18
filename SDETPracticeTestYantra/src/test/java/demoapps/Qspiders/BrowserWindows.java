package demoapps.Qspiders;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[text()='Popups']/..")).click();
		driver.findElement(By.xpath("//section[text()='Browser Windows']/..")).click();
		driver.findElement(By.id("browserLink1")).click();
		Set<String> windowsPresent = driver.getWindowHandles();
		ArrayList<String> windowList = new ArrayList<String>(windowsPresent);
		String secondWindow = windowList.get(1);
		driver.switchTo().window(secondWindow);
		driver.findElement(By.id("email")).sendKeys("NothingSerios");
	}
}
