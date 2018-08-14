/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * Created by xialingpeng on 2018/8/13.
 */
public class leetcode_96 {

    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = dp[i] + dp[j] * dp[i - 1 - j];
                }
            }
            return dp[n];
        }
    }
}
