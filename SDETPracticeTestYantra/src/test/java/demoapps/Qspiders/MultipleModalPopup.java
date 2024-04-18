package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleModalPopup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']/../..")).click();
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='Modal']")).click();
		driver.findElement(By.xpath("//a[.='Multiple Modal']")).click();
		driver.findElement(By.id("multiModalButton")).click();
		driver.findElement(By.id("multiClosemodal")).click();
		String requiredText = driver.findElement(By.xpath("//div[.='secondary Modal']/..//div//section//p")).getText();
		System.out.println(requiredText);
		driver.findElement(By.xpath("//div[.='secondary Modal']/..//div//section//button")).click();
		driver.findElement(By.id("multiclose2")).click();
	}
}
