package com.idrive;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Lab003 {

	WebDriver driver;

	@Description("To be executed before test")
	@BeforeTest
	public void start(){

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver();
	}

	@Description("Core Logic")
	@Test
	public void logic(){

		driver.get("https://www.idrive360.com/enterprise/login");
		driver.manage().window().maximize();

		WebElement userName = driver.findElement(By.xpath("//input[@id= 'username']"));
		userName.sendKeys("augtest_040823@idrive.com");

		WebElement passWord = driver.findElement(By.xpath("//input[@id= 'password']"));
		passWord.sendKeys("123456");

		WebElement login_button = driver.findElement(By.xpath("//button[@id = 'frm-btn']"));
		login_button.click();

		try{
			//Explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()= 'Your free trial has expired']")));

			//Verifying the URL
			String actual_URL = driver.getCurrentUrl();
			Assert.assertEquals(actual_URL, "https://www.idrive360.com/enterprise/account?upgradenow=true");

			//Verifying the trial error message is showing or not
			WebElement trialMessage = driver.findElement(By.xpath("//h5[text() = 'Your free trial has expired']"));

			if(trialMessage.isDisplayed()){
				System.out.println("The Trial error message is: " +trialMessage.getText());
			}
			else {
				System.out.println("Element not present");
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Description("To be executed after test")
	@AfterTest
	public void close() throws InterruptedException {

		Thread.sleep(4000);
		driver.quit();
	}
}
