package demo.Qspiders;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebdriverUtility {
	
	public void switchWindowWithPartialUrl(WebDriver driver, String partialUrl) {
		Set<String> presentWindows= driver.getWindowHandles();
		for(String windowId: presentWindows) {
			driver.switchTo().window(windowId);
			if(driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}

}
