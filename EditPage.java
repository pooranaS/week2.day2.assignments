package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("(//label[@for='email']/following-sibling::input)[2]")).sendKeys("Text");
		driver.findElement(By.xpath("(//label[@for='email']/following-sibling::input)[2]")).sendKeys(Keys.TAB);
		String value=driver.findElement(By.xpath("(//input[@name='username'])[1]")).getAttribute("value");
		System.out.println("Attribute:"+value);
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		boolean isEnabled=driver.findElement(By.xpath("//label[@for='disabled']/following-sibling::input")).isEnabled();
		if(isEnabled==false)
			System.out.println("the field is disbled");
		else
			System.out.println("the field is enabled");
			driver.close();
	}

}
