package week4.day2.Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select dropdownselect = new Select(dropdown);
		dropdownselect.selectByIndex(3);

		WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select dropdown1select = new Select(dropdown1);
		dropdown1select.selectByVisibleText("Appium");

		WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='dropdown3']"));
		Select dropdown2select = new Select(dropdown2);
		dropdown2select.selectByValue("3");

		WebElement dropdown3 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select dropdown3select = new Select(dropdown3);
		List<WebElement> options = dropdown3select.getOptions();
		for (WebElement y : options) {
			System.out.println(y.getText());

			driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/ancestor::select"))
					.sendKeys("Loadrunner");

			WebElement dropdown4 = driver
					.findElement(By.xpath("//option[text()='Select your programs']/ancestor::select"));
			Select dropdown4select = new Select(dropdown4);
			dropdown4select.selectByVisibleText("Selenium");
			dropdown4select.selectByVisibleText("Loadrunner");
		}
	}

}
