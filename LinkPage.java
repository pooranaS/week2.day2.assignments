package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkPage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.xpath("(//a[contains(text(),'Go')])[1]")).click();
		driver.navigate().back();
		
		//To find without clicking me
		System.out.println("The page without clicking the link is:"+driver.findElement(By.xpath("(//a[contains(text(),'Find')])[1]")).getAttribute("href"));
		
		//to verify the page is broken
		driver.findElement(By.xpath("//a[contains(text(),'Verify')]")).click();		
		String text=driver.findElement(By.tagName("h1")).getText();
		System.out.println("text:"+text);
		if(text.contains("404"))
			System.out.println("The page is broken");
		else
			System.out.println("The page is not broken");
		
		driver.navigate().back();
		driver.findElement(By.xpath("(//a[contains(text(),'Go')])[1]")).click();
		System.out.println("The page is returned to home");
		
		driver.navigate().back();
		int linkCount = driver.findElements(By.tagName("a")).size();
		System.out.println("The total number of links:"+linkCount);
		driver.close();

	}

}
