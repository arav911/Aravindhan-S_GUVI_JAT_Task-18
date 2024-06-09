package task_18_guvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
//		Setting up the Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		Maximizing the window
		driver.manage().window().maximize();
//		Opening drag and drop url
		driver.get("https://jqueryui.com/droppable/");
		
//		Finding frame element page and storing it as WebElement
		WebElement frame = driver.findElement(By.className("demo-frame"));
//		Switching to frame element
		driver.switchTo().frame(frame);
		
//		finding source box element  and storing it as WebElement
		WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
//		finding target box element and storing it as WebElement
		WebElement target = driver.findElement(By.xpath("//p[text()='Drop here']"));
		
//		checking CSS color property of target box element
		WebElement droppable = driver.findElement(By.id("droppable"));
		String colorBefore = droppable.getCssValue("background");
		colorBefore = colorBefore.split("none")[0].trim();
		
//		Performing Drag and Drop class with help of Actions class 
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target);
		actions.build().perform();
		
//		Printing the text generated after drag and drop operation is completed
		System.out.println(driver.findElement(By.xpath("//*[@id='droppable']/p")).getText());

//		checking CSS color property of target box element
		String colorAfter = droppable.getCssValue("background");
		colorAfter = colorAfter.split("none")[0].trim();
//		validating the color properties of both the before and after drag and drop operation done 
		System.out.println(colorBefore.equalsIgnoreCase(colorAfter) ? "Drag and Drop operation is not successful" : "Drag and Drop operation is successful");
	}

}
