package bevans.geeksforgeeks.dsa;

import java.util.StringJoiner;
import java.util.TreeSet;

public class SlidingWindowTechnique {
    public String subArrayWithGivenSum(int[] input, int sum) {
        var sumIndices = new StringJoiner(" ");
        sumIndices.setEmptyValue("-1");

        int last = input.length;
        int start = 0;
        var currentSum = input[start];

        for (int end = 1; end <= last; end++) {
            while (currentSum > sum && start < end - 1) {
                currentSum -= input[start++];
            }

            if (currentSum == sum) {
                sumIndices.add(getStringValue(start + 1));
                sumIndices.add(getStringValue(end));
                return sumIndices.toString();
            }

            if (end < last) {
                currentSum += input[end];
            }
        }

        return sumIndices.toString();
    }

    private String getStringValue(int intValue) {
        return String.valueOf(intValue);
    }

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
