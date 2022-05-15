package week4.day2.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		System.out.println(
				"Main page title :" + driver.findElement(By.xpath("//h1[@class='breadcrumb-item']")).getText());

		driver.switchTo().frame("frame1");
		System.out.println("First Frame :" + driver.findElement(By.xpath("//b[@id='topic']")).getText());
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling:: input")).sendKeys("Amal");
		System.out.println("frame1 is pass");

		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//b[contains(text(),'Inner Frame Check box')]//following-sibling::input")).click();
		System.out.println("frame3 is pass");

		driver.switchTo().defaultContent();

		driver.switchTo().frame("frame2");
		System.out.println("frame2 is pass");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select dropdownvalue = new Select(dropdown);
		dropdownvalue.selectByVisibleText("Big Baby Cat");

	}

}
