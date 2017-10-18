package com.example.allure.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePageObjectV02 extends LoadableComponent<BasePageObjectV02>{

	protected static Logger logger = LoggerFactory.getLogger(BasePageObjectV03.class);
	protected WebDriver driver;
	protected WebDriverWait webDriverWait;

	public BasePageObjectV02(WebDriver driver) {
		init(driver);
		PageFactory.initElements(driver, this);
		this.get();
	}

	public BasePageObjectV02(WebDriver driver, By root) {
		init(driver);
		WebElement rootelement = driver.findElement(root);
		waitForElementToAppear(rootelement, "The root element should be present");
		PageFactory.initElements(new DefaultElementLocatorFactory(rootelement), this);
		this.get();
	}

	public BasePageObjectV02(WebDriver driver, WebElement root) {
		init(driver);
		waitForElementToAppear(root, "The root element should be present");
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
		this.get();
	}

	private void init(WebDriver driver) {
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, 30);
	}

	@Override
	public void isLoaded() {

	}

	@Override
	protected void load() {

	}

	public WebElement waitForElementToAppear(WebElement webElement, String errorMessage) {
		return webDriverWait.withMessage(errorMessage).until(ExpectedConditions.visibilityOf(webElement));
	}

	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
