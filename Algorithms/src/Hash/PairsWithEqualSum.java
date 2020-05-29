package Hash;

import java.util.HashMap;
import java.util.Map;

public class PairsWithEqualSum {
    /*
    find 4 elements in an array so that a+b = c+d
     */

    public static void main(String[] args) {
        int[] input = {2, 10, 3, 8, 7, 5};
        pairsWithEqualSum(input);
    }

    static void pairsWithEqualSum(int[] input) {
        Map<Integer, int[]> sumPairMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int sum = input[i] + input[j];
                if (sumPairMap.containsKey(sum)) {
                    int[] previousPair = sumPairMap.get(sum);
                    System.out.println(previousPair[0] + " + " + previousPair[1] + " = " + input[i] + " + " + input[j]);
                } else {
                    sumPairMap.put(sum, new int[]{input[i], input[j]});
                }
            }
        }
    }
}
