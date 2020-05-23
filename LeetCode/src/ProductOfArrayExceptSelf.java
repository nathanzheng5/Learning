import org.junit.Assert;
import org.junit.Test;

// leetcode 238
public class ProductOfArrayExceptSelf {

    @Test
    public void test() {
        int[] input = {1,2,3,4};
        int[] output = productExceptSelf(input);
        int[] expected = {24, 12, 8, 6};
        Assert.assertArrayEquals(expected, output);
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];

        L[0] = 1;
        R[length - 1] = 1;

        for (int i = 0; i < length; i++) {
            if (i > 0) {
                L[i] = nums[i-1] * L[i-1];
            }
            int j = length - 1 - i;
            if (j < length - 1) {
                R[j] = nums[j+1] * R[j+1];
            }
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
}
