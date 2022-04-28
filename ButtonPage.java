package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Button.html");
		//driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//label[@for='home']/following-sibling::button")).click();
		
		driver.navigate().back();
		System.out.println("Position:"+driver.findElement(By.xpath("(//label[@for='position']/following-sibling::button)[1]")).getLocation());
		System.out.println("color:"+driver.findElement(By.xpath("(//label[@for='position']/following-sibling::button)[2]")).getCssValue("background-color"));
		System.out.println("text:"+driver.findElement(By.xpath("(//label[@for='position']/following-sibling::button)[2]")).getText());
		System.out.println("size:"+driver.findElement(By.xpath("(//label[@for='position']/following-sibling::button)[3]")).getSize());
		driver.close();
	}

}
