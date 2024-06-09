package task_18_guvi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLoginVerification {

	public static void main(String[] args) throws InterruptedException {
//		Setting up the Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		Maximizing the window
		driver.manage().window().maximize();
//		Opening Facebook url
		driver.get("https://www.facebook.com/");
		
//		Clicking on Create New Account button
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);
//		Entering the inputs in textbox fields
		driver.findElement(By.name("firstname")).sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("User");
		driver.findElement(By.name("reg_email__")).sendKeys("arav.s.911@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("arav.s.911@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Testuser@12345");
		
//		Selecting input from day dropdown
		WebElement day = driver.findElement(By.id("day"));
		Select dayDropDown = new Select(day);
		dayDropDown.selectByVisibleText("11");

//		Selecting input from month dropdown
		WebElement month = driver.findElement(By.id("month"));
		Select monthDropDown = new Select(month);
		monthDropDown.selectByVisibleText("May");
		
//		Selecting input from year dropdown
		WebElement year = driver.findElement(By.id("year"));
		Select yearDropDown = new Select(year);
		yearDropDown.selectByVisibleText("1985");
		
//		Clicking Gender option from radio button
		driver.findElement(By.xpath("//span[@data-type='radio']//label[text()='Male']")).click();
		driver.findElement(By.name("websubmit")).click();
		
//		Validating Login is successful or not
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle.contains("log in") ? "Login is Not Successful" : "Login is Successful");

	}

}
