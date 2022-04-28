package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");

		driver.findElement(By.xpath("(//label[@for='java']/following-sibling::input[@type='checkbox'])[1]")).click();

		// to check the selenium is checked
		boolean checked = driver
				.findElement(By.xpath("//label[contains(text(),'Confirm')]//following::input[@type='checkbox']"))
				.isSelected();
		System.out.println("checkbox is selected:" + checked);
		if (checked == true)
			System.out.println("The selenium check box is selected");
		else
			System.out.println("The selenium check box is not selected");

		// checking first checkbox is selected or not
		boolean chk1 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]//following::input[@type='checkbox'][1]"))
				.isSelected();

		// if true it will deselect checkbox
		if (chk1 == true) {
			driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]//following::input[@type='checkbox'][1]")).click();
			System.out.println("The Check1 is Deselected");
		}

		// checking second checkbox is selected or not
		boolean chk2 = driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]//following::input[@type='checkbox'][2]"))
				.isSelected();

		// if true it will deselect checkbox
		if (chk2 == true) {
			driver.findElement(By.xpath("//label[contains(text(),'DeSelect')]//following::input[@type='checkbox'][2]"))
					.click();
			System.out.println("The Check2 is Deselected");
		}
		
		// selecting all checkboxes
				List<WebElement> allCheckBox = driver.findElements(By.xpath("//label[contains(text(),'all')]//following::input[@type='checkbox']"));
				int size = allCheckBox.size();

				for (int i = 0; i < size; i++) {
					allCheckBox.get(i).click();
				}
				System.out.println("The all check boxes are selected");
		driver.close();

	}

}
