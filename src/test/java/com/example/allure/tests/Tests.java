package com.example.allure.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.allure.wedoqablog.WedoqaBlogPage;

public class Tests {

	@Test
	public void printPosts() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WedoqaBlogPage wedoqaBlogPage = new WedoqaBlogPage(driver);
		wedoqaBlogPage.getPosts().stream()
			//.filter(postPanel -> postPanel.getAuthor().equals("Tamás Kovacsics"))
			.forEach(postPanel -> {
					System.out.println("Title: " + postPanel.getTitle());
					System.out.println("Author: " + postPanel.getAuthor());
					//System.out.println("Content: " + postPanel.getContent());
				});
                
                wedoqaBlogPage.clickFirstPost();
                
                driver.navigate().back();
                                
                wedoqaBlogPage.clickFirstPost();
                
                driver.navigate().back();
                
		driver.quit();
	}
}
