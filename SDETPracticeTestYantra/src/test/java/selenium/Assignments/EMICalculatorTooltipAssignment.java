package selenium.Assignments;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EMICalculatorTooltipAssignment {

	
	public static void main(String[] args) throws AWTException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://emicalculator.net/");
		List<WebElement> allEle = driver.findElements(By.xpath("//div[@id='emibarchart']//*[name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='g' and contains(@class,'highcharts-markers highcharts-series-2')]//*[name()='path']"));
		
		Actions action = new Actions(driver);
//		Robot rob = new Robot();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", allEle.get(0));
		for(WebElement ele: allEle) {
			action.click(ele).pause(2000).perform();
			
			System.out.println(driver.findElement(By.xpath("//*[name()='svg']//*[name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']/*[name()='text']")).getText());
//			System.out.println(driver.findElement(By.xpath("//*[name()='svg']//*[contains(@class,'highcharts-label highcharts-t')]/*[name()='text']")).getAttribute("class"));
		}
	}
	
}
