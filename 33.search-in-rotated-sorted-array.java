/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (32.67%)
 * Total Accepted:    379.5K
 * Total Submissions: 1.2M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] <= target) {
            while (nums[left] >= nums[right] && left < right) {
                right--;
            }
            return binarySearch(nums, left, right, target);
        } else if (nums[right] >= target) {
            while (nums[left] >= nums[right] && left < right) {
                left++;
            }
            return binarySearch(nums, left, right, target);
        } else {
            return -1;
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right || nums[left] > target || nums[right] < target)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        }
        return binarySearch(nums, left, mid - 1, target);
    }
}
