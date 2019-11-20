package day2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSeleniumCommands {

	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\eclipse-workspace\\libs\\chromedriver.exe");

		driver = new ChromeDriver();

		//driver.manage().window().maximize();
		
		Dimension dim = new Dimension(500, 600);
		
		driver.manage().window().setSize(dim);

		driver.manage().deleteAllCookies();

		driver.get("https://jqueryui.com/droppable/");

	}
	
	public void navigateCommands() {
		
		driver.navigate().to("https://facebook.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
	}
	
	public static void main(String[] args) {
		BasicSeleniumCommands bs = new BasicSeleniumCommands();
		
		bs.invokeBrowser();
		
		bs.navigateCommands();
	}
}
