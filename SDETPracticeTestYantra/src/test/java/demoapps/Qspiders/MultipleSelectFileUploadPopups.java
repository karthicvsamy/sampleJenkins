package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleSelectFileUploadPopups {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='File Uploads']")).click();
		driver.findElement(By.xpath("//a[.='Multiple select']")).click();
//		WebElement fileUploadButton = driver.findElement(By.id("fileInput"));
//		fileUploadButton.sendKeys("C:\\Users\\karth\\Desktop\\abc.txt");
		driver.findElement(By.id("fileInput")).sendKeys("D:\\Test Yantra\\unknown.txt");
	}
}
