package bevans.geeksforgeeks.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWindowTechniqueTest {

    private SlidingWindowTechnique sut;

    @Test
    void shouldFindSmallestSubArray() {
        // given
        int[] input = {1, 4, 45, 6, 0, 19};
        // when
        int sum = sut.smallestSubArrayWithSumGreaterThan(input, 51);
        // then
        assertEquals(3, sum);

        // given
        input = new int[]{1, 10, 5, 2, 7};
        // when
        sum = sut.smallestSubArrayWithSumGreaterThan(input, 9);
        // then
        assertEquals(1, sum);

        // given
        input = new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        // when
        sum = sut.smallestSubArrayWithSumGreaterThan(input, 280);
        // then
        assertEquals(4, sum);

        // given
        input = new int[]{1, 2, 4};
        // when
        sum = sut.smallestSubArrayWithSumGreaterThan(input, 8);
        // then
        assertEquals(-1, sum);
    }

    //Minimum length subarray is {4, 45, 6}
    //Minimum length subarray is {10}
    //Minimum length subarray is {100, 1, 0, 200}
    //Whole array sum is smaller than 8.
}
