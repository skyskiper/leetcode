/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/description/
 * Created by xialingpeng on 2018/10/16.
 */
public class leetcode_41 {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length < 1) return 1;

            for (int i = 0; i < nums.length; i++) {
                while (nums[i] - 1 < nums.length && nums[i] - 1 >= 0 && nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (i + 1 != nums[i]) {
                    return i + 1;
                }
            }
            return nums.length + 1;
        }

        public void swap(int[] nums, int i1, int i2) {
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }
    }
}
