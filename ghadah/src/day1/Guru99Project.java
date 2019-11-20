package day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Guru99Project {

	ChromeDriver driver;

	public void invokrBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\eclipse-workspace\\libs\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("http://demo.guru99.com/v4");

	}

	public void getTitleOfThePage() {
		System.out.println(driver.getTitle());
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void loginToGuru99() {
		WebElement username = driver.findElement(By.name("uid"));
		username.sendKeys("mngr233424");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("udatydU");

		driver.findElement(By.name("btnLogin")).click();

	}

	public void addCustomer() {

		driver.findElement(By.linkText("New Customer")).click();

		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("ghadah");

		driver.findElement(By.xpath("//input[@value='f']")).click();

		WebElement dateOfBirth = driver.findElement(By.name("dob"));
		dateOfBirth.sendKeys("06/20/1994");

		WebElement address = driver.findElement(By.name("addr"));
		address.sendKeys("Bussiness village");

		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Dubai");

		WebElement state = driver.findElement(By.name("state"));
		state.sendKeys("uae");

		WebElement pin = driver.findElement(By.name("pinno"));
		pin.sendKeys("123674");

		WebElement mobile = driver.findElement(By.name("telephoneno"));
		mobile.sendKeys("0509987560");

		String emailId = "ss" + System.currentTimeMillis() + "@gmail.com";

		WebElement email = driver.findElement(By.name("emailid"));
		email.sendKeys(emailId);

		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("test1234");

		driver.findElement(By.name("sub")).click();

	}

	public String getCustomerId() {
		String customerId = driver.findElement(By.xpath("//table[@id='customer']/tbody/tr[4]/td[2]")).getText();

		return customerId;
	}

	public void newAccount(String customerId) {
		driver.findElement(By.linkText("New Account")).click();

		WebElement customerid = driver.findElement(By.name("cusid"));
		customerid.sendKeys(customerId);
		
		WebElement selDropDown = driver.findElement(By.name("selaccount"));
		
		Select selAccount = new Select (selDropDown);
		
		selAccount.selectByVisibleText("Current");
		
		WebElement depo = driver.findElement(By.name("inideposit"));
		depo.sendKeys("1234568765");
		
		driver.findElement(By.name("button2")).click();
		
	}
	
	public void logOut() {
		driver.findElement(By.linkText("Log out")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		
	}

}
