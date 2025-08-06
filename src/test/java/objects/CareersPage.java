package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage {
    
    WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    By our_locations = By.cssSelector(".category-title-media.ml-0");
    By life_at_insider = By.xpath("//h2[text()='Life at Insider']");
    By all_them_button = By.xpath("//a[text()='See all teams']");
    By select_QA = By.xpath("//h3[normalize-space()='Quality Assurance']");

    public void verifyCareersPage(){
        WebElement locationsBlock = driver.findElement(our_locations);
        WebElement lifeBlock = driver.findElement(life_at_insider);
        assert locationsBlock.isDisplayed() && lifeBlock.isDisplayed();
    }

    public void selectQualityAssurance(){
        // Scroll to "See all teams" button to make it visible
        WebElement seeAllTeamsButton = driver.findElement(all_them_button);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeAllTeamsButton);
        
        // Wait a bit for scroll to complete
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Try JavaScript click to avoid navbar interference
        try {
            seeAllTeamsButton.click();
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click...");
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", seeAllTeamsButton);
        }
        
        // Wait for page transition
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        WebElement qualityAssuranceLink = driver.findElement(select_QA);
        // Try JavaScript click to avoid interference
        try {
            qualityAssuranceLink.click();
        } catch (Exception e) {
            System.out.println("Normal click failed for QA, trying JavaScript click...");
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", qualityAssuranceLink);
        }
        
        // Wait for QA page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}