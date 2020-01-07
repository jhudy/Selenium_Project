package com.qa.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SignIn_Test {

    private WebDriver driver;
    private String url;
    SignIn_Page signIn_page;

    @Before
    public void setUp(){
        url = "http://newtours.demoaut.com/mercurywelcome.php";
        signIn_page = new SignIn_Page(driver);
        driver = signIn_page.chromeDriverConnection();
        signIn_page.visit(url);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSignInPOM() {
        signIn_page.signInUser();
        assertNotNull(signIn_page.getImageFlightFinder());
    }

}
