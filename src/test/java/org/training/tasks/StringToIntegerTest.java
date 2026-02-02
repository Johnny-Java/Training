package org.training.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    private final StringToInteger solution = new StringToInteger();

    @Test
    void testBasicPositiveNumber() {
        assertEquals(42, invokeMyAtoi("42"));
    }

    @Test
    void testNegativeNumber() {
        assertEquals(-42, invokeMyAtoi("   -42"));
    }

    @Test
    void testWithLeadingSpaces() {
        assertEquals(4193, invokeMyAtoi("4193 with words"));
    }

    @Test
    void testOverflow() {
        assertEquals(Integer.MIN_VALUE, invokeMyAtoi("-91283472332"));
    }

    @Test
    void testPositiveOverflow() {
        assertEquals(Integer.MAX_VALUE, invokeMyAtoi("91283472332"));
    }

    @Test
    void testWordsBeforeNumber() {
        assertEquals(0, invokeMyAtoi("words and 987"));
    }

    @Test
    void testZero() {
        assertEquals(0, invokeMyAtoi("0"));
    }

    @Test
    void testPlusSign() {
        assertEquals(42, invokeMyAtoi("+42"));
    }

    @Test
    void testOnlySpaces() {
        assertEquals(0, invokeMyAtoi("   "));
    }

    @Test
    void testMinusZero() {
        assertEquals(0, invokeMyAtoi("-0"));
    }

    // Helper method to invoke private myAtoi method via reflection
    private int invokeMyAtoi(String s) {
        try {
            var method = StringToInteger.class.getDeclaredMethod("myAtoi", String.class);
            method.setAccessible(true);
            return (int) method.invoke(solution, s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
