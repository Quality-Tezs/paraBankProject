package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class LoginPage {

    WebDriver driver = DriverFactory.getDriver();

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//input[@value='Log In']");

    public void openSite(String url) {
        driver.get(url);
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}