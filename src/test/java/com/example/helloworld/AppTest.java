package com.example.helloworld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for App.
 */
public class AppTest {

    @Test
    public void testAppRuns() {
        try {
            App.main(new String[]{});
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false, "App.main should not throw an exception");
        }
    }
}
