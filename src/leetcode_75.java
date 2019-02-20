/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 * Created by xialingpeng on 2018/11/2.
 */
public class leetcode_75 {

    class Solution {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length <= 0) return;
            sortColors(nums, 0, nums.length - 1);
        }

        //快排的双抽排序 x<1 1<=x<=1 x>1
        void sortColors(int[] nums, int left, int right) {
            int min = 1;
            int max = 1;
            int i = left, j = left, k = right;
            while (j <= k) {
                if (nums[j] < min) {
                    if (i != j) {
                        swap(nums, i, j);
                    }
                    i++;
                    j++;
                } else if (nums[j] > max) {
                    if (j != k) {
                        swap(nums, j, k);
                    }
                    k--;
                } else {
                    j++;
                }
            }
        }

        void swap(int[] nums, int index1, int index2) {
            int tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new leetcode_75().new Solution();
        int[] arr = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
