package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogging {
    private static final Logger logger = LogManager.getLogger(TestLogging.class);

    public static void main(String[] args) {
        // Log a simple message
        logger.info("This is a test log message.");
    }
}

