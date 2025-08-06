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
        // Find and click "See all teams" button
        WebElement seeAllTeamsButton = driver.findElement(all_them_button);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seeAllTeamsButton);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Click with fallback to JavaScript
        try {
            seeAllTeamsButton.click();
        } catch (Exception e) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", seeAllTeamsButton);
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Find and click Quality Assurance link
        WebElement qualityAssuranceLink = driver.findElement(select_QA);
        try {
            qualityAssuranceLink.click();
        } catch (Exception e) {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", qualityAssuranceLink);
        }
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}