package demoapps.Qspiders;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcPopupHandling {
	
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/nget/train-search");
		String parentId = driver.getWindowHandle();
		System.out.println("parent Id is "+ parentId);
		driver.findElement(By.xpath("//a[contains(.,' BUSES ')]/..")).click();
		Set<String> presentWindows = driver.getWindowHandles();
		System.out.println(presentWindows);
		for(String wid: presentWindows) {
			if(!wid.equals(parentId)) {
				driver.switchTo().window(wid);
				System.out.println("Child window Id is "+ wid);
				break;
			}
		}
//		List<String> windowList = new ArrayList<String>(presentWindows);
//		String recentWindow = windowList.get(1);
//		driver.switchTo().window(recentWindow);
		driver.findElement(By.xpath("//input[@id='departFrom']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[.='Bangalore']")).click();
		driver.findElement(By.xpath("//input[@id='goingTo']")).sendKeys("Trichy");
		driver.findElement(By.xpath("//div[.='Trichy']")).click();
		driver.findElement(By.xpath("//input[@id='departDate']")).click();
		driver.findElement(By.xpath("//td[.='13']")).click();
		driver.findElement(By.xpath("//button[contains(.,'Search Bus')]")).submit();
	}
}
