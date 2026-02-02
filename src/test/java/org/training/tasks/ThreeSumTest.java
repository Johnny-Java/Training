package org.training.tasks;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    private final ThreeSum solution = new ThreeSum();

    @Test
    void testBasicCase() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSingleElement() {
        int[] nums = {0};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    void testAllZeros() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = List.of(Arrays.asList(0, 0, 0));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected, result);
    }

    @Test
    void testNoSolution() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    void testWithDuplicates() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> expected = List.of(Arrays.asList(-2, 0, 2));
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testLargeNumbers() {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> result = solution.threeSum(nums);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }
}
