package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class NotifiactionPopupTest {

	public static void main(String[] args) {
//		ChromeOptions options = new ChromeOptions();
		FirefoxOptions options = new FirefoxOptions();
//		WebDriver driver = new ChromeDriver(options);
//		options.addArguments("--disable-notifications");
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='Notifications']")).click();
		driver.findElement(By.cssSelector("#browNotButton")).click();
//		String className = driver.findElement(By.xpath("//section[.='Notifications']")).getAttribute("class");
//		System.out.println(className);
	}
}
