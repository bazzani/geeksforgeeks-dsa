package bevans.geeksforgeeks.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlidingWindowTechniqueTest {

    private SlidingWindowTechnique sut;

    @BeforeEach
    public void setup() {
        sut = new SlidingWindowTechnique();
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
                , Arguments.of(new int[]{}, 1, "20 10 30")
        );
    }
}
