package com.qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Register_Page extends Base {

    By registerLinkLocator = By.linkText("REGISTER");
    By registerImagePageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");
    By userNameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerButtonLocator = By.name("register");
    By fontLocator = By.tagName("font");

    public Register_Page(WebDriver driver){
        super(driver);
    }

    public void registerUser() throws InterruptedException {
        click(registerLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(registerImagePageLocator)){
            type("jhudy3",userNameLocator);
            type("12345",passwordLocator);
            type("12345",confirmPasswordLocator);

            click(registerButtonLocator);
        }else {
            System.out.println("Register page was not found");
        }
    }

    public String registerMessage(){
        List<WebElement> fonts = findElements(fontLocator);
        return getText(fonts.get(5));
    }
}
