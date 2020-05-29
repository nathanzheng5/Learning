import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        // given an array of integers, find all unit triplets that sums up to zero
        // e.g. {-1, 0, 1, 2, -1, -4, 4} -- > {[-1, 0, 1], [-1, -1, 2], [0, -4, 4]}
        List<int[]> results = threeSum(new int[]{-1, 0, 1, 2, -1, -4, 4});
        if (results != null) {
            results.forEach(result -> System.out.println(Arrays.toString(result)));
        }
    }

    static List<int[]> threeSum(int[] nums) {
        if (nums.length < 3) return null;

        Arrays.sort(nums);

        List<int[]> retVal = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int startI = i + 1;
            int endI = nums.length - 1;

            while (startI < endI) {
                int sum = nums[i] + nums[startI] + nums[endI];

                if (sum == 0) {
                    retVal.add(new int[]{nums[i], nums[startI], nums[endI]});
                    break;

                } else if (sum < 0) {
                    int startI0 = startI;
                    // skip duplicates and bound check
                    while (nums[startI0] == nums[startI] && startI < endI) {
                        startI++;
                    }

                } else {    // sum < 0
                    int endI0 = endI;
                    while (nums[endI0] == nums[endI] && startI < endI) {
                        endI--;
                    }
                }
            }
        }
        return retVal;
    }
}
