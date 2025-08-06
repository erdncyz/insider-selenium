package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Page Object class for the Lever application page.
 * Contains all the elements and actions related to the Lever page verification.
 */
public class VerifyLeverPage {

    private WebDriver driver;

    public VerifyLeverPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By applyForJobButton = By.xpath("(//a[contains(text(),'Apply for this job')])[1]");

    /**
     * Verifies that the Lever page is loaded correctly by switching to the new window
     * and checking for the apply button
     */
    public void verifyPage() {
        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        String parentWindowHandle = driver.getWindowHandle();

        // Find the new window handle
        String newWindowHandle = null;
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(parentWindowHandle)) {
                newWindowHandle = windowHandle;
            }
        }
        
        // Switch to the new window
        driver.switchTo().window(newWindowHandle);
        
        // Verify the apply button is displayed
        WebElement leverApplyButton = driver.findElement(applyForJobButton);
        leverApplyButton.isDisplayed();
    }
} 