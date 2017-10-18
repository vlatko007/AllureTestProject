package com.example.allure.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePageObjectV03 extends LoadableComponent<BasePageObjectV03> {

    protected static Logger logger = LoggerFactory.getLogger(BasePageObjectV03.class);
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public BasePageObjectV03(WebDriver driver) {
        init(driver);
        PageFactory.initElements(driver, this);
        this.get();
    }

    public BasePageObjectV03(WebDriver driver, By root, boolean wait) {
		init(driver);
		WebElement rootElement = driver.findElement(root);
		if(wait && waitForElementToDisappear(rootElement)) {
			rootElement = driver.findElement(root);
		}
		initElementsUnderRoot(rootElement);
    }

    public BasePageObjectV03(WebDriver driver, By root) {
        this(driver, root, true);
    }

    public BasePageObjectV03(WebDriver driver, WebElement root) {
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
    
    public boolean waitForElementToDisappear(WebElement rootelement) {
        int count = 5;
        while (count > 0) {
            try {
                if (rootelement.isDisplayed()) {
                    sleep(100);
                } else {
                    // Disappeared
                    return true;
                }
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                // Disappeared
                return true;
            }
            count--;
        }
        return false;
    }
    
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
