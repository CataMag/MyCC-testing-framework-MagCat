package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkLogPage {
	private WebDriver driver;
	private By workLogHeader = By.xpath("//*[@id=\"kt_content\"]/div/div/h3");
	private By duplicateButton = By.xpath("(//button[@class=\"btn btn-icon btn-circle mr-3 btn-secondary btn-sm\"])[2]");
	private By duplicateModal = By.xpath("//*[@id=\"logWorkModal___BV_modal_header_\"]");
	private By datePick = By.xpath("//button[@class=\"btn h-auto\"]");
	private By datePickModal = By.xpath("//div[@id=\"created-at-datepicker__dialog_\"]");
	private By dayPick = By.xpath("//div[@data-date=\"2021-12-09\"]");
	private By timePick = By.xpath("//input[@placeholder=\"HH:mm\"]");
	private By timePickModal = By.xpath("//ul[@class=\"hours\"]");
	private By hoursPick = By.xpath("//li[@data-key=\"02\"]");
	private By saveButton = By.xpath("//button[@class=\"btn font-weight-bolder font-size-sm btn-primary\"]");
	private By savedSuccess = By.xpath("//div[@class=\"layout column\"]");
	
	private By addButton = By.xpath("//button[@class=\"btn float-right d-flex align-items-center btn-primary btn-sm\"]");
	private By addModal = By.xpath("//*[@id=\"logWorkModal___BV_modal_header_\"]");
	private By project = By.xpath("//select[@id='project-input']");
	private By projectSelect = By.xpath("//*[@id=\"project-input\"]/option[2]");
	private By task = By.xpath("//select[@id='task-input']");
	private By taskSelect = By.xpath("//*[@id=\"task-input\"]/option[2]");
	private By addDatePick = By.xpath("//button[@class=\"btn h-auto\"]");
	private By dayPickAdd = By.xpath("//div[@data-date=\"2021-12-10\"]");
	private By comment = By.xpath("//textarea[@id='comments-minutes-input']");
	
	public WorkLogPage(WebDriver driver){
        this.driver = driver;
    }
	
	public String duplicateWorkLog() {
		sleep(3000);
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(workLogHeader));
		
		sleep(2000);
		
		driver.findElement(duplicateButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(duplicateModal));
		
		sleep(2000);
		
		driver.findElement(datePick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(datePickModal));
		driver.findElement(dayPick).click();
		
		sleep(2000);
		
		driver.findElement(timePick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(timePickModal));
		driver.findElement(hoursPick).click();
		
		sleep(2000);
		
		driver.findElement(saveButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(savedSuccess));
		
		return driver.findElement(savedSuccess).getText();
	}
	
	public String addWorkLog() {
		sleep(3000);
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(workLogHeader));
		
		sleep(2000);
		
		driver.findElement(addButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addModal));
		
		sleep(2000);
		
		driver.findElement(project).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(projectSelect));
		driver.findElement(projectSelect).click();
		
		sleep(2000);
		
		driver.findElement(task).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskSelect));
		driver.findElement(taskSelect).click();
		
		sleep(2000);
		
		driver.findElement(addDatePick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(datePickModal));
		driver.findElement(dayPickAdd).click();
		
		sleep(2000);
		
		driver.findElement(timePick).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(timePickModal));
		driver.findElement(hoursPick).click();
		
		sleep(2000);
		driver.findElement(comment).click();
		
		sleep(2000);
		driver.findElement(comment).sendKeys("Dummy test for add work log (automated)");
		
		sleep(2000);
		
		driver.findElement(saveButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(savedSuccess));
		
		return driver.findElement(savedSuccess).getText();
	}
	
	private void sleep(int x) {
		try {
			Thread.sleep(x);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
