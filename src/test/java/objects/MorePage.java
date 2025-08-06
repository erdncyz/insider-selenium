package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MorePage {
    WebDriver driver;

    public MorePage(WebDriver driver) {
        this.driver = driver;
    }

    By click_careers = By.xpath("(//a[normalize-space()='Careers'])[1]");


    public void clickCareers() {
        WebElement careersLink = driver.findElement(click_careers);
        careersLink.click();
    }
}