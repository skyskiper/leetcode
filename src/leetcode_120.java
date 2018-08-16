import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/description/
 * Created by xialingpeng on 2018/8/15.
 */
public class leetcode_120 {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            //数据合法性检验
            if (triangle == null || triangle.size() <= 0) return 0;
            for (int i = 0, triangleSize = triangle.size(); i < triangleSize; i++) {
                List<Integer> integers = triangle.get(i);
                if (integers == null || integers.size() < i + 1) return 0;
            }

            int[] dp = new int[triangle.get(triangle.size() - 1).size()];

            for (int i = 0; i < triangle.size(); i++) {
                List<Integer> eachFloor = triangle.get(i);
                for (int j = eachFloor.size() - 1; j >= 0; j--) {
                    if (j == 0) {
                        dp[0] = dp[0] + eachFloor.get(0);
                    } else if (j == eachFloor.size() - 1) {
                        dp[j] = dp[j - 1] + eachFloor.get(j);
                    } else {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + +eachFloor.get(j);
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i] < result) {
                    result = dp[i];
                }
            }
            return result;
        }
    }
}
