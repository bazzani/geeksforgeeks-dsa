package bevans.geeksforgeeks.dsa;

import java.util.StringJoiner;
import java.util.TreeSet;

public class SlidingWindowTechnique {
    public String maximumOfSubArraysSizeK(int[] input, int k) {
        if (input.length < k) {
            return null;
        }

        var maxValues = new StringJoiner(" ");
        var windowedInts = new TreeSet<Integer>();

        for (int i = 0; i < k; i++) {
            windowedInts.add(input[i]);
        }
        maxValues.add(windowedInts.last().toString());

        int lastStartIndex = input.length - k;
        for (int i = 0; i < lastStartIndex; i++) {
            windowedInts.remove(input[i]);
            windowedInts.add(input[i + k]);
            maxValues.add(windowedInts.last().toString());
        }

        return maxValues.toString();
    }
}
