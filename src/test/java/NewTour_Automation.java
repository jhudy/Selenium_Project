import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NewTour_Automation {
    private WebDriver driver;

    By registerLinkLocator = By.linkText("REGISTER");
    By registerImagePageLocator = By.xpath("//img[@src='/images/masts/mast_register.gif']");

    By userNameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");

    By registerButtonLocator = By.name("register");

    By fontLocator = By.tagName("font");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com/");
    }

    @Test
    public void RegisterUser() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if(driver.findElement(registerImagePageLocator).isDisplayed()){
            driver.findElement(userNameLocator).sendKeys("jhudy");
            driver.findElement(passwordLocator).sendKeys("12345");
            driver.findElement(confirmPasswordLocator).sendKeys("12345");

            driver.findElement(registerButtonLocator).click();
        }
        else {
            System.out.println("Page Register not found");
        }

        List<WebElement> fonts = driver.findElements(fontLocator);

        assertEquals("Note: Your user name is jhudy.",fonts.get(5).getText());

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
