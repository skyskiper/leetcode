import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (53.91%)
 * Total Accepted:    350.9K
 * Total Submissions: 650.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
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
