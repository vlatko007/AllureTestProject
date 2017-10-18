package com.example.allure.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePageObjectV01 extends LoadableComponent<BasePageObjectV01>{

	 protected static Logger logger = LoggerFactory.getLogger(BasePageObjectV03.class);
	    protected WebDriver driver;
	    protected WebDriverWait webDriverWait;

	    public BasePageObjectV01(WebDriver driver) {
	    	this.driver = driver;
	        webDriverWait = new WebDriverWait(driver, 30);
	        PageFactory.initElements(driver, this);
	        this.get();
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
