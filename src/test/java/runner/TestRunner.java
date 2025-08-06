package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import test_scenarios.VerifyQAJobs;

/**
 * Test suite to run all test classes.
 * This class is used to execute all test scenarios in the project at once.
 */
@RunWith(Suite.class)
@SuiteClasses({
    VerifyQAJobs.class
    // New test classes can be added here
})
public class TestRunner {
    
    /**
     * Initializes the test suite.
     * This class should be empty, used only for grouping test classes.
     */
    public TestRunner() {
        // Constructor should be empty
    }
} 