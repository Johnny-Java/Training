package org.training.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntToRomanTest {

    private final IntToRoman solution = new IntToRoman();

    @Test
    void testBasicNumber() {
        assertEquals("MMMDCCXLIX", invokeIntToRoman(3749));
    }

    @Test
    void testSingleDigit() {
        assertEquals("III", invokeIntToRoman(3));
    }

    @Test
    void testSubtractiveNotation() {
        assertEquals("IV", invokeIntToRoman(4));
        assertEquals("IX", invokeIntToRoman(9));
        assertEquals("XL", invokeIntToRoman(40));
        assertEquals("XC", invokeIntToRoman(90));
        assertEquals("CD", invokeIntToRoman(400));
        assertEquals("CM", invokeIntToRoman(900));
    }

    @Test
    void testLargeNumbers() {
        assertEquals("MCMXCIV", invokeIntToRoman(1994));
        assertEquals("LVIII", invokeIntToRoman(58));
    }

    @Test
    void testRoundNumbers() {
        assertEquals("M", invokeIntToRoman(1000));
        assertEquals("D", invokeIntToRoman(500));
        assertEquals("C", invokeIntToRoman(100));
        assertEquals("L", invokeIntToRoman(50));
        assertEquals("X", invokeIntToRoman(10));
        assertEquals("V", invokeIntToRoman(5));
        assertEquals("I", invokeIntToRoman(1));
    }

    @Test
    void testComplexNumbers() {
        assertEquals("MMMCMXCIX", invokeIntToRoman(3999));
        assertEquals("MMCDXXI", invokeIntToRoman(2421));
    }

    // Helper method to invoke intToRomanInternal
    private String invokeIntToRoman(int num) {
        try {
            StringBuilder builder = new StringBuilder();
            var method = IntToRoman.class.getDeclaredMethod("intToRomanInternal", StringBuilder.class, int.class);
            method.setAccessible(true);
            method.invoke(solution, builder, num);
            return builder.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
