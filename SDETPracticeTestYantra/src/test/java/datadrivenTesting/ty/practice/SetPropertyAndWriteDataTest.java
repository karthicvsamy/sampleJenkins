package datadrivenTesting.ty.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SetPropertyAndWriteDataTest {

	public static void main(String[] args) throws IOException {
		
//		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		
		prop.setProperty("password", "password");
		prop.setProperty("Username", "Username");
		prop.setProperty("browser","chrome");
		prop.setProperty("written_Url","https://www.amazon.com/");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		prop.store(fos, "Written datas");
		
	}
}
