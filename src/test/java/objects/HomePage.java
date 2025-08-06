package objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By insider_logo = By.cssSelector(".navbar-brand.d-flex.flex-row.align-items-center");
    By acceptAllPermission = By.id("wt-cli-accept-all-btn");
    By click_company = By.xpath("(//a[normalize-space()='Company'])[1]");


    public void verifyInsiderLogo() {
        WebElement verify_insider_logo = driver.findElement(insider_logo);
        verify_insider_logo.isDisplayed();
    }

    public void acceptAllPermissions() {
        WebElement acceptAllButton = driver.findElement(acceptAllPermission);
        acceptAllButton.click();
    }

    public void clickCompanyMenu()
    {
        WebElement moreMenu = driver.findElement(click_company);
        moreMenu.click();
    }



}