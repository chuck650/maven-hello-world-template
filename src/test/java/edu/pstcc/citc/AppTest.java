package edu.pstcc.citc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import edu.pstcc.citc.App;

// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for App.
 */
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Tests that the application can run without throwing an exception.
     */
    @Test
    public void testAppRuns() {
        try {
            App.main(new String[] {});
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false, "App.main should not throw an exception");
        }
    }

    // /**
    //  * Tests that the application prints the correct greeting when a command-line
    //  * argument is provided.
    //  */
    // @Test
    // public void testAppPrintsCorrectOutputWithArgument() {
    //     String expectedOutput = "Hello, TestUser!\n";
    //     App.main(new String[] { "TestUser" });
    //     assertEquals(expectedOutput, outContent.toString());
    // }

    // /**
    //  * Tests that the application prints the default greeting when no command-line
    //  * argument is provided.
    //  */
    // @Test
    // public void testAppPrintsCorrectOutputWithoutArgument() {
    //     String expectedOutput = "Hello, World!\n";
    //     App.main(new String[] {});
    //     assertEquals(expectedOutput, outContent.toString());
    // }
}
