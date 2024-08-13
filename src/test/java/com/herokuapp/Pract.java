package com.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Pract {

	WebDriver driver;

	@Test
	public void DragDrop() throws InterruptedException {

		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();

		String windowHandle = driver.getWindowHandle();
		System.out.println("Before click: "+windowHandle);

		WebElement clk_here = driver.findElement(By.linkText("Click Here"));
		clk_here.click();

		Set<String> windowHandles = driver.getWindowHandles();
		for(String handles : windowHandles){
			driver.switchTo().window(handles);
			System.out.println(handles);
			if(driver.getPageSource().contains("New Window")){
				System.out.println("TC Passed");
			}
		}

		Thread.sleep(3000);

		driver.quit();

	}
}
