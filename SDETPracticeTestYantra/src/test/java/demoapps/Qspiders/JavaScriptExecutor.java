package demoapps.Qspiders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("document.location=arguments[0]","https://www.amazon.in/");//TO LOAD APPLICATION USING JAVASCRIPTEXECUTOR
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");			//TO SCROLL TILL BOTTOM
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		WebElement backToTop = driver.findElement(By.xpath("//span[contains(.,'Back to top')]"));
		
	}
}
