package testNgTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Guru99Project {

	ChromeDriver driver;

	@BeforeClass
	public void invokrBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\eclipse-workspace\\libs\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("http://demo.guru99.com/v4");

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@Test(priority = 0)
	public void verifyTitleOfThePage() {

		String actualTitle = driver.getTitle();

		String expectedTitle = "Guru99 Bank Home Page";

		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Parameters({"username", "password"})
	@Test(priority = 1000)
	public void loginToGuru99(String sUsername, String sPassword) {
		WebElement username = driver.findElement(By.name("uid"));
		username.sendKeys(sUsername);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(sPassword);

		driver.findElement(By.name("btnLogin")).click();

	}

}
