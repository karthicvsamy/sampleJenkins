package demoapps.Qspiders;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class OpeningTaskManager {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
//		WebDriver driver = new ChromeDriver();
		Robot robotRef = new Robot();
//		robotRef.keyPress(KeyEvent.VK_CONTROL);
//		robotRef.keyPress(KeyEvent.VK_SHIFT);
//		robotRef.keyPress(KeyEvent.VK_ESCAPE);
////		Thread.sleep(2000);
//		robotRef.keyRelease(KeyEvent.VK_CONTROL);
//		robotRef.keyRelease(KeyEvent.VK_SHIFT);
//		robotRef.keyRelease(KeyEvent.VK_ESCAPE);
		
//		Thread.sleep(2000);
					
		robotRef.keyPress(KeyEvent.VK_ALT);
		robotRef.keyPress(KeyEvent.VK_TAB);
		robotRef.keyRelease(KeyEvent.VK_ALT);
		robotRef.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robotRef.keyPress(KeyEvent.VK_ALT);
		robotRef.keyPress(KeyEvent.VK_F4);
		robotRef.keyRelease(KeyEvent.VK_ALT);
		robotRef.keyRelease(KeyEvent.VK_F4);
//		for(int i=0;i<3;i++) {
//			robotRef.keyPress(KeyEvent.VK_TAB);
//			robotRef.keyRelease(KeyEvent.VK_TAB);
//		}
//		for(int i=0;i<3;i++) {
//			robotRef.keyPress(KeyEvent.VK_DOWN);
//			robotRef.keyRelease(KeyEvent.VK_DOWN);
//		}
//		robotRef.keyPress(KeyEvent.VK_ENTER);
//		robotRef.keyRelease(KeyEvent.VK_ENTER);
	}
}


