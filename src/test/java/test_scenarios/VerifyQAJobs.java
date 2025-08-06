package test_scenarios;

import base.BaseTest;
import objects.HomePage;
import objects.MorePage;
import objects.CareersPage;
import objects.QAPage;
import objects.OpenPositionPage;
import objects.VerifyLeverPage;
import org.junit.Test;

/**
 * Test class for verifying QA jobs on the Insider website.
 * This test validates the complete navigation from homepage to QA positions.
 */
public class VerifyQAJobs extends BaseTest {

        @Test
    public void verifyQAJobs() throws InterruptedException {
        try {
            System.out.println("=== QA JOBS VERIFICATION TEST STARTED ===");
            
            // Initialize Page Objects
            HomePage homePage = new HomePage(driver);
            MorePage morePage = new MorePage(driver);
            CareersPage careersPage = new CareersPage(driver);
            QAPage qaPage = new QAPage(driver);
            OpenPositionPage positionPage = new OpenPositionPage(driver);
            VerifyLeverPage leverPage = new VerifyLeverPage(driver);

            // Test Steps
            System.out.println("Step 1: Verifying homepage");
            homePage.verifyInsiderLogo();
            homePage.acceptAllPermissions();

            System.out.println("Step 2: Navigating to Company menu");
            homePage.clickCompanyMenu();
            
            System.out.println("Step 3: Navigating to Careers page");
            morePage.clickCareers();
            
            System.out.println("Step 4: Verifying careers page");
            careersPage.verifyCareersPage();
            
            System.out.println("Step 5: Selecting QA department");
            careersPage.selectQualityAssurance();
 
            System.out.println("Step 6: Selecting QA jobs");
            qaPage.selectQAJobs();
            
            System.out.println("Step 7: Filtering positions");
            positionPage.openPositionPage();
            
            System.out.println("Step 8: Verifying Lever page");
            leverPage.verifyPage();
            
            System.out.println("=== TEST COMPLETED SUCCESSFULLY ===");
            assertTestPassed("QA Jobs Verification");
            
        } catch (Exception e) {
            System.out.println("=== TEST FAILED ===");
            System.out.println("Error: " + e.getMessage());
            logTestError("QA Jobs Verification", e.getMessage());
            throw e;
        }
    }
} 