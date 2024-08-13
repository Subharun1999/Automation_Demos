package com.aqi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AQI {

	WebDriver driver;

	@Test
	public void logic() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver();
		driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
		driver.manage().window().maximize();

		System.out.println(driver.getTitle());

		WebElement search = driver.findElement(By.xpath("//input[@id = 'search_city']"));
		search.sendKeys("India", Keys.ENTER);

		Thread.sleep(3000);

		List<WebElement> dataTables = driver.findElements(By.xpath("//table[@id = 'example']/tbody/tr/td[2]"));
		for(WebElement s : dataTables){

			String s1 = driver.findElement(with(By.tagName("p")).toRightOf(s)).getText();
			String s2 = driver.findElement(with(By.tagName("p")).toLeftOf(s)).getText();

			if(s.getText().contains("India"))
			System.out.println(s2 +" "+ s.getText() + " " +s1 );
		}


	}
}
