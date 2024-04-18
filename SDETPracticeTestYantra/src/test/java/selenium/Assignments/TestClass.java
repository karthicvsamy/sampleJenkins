package selenium.Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass {

	@Test (invocationCount = 0)
	public void a() {
		WebDriver d = new InternetExplorerDriver();
		d.get("https://www.facebook.com/signup");
		System.out.println("a");
	}
	
	@DataProvider(name = "datasGiven")
	public Object[][] datas(){
		
		Object[][] obj = new Object[2][2];
		
		obj[0][0] = "Hello";
		obj[0][1] = 1;
		
		obj[1][0] = "Bye";
		obj[1][1] = 3;
		
		return obj;
	}
 	
	
	@Test(dataProvider = "datasGiven")
	public void takeDatas(Object firstColumn, Integer secondColumn) {
		System.out.println("First column data--> "+firstColumn+" Second column data--> "+ secondColumn);
	}
	
}
