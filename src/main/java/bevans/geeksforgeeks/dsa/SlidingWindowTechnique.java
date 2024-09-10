package bevans.geeksforgeeks.dsa;

import java.util.StringJoiner;
import java.util.TreeSet;

public class SlidingWindowTechnique {
    public String subArrayWithGivenSum(int[] input, int sum) {
        var sumIndices = new StringJoiner(" ");
        sumIndices.setEmptyValue("-1");

        int leftIndex = 0;
        int rightIndex = 0;
        var currentSum = input[leftIndex];

        while (rightIndex < input.length) {
            if (currentSum < sum) {
                rightIndex++;
                currentSum += input[rightIndex];
            } else if (currentSum > sum) {
                currentSum -= input[leftIndex];
                leftIndex++;
            }

            if (currentSum == sum) {
                sumIndices.add(String.valueOf(leftIndex + 1));
                sumIndices.add(String.valueOf(rightIndex + 1));
                break;
            }
        }

        return sumIndices.toString();
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
