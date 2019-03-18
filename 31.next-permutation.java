/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.07%)
 * Total Accepted:    218.7K
 * Total Submissions: 726.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int changePos = nums.length - 1;
        while (changePos > 1 && nums[changePos] <= nums[changePos - 1]) {
            changePos--;
        }
        if (nums[changePos - 1] >= nums[changePos]) {
            // 依次递减，此时需要全部倒序
            revert(nums, 0, nums.length - 1);
        } else {
            // changPos（包括changePos）后面的递减，此时从中找出最小的大于changePos-1的数置换
            int changePos2 = nums.length - 1;
            while (nums[changePos - 1] >= nums[changePos2]) {
                changePos2--;
            }

            int tmp = nums[changePos - 1];
            nums[changePos - 1] = nums[changePos2];
            nums[changePos2] = tmp;

            revert(nums, changePos, nums.length - 1);
        }

    }

    private void revert(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
