package bevans.geeksforgeeks.dsa;

import java.util.Arrays;
import java.util.StringJoiner;

public class SlidingWindowTechnique {
    public String maximumOfSubArraysSizeK(int[] input, int k) {
        var maxValues = new StringJoiner(" ");
        int lastStartIndex = input.length - k + 1;

        for (int i = 0; i < lastStartIndex; i++) {
            int[] ints = Arrays.copyOfRange(input, i, i + k);
            Arrays.sort(ints);
            var max = ints[ints.length - 1];
            maxValues.add(String.valueOf(max));
        }

        return maxValues.toString();
    }
}
