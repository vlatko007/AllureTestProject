package com.example.allure.wedoqablog;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.allure.base.BasePage;

public class PostPanel extends BasePage {

	@FindBy(css = "h1")
	private WebElement title;
	
	@FindBy(css = ".post-text>*:not(.read)")
	private List<WebElement> contnet;
	
	@FindBy(css = ".author a")
	private WebElement author;
	
	public PostPanel(WebDriver driver, WebElement root) {
		super(driver, root);
	}
	
	public String getTitle() {
		return title.getText();
	}

	public String getContent() {
		StringBuilder sb = new StringBuilder();
		contnet.forEach(element -> sb.append(element.getText()));
		return sb.toString();
	}

	public String getAuthor() {
		return author.getText();
	}
}
