package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	ChromeDriver driver;

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hasan\\eclipse-workspace\\libs\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://jqueryui.com/droppable/");

	}
	
	public void dragAndDrop() {
		
		WebElement frame = driver.findElement(By.className("demo-frame"));
		
		//Switching to a frame
		driver.switchTo().frame(frame);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		String colorBeforeDragAndDrop = target.getCssValue("color");
		
		Actions  action = new Actions(driver);
		
		action.dragAndDrop(source, target).build().perform();
		
		String colorAfterDragAndDrop = target.getCssValue("color");
		
		System.out.println("Color before Drag and Drop - "+ colorBeforeDragAndDrop);
		
		System.out.println("Color after Drag and Drop - "+ colorAfterDragAndDrop);
		
		//Switching back from a frame
		driver.switchTo().defaultContent();
	}

}
