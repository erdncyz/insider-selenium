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
            // Create Page Objects
            HomePage homePage = new HomePage(driver);
            MorePage morePage = new MorePage(driver);
            CareersPage careersPage = new CareersPage(driver);
            QAPage qaPage = new QAPage(driver);
            OpenPositionPage positionPage = new OpenPositionPage(driver);
            VerifyLeverPage leverPage = new VerifyLeverPage(driver);

            // Execute test steps
            System.out.println("Starting QA Jobs verification test...");
            
            // 1. Homepage verification
            System.out.println("Verifying homepage...");
            homePage.verifyInsiderLogo();
            homePage.acceptAllPermissions();

            System.out.println("Clicking Company Header Menu...");
            homePage.clickCompanyMenu();
            
            // 2. Navigation
            System.out.println("Clicked to Careers page...");
            morePage.clickCareers();
            
            // 3. Career page verification
            System.out.println("Verifying careers page...");
            careersPage.verifyCareersPage();
            
            // 4. QA department selection
            System.out.println("Selecting QA department...");
            careersPage.selectQualityAssurance();

            // 5. See All QA Jobs
            System.out.println("Selecting QA jobs...");
            qaPage.selectQAJobs();
            
            // 6. QA positions
            System.out.println("Listing QA positions...");
            positionPage.openPositionPage();
            
            // 7. Lever page verification
            System.out.println("Verifying Lever page...");
            leverPage.verifyPage();
            
            // Test successful
            assertTestPassed("QA Jobs Verification");
            
        } catch (Exception e) {
            logTestError("QA Jobs Verification", e.getMessage());
            throw e;
        }
    }
} 