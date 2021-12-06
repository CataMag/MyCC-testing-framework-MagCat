package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.cssSelector("form#kt_login_signin_form input[name='email']");
    private By passwordField = By.cssSelector("form#kt_login_signin_form input[name='password']");
    private By signInButton = By.cssSelector(".btn.btn-primary.font-size-h6.font-weight-bolder.px-15.py-3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage(WebDriver driver, String format) {
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickSignInButton(){
        driver.findElement(signInButton).click();
        return new DashboardPage(driver);
    }
}
