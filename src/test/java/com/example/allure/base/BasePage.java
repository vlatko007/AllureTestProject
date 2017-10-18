package com.example.allure.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BasePage extends LoadableComponent<BasePage> {

	protected static Logger logger = LoggerFactory.getLogger(BasePage.class);
	protected WebDriver driver;
	protected WebDriverWait webDriverWait;

	public BasePage(WebDriver driver) {
		init(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}

	public BasePage(WebDriver driver, WebElement root) {
		init(driver);
		initElementsUnderRoot(root);
	}

	private void init(WebDriver driver) {
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 30);
	}

	private void initElementsUnderRoot(WebElement root) {
		waitForElementToAppear(root, "The root element should be present");
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
		this.get();
	}

	@Override
	public void isLoaded() { }

	@Override
	protected void load() { }

	public WebElement waitForElementToAppear(WebElement webElement, String errorMessage) {
		return webDriverWait.withMessage(errorMessage).until(ExpectedConditions.visibilityOf(webElement));
	}

}
