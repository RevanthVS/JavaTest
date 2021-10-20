package com.ss;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartTesting {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\elcot\\eclipse-workspace\\SeleniumClassnew\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("mobiles");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Robot sp = new Robot();
		sp.keyPress(KeyEvent.VK_ENTER);
		sp.keyRelease(KeyEvent.VK_ENTER);
		List<WebElement> moblist = driver.findElements(By.className("_4rR01T"));
		for (int i = 0; i <moblist.size(); i++) {
			WebElement names = moblist.get(i);
			System.out.println();
			String name = names.getText();
			System.out.println(name);
			System.out.println();				
			if (i==0) {
		driver.findElement(By.className("_4rR01T")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String a : allWindow) {
				if (!a.equals(parentWindow)) {
				driver.switchTo().window(a);
				
				WebElement particularName = driver.findElement(By.xpath("//span[contains(@class,'NuC')]"));
				String mob = particularName.getText();
				System.out.println(mob);
				
					if (mob.contains(name)) {
					System.out.println();
					System.out.println("Mob is Same");
					System.out.println();
				}
				else {
					System.out.println();
					System.out.println("Not Same");
					System.out.println();
					
					TakesScreenshot ts = (TakesScreenshot)driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					File target = new File("C:\\Users\\elcot\\eclipse-workspace\\JavaTest\\Screenshot\\" +  ".png");
					FileUtils.copyFile(source, target);		
				}
				driver.switchTo().window(parentWindow);
			}
		}
			
			
		
		
			}
		}
	}
}


