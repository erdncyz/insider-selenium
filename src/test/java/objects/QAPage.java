package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for the QA department page.
 * Contains all the elements and actions related to the QA department.
 */
public class QAPage {

    private WebDriver driver;

    public QAPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By seeAllQAJobsButton = By.xpath("//a[text()='See all QA jobs']");

    /**
     * Clicks on "See all QA jobs" button to view all QA positions
     */
    public void selectQAJobs() {
        WebElement seeAllQAJobs = driver.findElement(seeAllQAJobsButton);
        seeAllQAJobs.click();
    }
} 