package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NTCreateAcct {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create')]")).click();
		
		Select currency = new Select(driver.findElement(By.id("currencyUomId")));
		currency.selectByValue("INR");
		
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("NRI account");
		driver.findElement(By.xpath("//input[@id='groupNameLocal']")).sendKeys("Demo");
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("Chennai");
		driver.findElement(By.xpath("(//input[@class='inputBox'])[5]")).sendKeys("12LPA");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String errorMsgHeader=driver.findElement(By.xpath("//div[@class='errorMessageHeader']")).getText();		
		String errorMsg=driver.findElement(By.xpath("//li[@class='errorMessage']")).getText();
		System.out.println("Error msg:"+errorMsgHeader+" "+errorMsg);
		
	}

}
