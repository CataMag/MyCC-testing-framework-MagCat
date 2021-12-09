package tests;

import base.Base;
import lombok.extern.slf4j.Slf4j;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPage;

import static org.testng.Assert.assertTrue;

import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

@Slf4j
public class LoginTests extends Base {
	
    @Test(groups = "end2end")
    @Parameters({"user", "password"})
    public void testSuccessfulSignIn(String user, String password){
    	
    	//Start timer
        setTimestamp("testSuccessfulSignIn");
        
        loginPage.setUsername(user);
        Reporter.log("Enter username: " + user);
        log.debug("Once before all tests within this class");
        loginPage.setPassword(password);
        Reporter.log("Enter password: " + password);
        DashboardPage dashboardPage = loginPage.clickSignInButton();
        dashboardPage.getHeaderText();
        
        assertTrue(dashboardPage.getHeaderText()
                        .contains("Dashboard")
                , "Successful sign in!");
        
        //Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("testSuccessfulSignIn") + " ms");
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("testSuccessfulSignIn")));
        System.out.println(getDurationInMillisFrom("testSuccessfulSignIn"));
        long maxDuration = 10000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("testSuccessfulSignIn"));
    }

    @Test(groups = "end2end")
    public void testSuccessfulLogin1() throws InterruptedException {
        loginPage.setUsername("cctestuser9@yopmail.com");
        loginPage.setPassword("CCTest@2021");
        DashboardPage dashboardPage = loginPage.clickSignInButton();
        dashboardPage.getHeaderText();
        assertTrue(dashboardPage.getHeaderText()
                        .contains("Dashboard")
                , "Successful sign in!");
    }

    @Test(groups = "end2end")
    public void testSuccessfulLogin2() throws InterruptedException {
        loginPage.setUsername("cctestuser9@yopmail.com");
        loginPage.setPassword("CCTest@2021");
        DashboardPage dashboardPage = loginPage.clickSignInButton();
        dashboardPage.getHeaderText();
        assertTrue(dashboardPage.getHeaderText()
                        .contains("Dashboard")
                , "Successful sign in!");
    }
    
    
}
