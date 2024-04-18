package chrome.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunChromeInDifferentLangGlobalizationTesting {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--lang=ta");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com/");
	}
}
