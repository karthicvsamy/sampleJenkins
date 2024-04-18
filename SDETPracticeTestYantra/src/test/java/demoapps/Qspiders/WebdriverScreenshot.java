package demoapps.Qspiders;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class WebdriverScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.flipkart.com/");
		TakesScreenshot tss = (TakesScreenshot) driver;
		File tempLocation =  tss.getScreenshotAs(OutputType.FILE);
		File permenantFile = new File("./screenshots/defect.png");
		Files.copy(tempLocation, permenantFile);
	}
}
