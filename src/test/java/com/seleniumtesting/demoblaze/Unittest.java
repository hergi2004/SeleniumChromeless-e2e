package com.seleniumtesting.demoblaze;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Trivial test class. Demonstrates the syntax of JUnit4.
 * Important: Do NOT inherit this class from TestCase() or JUnit3.x is enforced
 *
 * @author Herve Tcheukado
 */
public class Unittest {
    @Test
    public void testIsThisReallyTrue() {
        assertTrue(true);
    }
}
