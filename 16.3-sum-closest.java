import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.22%)
 * Total Accepted:    295.3K
 * Total Submissions: 712.8K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);

        long result = Integer.MIN_VALUE + target;
        for (int i = 0; i < nums.length - 2; i++) {
            int tmp = nums[i] + twoSumClosest(nums, i + 1, nums.length - 1, target - nums[i]);
            if (tmp == target) {
                return target;
            }
            if (Math.abs(tmp - target) < Math.abs(result - target)) {
                result = tmp;
            }
        }
        return (int) result;
    }

    public int twoSumClosest(int[] nums, int start, int end, int target) {
        long result = Integer.MIN_VALUE + target;
        while (start < end) {
            int tmp = nums[start] + nums[end];
            if (tmp == target) {
                return target;
            }
            if (Math.abs(tmp - target) < Math.abs(result - target)) {
                result = tmp;
            }
            if (tmp > target) {
                end--;
            } else {
                start++;
            }
        }
        return (int) result;
    }
}
