package com.Ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Lab002 {

	WebDriver driver;
	JavascriptExecutor js;

	@Test
	public void validate() throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		driver.manage().window().maximize();

		js = (JavascriptExecutor) driver;
		WebElement scrollTo = driver.findElement(By.xpath("//div[@id='userName']"));
		js.executeScript("arguments[0].scrollIntoView(true);", scrollTo);

		WebElement inputBox = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div\").shadowRoot.querySelector(\"input#pizza\")");
		inputBox.sendKeys("FarmHouse");

		Thread.sleep(2000);
		driver.quit();

	}
}
