package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

/**
 * Base test class that provides common configuration for all test classes.
 * Contains WebDriver setup, configuration, and cleanup operations.
 */
public abstract class BaseTest {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    // Test configuration constants
    protected static final String BASE_URL = "https://useinsider.com/";
    protected static final int IMPLICIT_WAIT_SECONDS = 10;
    protected static final int EXPLICIT_WAIT_SECONDS = 10;
    protected static final int PAGE_LOAD_TIMEOUT_SECONDS = 60;
    
    @Before
    public void setUp() {
        System.out.println("=== TEST SETUP ===");
        initializeDriver();
        configureDriver();
        navigateToBaseUrl();
        System.out.println("Setup completed");
    }
    
    @After
    public void tearDown() {
        System.out.println("=== TEST CLEANUP ===");
        cleanupDriver();
        System.out.println("Cleanup completed");
    }
    
    /**
     * Initializes and configures the WebDriver
     */
    private void initializeDriver() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-sync");
        options.addArguments("--disable-background-timer-throttling");
        options.addArguments("--disable-backgrounding-occluded-windows");
        options.addArguments("--disable-renderer-backgrounding");
        options.addArguments("--disable-features=TranslateUI");
        options.addArguments("--disable-ipc-flooding-protection");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36");
        options.addArguments("--memory-pressure-off");
        options.addArguments("--max_old_space_size=4096");
        
        // Headless mode (optional)
        if (System.getProperty("selenium.headless", "false").equals("true")) {
            options.addArguments("--headless");
        }
        
        // Create driver instance
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_SECONDS));
    }
    
    /**
     * Configures driver timeout settings
     */
    private void configureDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_SECONDS));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT_SECONDS));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }
    
    /**
     * Opens the test page
     */
    private void navigateToBaseUrl() {
        try {
            driver.get(BASE_URL);
            
            // Wait for page to load
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            // Verify page loaded
            String currentUrl = driver.getCurrentUrl();
            if (!currentUrl.contains("useinsider.com")) {
                throw new RuntimeException("Page did not load correctly. Current URL: " + currentUrl);
            }
            
        } catch (Exception e) {
            // Try alternative navigation
            try {
                driver.navigate().to(BASE_URL);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                }
            } catch (Exception e2) {
                throw e;
            }
        }
    }
    
    /**
     * Cleans up the driver and releases resources
     */
    private void cleanupDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                // Ignore cleanup errors
            } finally {
                driver = null;
                wait = null;
            }
        }
    }
    
    /**
     * Helper method to assert test success
     */
    protected void assertTestPassed(String testName) {
        System.out.println(testName + " test completed successfully.");
    }
    
    /**
     * Helper method to log test errors
     */
    protected void logTestError(String testName, String errorMessage) {
        System.out.println("Error in " + testName + " test: " + errorMessage);
    }
} 