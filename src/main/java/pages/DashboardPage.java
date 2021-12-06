package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private By dashboardItem = By.cssSelector("[class] .breadcrumb-item:nth-of-type(2) .text-muted");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getHeaderText(){
    	sleep(3000);
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardItem));
        return driver.findElement(dashboardItem).getText();
    }
    
    private void sleep(int x) {
		try {
			Thread.sleep(x);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
