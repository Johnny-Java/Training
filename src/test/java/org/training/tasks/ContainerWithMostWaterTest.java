package org.training.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater solution = new ContainerWithMostWater();

    @Test
    void testBasicCase() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, invokeMaxArea(height));
    }

    @Test
    void testTwoElements() {
        int[] height = {1, 1};
        assertEquals(1, invokeMaxArea(height));
    }

    @Test
    void testIncreasingHeight() {
        int[] height = {1, 2, 3, 4, 5};
        assertEquals(6, invokeMaxArea(height));
    }

    @Test
    void testDecreasingHeight() {
        int[] height = {5, 4, 3, 2, 1};
        assertEquals(6, invokeMaxArea(height));
    }

    @Test
    void testAllSameHeight() {
        int[] height = {5, 5, 5, 5};
        assertEquals(15, invokeMaxArea(height));
    }

    @Test
    void testLargeContainer() {
        int[] height = {1, 2, 4, 3};
        assertEquals(4, invokeMaxArea(height));
    }

    @Test
    void testZeroHeight() {
        int[] height = {0, 2};
        assertEquals(0, invokeMaxArea(height));
    }

    // Helper method to invoke static maxArea method
    private int invokeMaxArea(int[] height) {
        try {
            var method = ContainerWithMostWater.class.getDeclaredMethod("maxArea", int[].class);
            method.setAccessible(true);
            return (int) method.invoke(null, height);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
