package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 22;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> entryIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            entryIndices.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (entryIndices.containsKey(complement)) {
                return new int[]{i, entryIndices.get(complement)};
            }
        }
        return null;
    }
}
