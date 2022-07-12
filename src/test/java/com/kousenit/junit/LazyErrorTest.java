package com.kousenit.junit;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LazyErrorTest {

    private String getErrorMessage() {
        System.out.println("getErrorMessage()");
        return "error message";
    }

    private String getLogMessage() {
        System.out.println("getLogMessage()");
        return "log message";
    }

    @Test
    public void trueAssertion() {
        boolean x = true;
        // assertTrue(x, getErrorMessage());  // "eager" --> retreives message even when not needed
        assertTrue(x, () -> getErrorMessage());  // "lazy" --> retreives message only when needed
        // assertTrue(x, this::getErrorMessage);  // "lazy" --> retreives message only when needed
    }

    @Test
    void lazyLogging() {
        Logger logger = Logger.getLogger("com.kousenit.junit.LazyErrorTest");
        logger.fine(getLogMessage()); // eager
        logger.fine(() -> getLogMessage()); // lazy
    }
}
