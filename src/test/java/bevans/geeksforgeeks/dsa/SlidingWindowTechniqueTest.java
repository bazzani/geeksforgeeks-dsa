package bevans.geeksforgeeks.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWindowTechniqueTest {

    private SlidingWindowTechnique sut;

    @BeforeEach
    public void setup() {
        sut = new SlidingWindowTechnique();
    }

    @ParameterizedTest(name = "Input {0}, Sum {1}, Expected Indices {2}")
    @MethodSource("subArrayWithGivenSumData")
    void shouldFindSubArrayWithGivenSum(int[] input, int sum, int[] expectedIndices) {
        // Given a 1-based indexing array arr[] of integers and an integer sum.
        // You mainly need to return the left and right indexes(1-based indexing) of that subarray.
        // In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.
        // If no such subarray exists return an array consisting of element -1.

        // given
        // when
        var indices = sut.subArrayWithGivenSumTreeSet(input, sum);

        // then
        var indicesIntArray = indices.stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expectedIndices, indicesIntArray);
    }

    public static Stream<Arguments> subArrayWithGivenSumData() {
        //Explanation: Sum of elements between indices 2 and 5 is 2 + 4 + 8 + 9 = 23
        //Explanation: Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7
        //Explanation: There is no subarray with 0 sum

        return Stream.of(Arguments.of(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23, new int[]{2, 5})
                , Arguments.of(new int[]{1, 4, 0, 0, 3, 10, 5}, 7, new int[]{2, 5})
                , Arguments.of(new int[]{1, 4}, 0, new int[]{-1})
                , Arguments.of(new int[]{7, 2, 1}, 2, new int[]{2, 2})
        );
    }

    @ParameterizedTest(name = "Input {0}, k {1}, Expected Max Values {2}")
    @MethodSource("maximumOfSubArraysSizeK")
    void shouldFindMaximumOfSubArraysSizeK(int[] input, int k, String expectedMaxValues) {
        // Given an array and an integer K, find the maximum for each and every contiguous subarray of size K.

        // given
        // when
        String maxValues = sut.maximumOfSubArraysSizeK(input, k);

        // then
        assertEquals(expectedMaxValues, maxValues);
    }

    public static Stream<Arguments> maximumOfSubArraysSizeK() {
        //Explanation: Maximum of 1, 2, 3 is 3
        //             Maximum of 2, 3, 1 is 3
        //             Maximum of 3, 1, 4 is 4
        //             Maximum of 1, 4, 5 is 5
        //Explanation: Maximum of first 4 elements is 10, similarly for next 4
        //              elements (i.e from index 1 to 4) is 10, So the sequence
        //              generated is 10 10 10 15 15 90 90
        return Stream.of(Arguments.of(new int[]{1, 2, 3, 1, 4, 5}, 3, "3 3 4 5")
                , Arguments.of(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4, "10 10 10 15 15 90 90")
                , Arguments.of(new int[]{20, 10, 30}, 1, "20 10 30")
                , Arguments.of(new int[]{}, 1, null)
        );
    }
}
