package DynamicProgramming;

// Also LeetCode Q5
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "abaabc";
        System.out.println(input + " - " + longestPalindrome(input));
    }

    static String longestPalindrome(String s) {
        int size = s.length();
        boolean[][] table = new boolean[size][];
        for (int i = 0; i < size; i++) {
            table[i] = new boolean[size];
        }

        int maxD = -1;
        int iMaxD = -1;
        int jMaxD = -1;
        for (int d = 0; d < size; d++) {
            for (int i = 0; i < size; i++) {
                int j = i + d;
                if (j > size - 1) {
                    continue;
                }
                if (i == j) {
                    table[i][j] = true;
                } else if (d == 1) {
                    table[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    table[i][j] = s.charAt(i) == s.charAt(j) && table[i + 1][j - 1];
                }

                if (table[i][j]) {
                    if (d > maxD) {
                        maxD = d;
                        iMaxD = i;
                        jMaxD = j;
                    }
                }
            }
        }
        return s.substring(iMaxD, jMaxD + 1);
    }

}
