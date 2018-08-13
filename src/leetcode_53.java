/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * Maximum Subarray
 * Created by xialingpeng on 2018/8/10.
 */
public class leetcode_53 {

    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length <= 0) return 0;
            int maxSum = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum < 0) {
                    sum = nums[i];
                } else {
                    sum = sum + nums[i];
                }
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
            return maxSum;
        }
    }
}
