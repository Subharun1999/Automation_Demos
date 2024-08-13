package com.Ebay;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Lab_Test {

	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser(){

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

		driver = new ChromeDriver();
	}

	//Searching for a product and Printing all the elements along with their prices
	@Test(groups = "QA")
	@Description("Test Case Description")
	public void Positive_TC() throws InterruptedException {

		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

		WebElement SEARCH_BOX = driver.findElement(By.xpath("//input[@aria-label = 'Search for anything']"));
		SEARCH_BOX.sendKeys("mac mini 2024");

		WebElement SEARCH_BUTTON = driver.findElement(By.xpath("//input[@id = 'gh-btn']"));
		SEARCH_BUTTON.click();

		Thread.sleep(3000);
		List<WebElement> searchTitles = driver.findElements(By.cssSelector(".s-item__title"));
		List<WebElement> searchTitlePrices = driver.findElements(By.cssSelector(".s-item__price"));

		int size = Math.min(searchTitles.size(), searchTitlePrices.size());
		for(int i = 0; i < size; i++){
			System.out.println("Titles :" +searchTitles.get(i).getText());
			System.out.println("Prices :" +searchTitlePrices.get(i).getText());
		}

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}
}
