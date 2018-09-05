/**
 * 474. Ones and Zeroes
 * https://leetcode.com/problems/ones-and-zeroes/description/
 * Created by xialingpeng on 2018/8/16.
 */
public class leetcode_474 {

//    In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
//
//    For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
//
//    Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
//
//    Note:
//    The given numbers of 0s and 1s will both not exceed 100
//    The size of given string array won't exceed 600.

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length <= 0) return 0;

            int[][] dp = new int[m + 1][n + 1];

            for (String str : strs) {
                int[] zeroAndOne = findZeroAndOne(str);
                int zero = zeroAndOne[0];
                int one = zeroAndOne[1];
                //这个其实是一个滚动的二维数组，从后面加起是为了不覆盖上一次的数据
                for (int i = m; i >= zero; i--) {
                    for (int j = n; j >= one; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    }
                }
            }
            return dp[m][n];
        }

        private int[] findZeroAndOne(String str) {
            int[] result = new int[2];
            if (str == null || str.length() == 0) return result;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    result[0]++;
                } else if (str.charAt(i) == '1') {
                    result[1]++;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String[] input = new String[]{"10", "0001", "111001", "1", "0"};
        int maxForm = new leetcode_474().new Solution().findMaxForm(input, 5, 3);
        System.out.println(maxForm);
    }
}
