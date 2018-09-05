/**
 * 746. Min Cost Climbing Stairs
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * Created by xialingpeng on 2018/8/16.
 */
public class leetcode_746 {

//    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
//    Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length <= 0) return 0;
            int[] dp = new int[cost.length];
            for (int i = cost.length - 1; i >= 0; i--) {
                if (i == cost.length - 1 || i == cost.length - 2) {
                    dp[i] = cost[i];
                } else {
                    dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
                }
            }
            //note： you can either start from the step with index 0, or the step with index 1.
            // 这个才是为什么倒序和比较dp[0]和dp[1]的原因
            return Math.min(dp[0], dp[1]);
        }
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 0, 0, 0};
        int minCostClimbingStairs = new leetcode_746().new Solution().minCostClimbingStairs(cost);
        System.out.println(minCostClimbingStairs);
    }
}
