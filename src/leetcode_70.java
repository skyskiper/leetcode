/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 * Created by xialingpeng on 2018/8/15.
 */
public class leetcode_70 {

    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                if (i == 0 || i == 1) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            return dp[n];
        }
    }
}
