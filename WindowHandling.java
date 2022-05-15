package week4.day2.Assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		System.out.println("Main Window "+driver.getCurrentUrl());
		System.out.println("                      ");
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> Window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(Window.get(1));
		System.out.println("Popup Window "+driver.getCurrentUrl());
		System.out.println("                      ");
		driver.findElement(By.xpath("(//input[@class=' x-form-text x-form-field'])[1]")).sendKeys("11724");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.switchTo().window(Window.get(0));
		System.out.println("After Clicking the window "+driver.getCurrentUrl());
		System.out.println("                      ");
	//driver.findElement(By.xpath("(//td[@class='dijitReset dijitStretch dijitComboBoxInput'])[2]")).sendKeys("11724");
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windowHandlesList =new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println("Popup Window "+driver.getCurrentUrl());
		driver.findElement(By.xpath("(//input[@class=' x-form-text x-form-field'])[1]")).sendKeys("11746");
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		 driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		 driver.switchTo().window(Window.get(0));
		 driver.findElement(By.xpath("//a[contains(@class,'buttonDangerous')]")).click();
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		

	}
}
