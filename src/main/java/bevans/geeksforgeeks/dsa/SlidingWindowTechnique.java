package bevans.geeksforgeeks.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.TreeSet;

public class SlidingWindowTechnique {
    public List<Integer> subArrayWithGivenSumTreeSet(int[] arr, int sum) {
        var currentSum = 0;
        var start = 0;
        var end = 0;
        var flag = false;
        var sumIndices = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum >= sum) {
                end = i;

                while (currentSum > sum && start < end) {
                    currentSum -= arr[start];
                    ++start;
                }

                if (currentSum == sum) {
                    sumIndices.add(start + 1);
                    sumIndices.add(end + 1);
                    flag = true;
                    break;
                }
            }
        }

        if (!flag) {
            sumIndices.add(-1);
        }

        return sumIndices;
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
