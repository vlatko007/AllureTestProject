package com.example.allure.wedoqablog;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.example.allure.base.BasePage;
import java.util.Random;
import org.openqa.selenium.By;

public class WedoqaBlogPage extends BasePage {

    @FindBy(css = ".post")
    private List<WebElement> postsRoots;

    public WedoqaBlogPage(WebDriver driver) {
        super(driver);
        driver.navigate().to("http://blog.wedoqa.com/");
    }

    public List<PostPanel> getPosts() {
        List<PostPanel> postPanels = new ArrayList<>();
        postsRoots.stream().forEach(element -> postPanels.add(new PostPanel(driver, element)));
        return postPanels;
    }

    public void clickFirstPost() {
        
        postsRoots.stream().findAny().get().findElement(By.cssSelector("a")).click();
    }
    
    public void clickRandomPost() {
        
        postsRoots.
                get(new Random().nextInt(postsRoots.size()-1)).findElement(By.cssSelector(".title a")).click();
    }
}
