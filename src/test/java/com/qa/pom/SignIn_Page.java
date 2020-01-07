package com.qa.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn_Page extends Base {

    By userNameLocator = By.name("userName");
    By passwordLocator = By.name("password");
    By signInButtonLocator = By.name("login");
    By flightFinderImagePageLocator = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");

    public SignIn_Page(WebDriver driver){
        super(driver);
    }


    public void signInUser(){

        type("jhudy3",userNameLocator);
        type("12345",passwordLocator);
        click(signInButtonLocator);

    }

    public Object getImageFlightFinder(){
        return flightFinderImagePageLocator;
    }
}
