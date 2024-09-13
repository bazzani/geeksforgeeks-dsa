package bevans.geeksforgeeks.dsa;

import java.util.*;

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

    public List<Integer> maximumOfSubArraysSizeK(int[] input, int k) {
        if (input.length < k) {
            return null;
        }

        var maxValues = new ArrayList<Integer>();
        var windowedInts = new TreeSet<Integer>();

        for (int i = 0; i < k; i++) {
            windowedInts.add(input[i]);
        }
        maxValues.add(windowedInts.last());

        int lastStartIndex = input.length - k;
        for (int i = 0; i < lastStartIndex; i++) {
            windowedInts.remove(input[i]);
            windowedInts.add(input[i + k]);
            maxValues.add(windowedInts.last());
        }

        return maxValues;
    }

    public List<Integer> maximumOfSubArraysSizeKMaxHeap(int[] arr, int k) {
        if (arr.length < k) {
            return null;
        }

        var ans = new ArrayList<Integer>();
        var heap = new PriorityQueue<Pair>((a, b) -> b.value - a.value);

        for (int i = 0; i < k; i++) {
            heap.offer(Pair.of(arr[i], i));
        }
        ans.add(heap.peek().value);

        for (int i = k; i < arr.length; i++) {
            heap.offer(Pair.of(arr[i], i));

            while (heap.peek().index <= i - k) {
                heap.poll();
            }

            ans.add(heap.peek().value);
        }

        return ans;
    }

    private static class Pair {
        private int value;

        private int index;

        private static Pair of(int value, int index) {
            var pair = new Pair();
            pair.value = value;
            pair.index = index;
            return pair;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]")
                    .add("value=" + value)
                    .add("index=" + index)
                    .toString();
        }
    }
}
