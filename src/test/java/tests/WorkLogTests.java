package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.WorkLogPage;

public class WorkLogTests extends BaseTest{
	
	@Test(groups = "end2end")
    public void testDuplicateWorkLog() throws InterruptedException {
		
        loginPage.setUsername("cctestuser9@yopmail.com");
        loginPage.setPassword("CCTest@2021");
        
        DashboardPage dashboardPage = loginPage.clickSignInButton();
        WorkLogPage workLogPage = dashboardPage.goToWorkLog();
        System.out.println(workLogPage.duplicateWorkLog());
        assertTrue(workLogPage.duplicateWorkLog()
                        .contains("Work log created successfully!")
                , "Successful duplicate work log");
    }
	
	@Test(groups = "end2end")
	public void testAddWorkLog() throws InterruptedException {
		
        loginPage.setUsername("cctestuser9@yopmail.com");
        loginPage.setPassword("CCTest@2021");
        
        DashboardPage dashboardPage = loginPage.clickSignInButton();
        WorkLogPage workLogPage = dashboardPage.goToWorkLog();
        assertTrue(workLogPage.addWorkLog()
                        .contains("Work log created successfully!")
                , "Successful duplicate work log");
    }
}
