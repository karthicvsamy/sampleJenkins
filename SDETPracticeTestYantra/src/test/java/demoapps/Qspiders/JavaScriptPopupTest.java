package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPopupTest {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoapps.qspiders.com/");
	driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
	driver.findElement(By.xpath("//section[.='Popups']")).click();
	driver.findElement(By.xpath("//section[.='Javascript']/..")).click();
	driver.findElement(By.xpath("//a[contains(.,'Default')]")).click();
	driver.findElement(By.xpath("//button[.='Alert Box']")).click();
	Alert defaultAlert = driver.switchTo().alert();
	defaultAlert.accept();
	driver.findElement(By.xpath("//a[contains(.,'Confir')]")).click();
	WebElement confirmBox =  driver.findElement(By.xpath("//button[contains(.,'Confir')]"));
	confirmBox.click();
	Alert confirmAlert = driver.switchTo().alert();
	confirmAlert.accept();
	confirmBox.click();
	confirmAlert.dismiss();
	driver.findElement(By.xpath("//a[.='Prompt']")).click();
	driver.findElement(By.cssSelector("#buttonAlert1")).click();
	Alert promptAlert = driver.switchTo().alert();
	promptAlert.sendKeys("no");
	promptAlert.accept();
	String data = driver.findElement(By.xpath("//p[contains(.,'You selected')]")).getText();
	if(data.equals("You selected yes")) {
		System.out.println("Yes option selected");
	}
	else {
		System.out.println("No option selected");
	}
	driver.quit();
}
}
