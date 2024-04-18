package demoapps.Qspiders;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadInADirectory {
	
	public static void main(String[] args) {
		
		ChromeOptions cOption = new ChromeOptions();
		HashMap< String, Object> nHmap  = new HashMap<String, Object>();
		nHmap.put("download.default_directory", "D:\\Test Yantra\\Custom download directory\\");
		cOption.setExperimentalOption("prefs", nHmap);
		WebDriver driver = new ChromeDriver(cOption);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[contains(.,'Download')]")).click();
		driver.findElement(By.id("writeArea")).sendKeys("This is funny");
		driver.findElement(By.id("downloadButton")).click();
	}
}
