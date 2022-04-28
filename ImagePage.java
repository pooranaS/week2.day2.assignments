package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Image.html");
		
		driver.findElement(By.xpath("//label[@for='home']/following-sibling::img")).click();
		
		driver.navigate().back();
		//to verify the img is broken
		String text=driver.findElement(By.xpath("(//label[@for='position']/following-sibling::img)[1]")).getAttribute("onclick");	
		System.out.println("text:"+text);
		if(text==null)
			System.out.println("The img is broken");
		else
			System.out.println("The img is not broken");
		//To click the keyboard image using keyboard
		driver.findElement(By.xpath("(//label[@for='position']/following-sibling::img)[2]")).click();
		System.out.println("The keyboard image is clicked using keyboard");
		
		driver.navigate().back();
		//To click the keyboard image using mouse
		WebElement mouse = driver.findElement(By.xpath("(//label[@for='position']/following-sibling::img)[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouse).click().build().perform();
		System.out.println("The keyboard image is clicked using mouse");
		driver.close();
	}

}
