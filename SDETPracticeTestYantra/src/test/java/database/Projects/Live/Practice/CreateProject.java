package database.Projects.Live.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public abstract class CreateProject {

	public static void main(String[] args) throws SQLException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		driver.findElement(By.xpath("//li[.='Projects']/a")).click();
		driver.findElement(By.xpath("//span[.='Create Project']/..")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("Project_Classic");
		driver.findElement(By.name("createdBy")).sendKeys("Its_you");
		
		WebElement selectDrop = driver.findElement(By.name("status"));
		Select sel = new Select(selectDrop);
		sel.selectByValue("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		driver.quit();
		Driver sqlDriver = new Driver();
		DriverManager.registerDriver(sqlDriver);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		
		Statement state = connect.createStatement();
		
		ResultSet result = state.executeQuery("select project_name from project where created_by='Its_you';");
		
		boolean flag = false;
		while(result.next()) {
				System.out.println(result.getString(1));
				if(result.getString(1).equalsIgnoreCase("project_smiley"));
				{
					flag=true;
				}
		}
		if(flag==true) {
			System.out.println("The data is present in database");
		}
		else {
			System.out.println("The data is not present in database");
		}
		connect.close();
		
	}
}
