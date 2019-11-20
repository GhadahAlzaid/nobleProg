package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindows {
	ChromeDriver driver;

	public void invokrBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\eclipse-workspace\\libs\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
	}
	
	public void handleMultipleWindows() {
		
		String parentWindow = driver.getWindowHandle();
		
		System.out.println(parentWindow);
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		String childWindow = driver.getWindowHandles().toArray()[1].toString();
		
		
		driver.switchTo().window(childWindow);
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
		driver.switchTo().window(parentWindow);
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
	}

}
	
