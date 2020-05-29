package Hash;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
    /*
    find length of the latest subarray with 0 sum.
    e.g. {15, -2, 2, -8, 1, 7, 10, 23} --> 5 ({-2, 3, -8, 1, 7})
         {1, 2, 3} --> 0
         {1, 0, 3} --> 1 ({0})
     */

    public static void main(String[] args) {
        int[] input = {15, -2, 2, -8, 1, 7, 10, 23};
        int l = lengthOfLargestSubArrayWithZeroSum(input);
        System.out.println(l);
    }

    private static int lengthOfLargestSubArrayWithZeroSum(int[] input) {
        Map<Integer, Integer> sum2Index = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (input[i] == 0 && maxLen == 0) {
                maxLen = 1;
            }
            if (sum == 0) {
                maxLen = i+1;
            }
            Integer indexOfPreviousSameSum = sum2Index.get(sum);
            if (indexOfPreviousSameSum!=null) {
                maxLen = Math.max(maxLen, i - indexOfPreviousSameSum);
            } else {
                sum2Index.put(sum, i);
            }
        }
        return maxLen;
    }
}
