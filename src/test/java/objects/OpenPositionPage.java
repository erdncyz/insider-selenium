package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenPositionPage {

    WebDriver driver;

    public OpenPositionPage(WebDriver driver) {
        this.driver = driver;
    }


    By click_filter_location = By.xpath("(//span[@class='select2-selection__arrow'])[1]");
    By select_location = By.xpath("//li[@class='select2-results__option']");
    By apply_now_button = By.xpath("(//a[contains(text(),'Apply Now')])[1]");


    public void openPositionPage() throws InterruptedException {
        Thread.sleep(5000);
        WebElement locationFilter = driver.findElement(click_filter_location);
        locationFilter.click();

        List<WebElement> options = driver.findElements(select_location);
        for (WebElement option : options) {
            if (option.getText().equals("Istanbul, Turkey")) {
                option.click();
                break;
            }
        }

        WebElement applyNow = driver.findElement(apply_now_button);
        applyNow.click();
    }
}