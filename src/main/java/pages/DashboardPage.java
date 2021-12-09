package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private By dashboardItem = By.cssSelector("[class] .breadcrumb-item:nth-of-type(2) .text-muted");
    private By timesheetMenu = By.cssSelector("li:nth-of-type(3) > .menu-link.menu-toggle > .menu-text");
    private By workLog = By.xpath("//*[@id=\"kt_aside_menu\"]/div/ul/li[3]/div/ul/li[2]/a/span");
    

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getHeaderText(){
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardItem));
        return driver.findElement(dashboardItem).getText();
    }
    
    public WorkLogPage goToWorkLog() {
    	driver.findElement(timesheetMenu).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(workLog));
		driver.findElement(workLog).click();
		
		return new WorkLogPage(driver);
    }
}
