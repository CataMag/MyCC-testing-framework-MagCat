package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private By dashboardItem = By.cssSelector("[class] .breadcrumb-item:nth-of-type(2) .text-muted");
    private By timesheetMenu = By.cssSelector("li:nth-of-type(3) > .menu-link.menu-toggle > .menu-text");
    private By workLog = By.xpath("//*[@id=\"kt_aside_menu\"]/div/ul/li[3]/div/ul/li[2]/a/span");
    
    private By workLogArea = By.xpath("//*[@class=\"position-absolute bg-light\"]");
    private By addWorkLog = By.xpath("//*[@id=\"dashboard-step-4\"]/div/div[2]/div[3]/button");
    private By addModal = By.xpath("//*[@id=\"logWorkModal___BV_modal_header_\"]");
	private By project = By.xpath("//select[@id='project-input']");
	private By projectSelect = By.xpath("//*[@id=\"project-input\"]/option[2]");
	private By task = By.xpath("//select[@id='task-input']");
	private By taskSelect = By.xpath("//*[@id=\"task-input\"]/option[2]");
	private By timePick = By.xpath("//input[@placeholder=\"HH:mm\"]");
	private By hoursPick = By.xpath("//li[@data-key=\"02\"]");
	private By minutesPick = By.xpath("//ul[2]//li[@data-key=\"30\"]");
	private By comment = By.xpath("//textarea[@id='comments-minutes-input']");
	private By saveButton = By.xpath("//button[@class=\"btn font-weight-bolder font-size-sm btn-primary\"]");
	private By savedSuccess = By.xpath("//div[@class=\"layout column\"]");

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
    
    public String addWorkLogFromDashboard() {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(workLogArea));
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		WebElement logWorkButton = driver.findElement(addWorkLog);
		jse.executeScript("arguments[0].click()", logWorkButton);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addModal));
		
		driver.findElement(project).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(projectSelect));
		driver.findElement(projectSelect).click();
		
		driver.findElement(task).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskSelect));
		driver.findElement(taskSelect).click();
		
		driver.findElement(timePick).click();
		driver.findElement(hoursPick).click();
		
		driver.findElement(timePick).click();
		driver.findElement(minutesPick).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(comment));
		driver.findElement(comment).click();

		driver.findElement(comment).sendKeys("Dummy test for add work log Dashboard (automated)");
		
		
		driver.findElement(saveButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(savedSuccess));
		
		return driver.findElement(savedSuccess).getText();
    }
}
