package demoapps.Qspiders;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/keyboard?sublist=0");
		WebElement emailTextField = driver.findElement(By.id("email"));
		emailTextField.sendKeys("itsme@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Aa@1");
		emailTextField.click();
//		passwordTextField.sendKeys("Aa@1");
//		Thread.sleep(2000);
//		passwordTextField.click();
//		passwordTextField.sendKeys(Keys.chord(Keys.CONTROL,"ac"));
//		passwordTextField.sendKeys(Keys.chord(Keys.CONTROL,"C"));
//		passwordTextField.sendKeys(Keys.CONTROL+"ac");
		
		
		/* USING TOBOT CLASS */
		
		Robot robotRef = new Robot();
		robotRef.keyPress(KeyEvent.VK_CONTROL);
		robotRef.keyPress(KeyEvent.VK_A);
		robotRef.keyRelease(KeyEvent.VK_A);
		robotRef.keyPress(KeyEvent.VK_C);
		robotRef.keyRelease(KeyEvent.VK_C);
		robotRef.keyRelease(KeyEvent.VK_CONTROL);
		robotRef.keyPress(KeyEvent.VK_TAB);
		robotRef.keyRelease(KeyEvent.VK_TAB);
		robotRef.keyPress(KeyEvent.VK_TAB);
		robotRef.keyRelease(KeyEvent.VK_TAB);
		robotRef.keyPress(KeyEvent.VK_CONTROL);
		robotRef.keyPress(KeyEvent.VK_V);
		robotRef.keyRelease(KeyEvent.VK_V);
		robotRef.keyRelease(KeyEvent.VK_CONTROL);
		
		
		
//		driver.findElement(By.id(""))
//		WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
//		confirmPassword.sendKeys(Keys.chord(Keys.CONTROL,"v"));
//		confirmPassword.sendKeys(Keys.CONTROL+"v");
	}
}
