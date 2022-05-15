package week4.day2.Assignment;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		List<WebElement> MobileName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println("First Mobile Name is "+MobileName.get(0).getText());
		
		List<WebElement> MobilePrize = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println("First Mobile prize is "+MobilePrize.get(0).getText());
		String Prize = MobilePrize.get(0).getText();
		
		List<WebElement> MobileRatings = driver.findElements(By.xpath("//div[@class='a-row a-size-small']/span"));
		System.out.println("First Mobile rating is " +MobileRatings.get(0).getAttribute("aria-label"));
	
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		
		Set<String> newtab = driver.getWindowHandles();
		List<String> newtablist=new ArrayList<String>(newtab);
		driver.switchTo().window(newtablist.get(1));
		System.out.println(driver.getCurrentUrl());
		
		File Source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Report/IMG001.png");
		
		FileUtils.copyFile(Source, destination);
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(10000);
		String CartTotal = driver.findElement(By.xpath("(//span[@id='attach-accessory-cart-subtotal'])[1]")).getText();
		String CartTotalnew1 = CartTotal.substring(CartTotal.indexOf('.')+2,CartTotal.length());
		String CartTotalnew = CartTotalnew1.replaceAll("\\D", "");
		int CartTotalint = Integer.parseInt(CartTotalnew);
		
		String prizenew = Prize.replaceAll("\\D", "");
		
		System.out.println("Prize : "+prizenew);
		System.out.println("CartTotal :"+ CartTotalint);
		
		
		
		if (Prize.equals(CartTotal))
		{
			System.out.println("Cart Value & Items value are equal");
}
		
		
	}

}
