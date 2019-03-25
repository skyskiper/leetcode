/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (39.53%)
 * Total Accepted:    227.4K
 * Total Submissions: 575.3K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private boolean canSwap(int[] nums, int index, int position) {
        for (int i = index; i < position; i++) {
            if (nums[i] == nums[position]) {
                return false;
            }
        }
        return true;
    }

    void permute(int[] nums, int index, List<List<Integer>> result) {
        if (index >= nums.length - 1) {
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                item.add(nums[i]);
            }
            result.add(item);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!canSwap(nums, index, i)) {
                continue;
            }
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
            permute(nums, index + 1, result);
            tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
    }
}
