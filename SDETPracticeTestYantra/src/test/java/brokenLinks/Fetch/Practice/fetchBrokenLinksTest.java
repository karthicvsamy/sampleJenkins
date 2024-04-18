package brokenLinks.Fetch.Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fetchBrokenLinksTest {

	public static void main(String[] args) throws IOException, MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.ksrtc.in/oprs-web/");
		List <WebElement> allLinks =driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		for(WebElement link : allLinks) {
			String linkName = link.getAttribute("href");
			try {
			URL url = new URL(linkName);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			int statusCode = httpCon.getResponseCode();
			if(statusCode>=400) {
				System.out.println(linkName + " ==> broken " + statusCode);
			}
			}
			catch (Exception e) {
				
			}
		}
	}
}
