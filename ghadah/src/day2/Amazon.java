package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	ChromeDriver driver;

	public void invokrBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\eclipse-workspace\\libs\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.amazon.com");

	}

	public int getLinksCount() {

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		return allLinks.size();
	}
	
	public void getUrlFromLinkText(String linktext) {
		
		WebElement link = driver.findElement(By.linkText(linktext));
		
		String url = link.getAttribute("href");
		
		System.out.println(url);
	}

	public void searchProduct(String products, String categoray) {
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(products);

		WebElement selDropDown = driver.findElement(By.id("searchDropdownBox"));
		Select selAccount = new Select(selDropDown);

		// selAccount.selectByVisibleText("Electronics");

		driver.findElement(By.xpath("//input[@value='Go']")).click();

	}

	public String getNthProduct(int productNumber) {

		String xPathExpression = String
				.format("//div[@class='s-result-list s-search-results sg-row']//div[@data-index='%d']", productNumber);
		String result = driver.findElement(By.xpath(xPathExpression)).getText();

		return result;
	}

	public void getAllProducts() {

		List<WebElement> allProduct = driver
				.findElements(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div"));

		for (WebElement product : allProduct) {

			System.out.println(product.getText());

			System.out.println("--------------------------------------------------------------------------------");
		}

	}

	public void getAllProductsViaMouseScroll() {

		List<WebElement> allProduct = driver
				.findElements(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div"));

		Actions action = new Actions(driver);

		for (WebElement product : allProduct) {

			action.moveToElement(product).build().perform();

			System.out.println(product.getText());

			System.out.println("--------------------------------------------------------------------------------");
		}

	}

	public void getAllProductsViaJavaScript() {

		List<WebElement> allProduct = driver
				.findElements(By.xpath("//div[@class='s-result-list s-search-results sg-row']/div"));

		int x, y;

		for (WebElement product : allProduct) {

			x = product.getLocation().x;

			y = product.getLocation().y;

			scrollDown(x, y);

			System.out.println(product.getText());

			System.out.println("--------------------------------------------------------------------------------");
		}

	}

	private void scrollDown(int x, int y) {

		JavascriptExecutor jsEngine = (JavascriptExecutor) driver;

		String jsCommand = String.format("window.scrollBy(%d,%d)", x, y);

		jsEngine.executeScript(jsCommand);

	}

}
