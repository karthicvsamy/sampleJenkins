package selenium.Assignments;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.amazon.com/");
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.get("https://www.flipkart.com/");
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.get("https://mictests.com/");
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.get("https://www.amazon.com/");
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.flipkart.com/");
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://mictests.com/");
		System.out.println(driver.getWindowHandle());
		ArrayList<String> windowID= new ArrayList<String>();
		for(int i=0;i<4;i++) {
		driver.switchTo().newWindow(WindowType.WINDOW);
		windowID.add(driver.getWindowHandle());
		}
		String lastId = windowID.get(0);
//		System.out.println("last id and size"+lastId+" "+windowID.size());
		System.out.println(driver.getWindowHandles());
//		System.out.println(windowID);
//		driver.switchTo().window();
		driver.switchTo().window(lastId);
		System.out.println(driver.getWindowHandle());
		for(int i=0;i<4;i++) {
			driver.switchTo().newWindow(WindowType.TAB);
		}
		
	}

}
