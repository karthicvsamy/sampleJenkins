package chrome.tasks;

import java.io.IOException;

public class CloseChromeUsingJava {

	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();
		Process proc = r.exec("taskkill /im chrome.exe /f /t");
	}
}
