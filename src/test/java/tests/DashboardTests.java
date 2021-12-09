package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.Base;
import pages.DashboardPage;

public class DashboardTests extends Base{
	@Test(groups = "end2end")
	public void testAddWorkLogFromDashboard() throws InterruptedException {
		
        loginPage.setUsername("cctestuser9@yopmail.com");
        loginPage.setPassword("CCTest@2021");
        
        DashboardPage dashboardPage = loginPage.clickSignInButton();
        String successMessageWorkLog = dashboardPage.addWorkLogFromDashboard();
        assertTrue(successMessageWorkLog
                        .contains("Work log created successfully!")
                , "Successful duplicate work log");
    }
}
