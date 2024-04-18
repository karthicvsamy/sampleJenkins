package brokenLinks.Fetch.Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fetchBrokenLinksTnstc {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get("https://www.tnstc.in/home.html");
		List <WebElement> allLinks= driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());
		for(WebElement eachlink : allLinks) {
			String link = eachlink.getAttribute("href");
			try {
			URL url = new URL(link);	
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			int responseCode = httpCon.getResponseCode();
			if(responseCode>=400) {
				System.out.println(link+" ==> "+ responseCode);
			}
			}
			catch(Exception e) {
				System.err.println("Exception handled");
			}
			
		}
	}
}
