/**
 * Created by xialingpeng on 2018/8/9.
 */
public class leetcode_34 {

    public class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[]{-1, -1};
            if (nums == null || nums.length <= 0) return result;

            int index = binarySearch(nums, target);
            if (index == -1) return result;
            result[0] = index;
            result[1] = index;

            for (int i = index; i >= 0; i--) {
                if (target == nums[i]) {
                    result[0] = i;
                }
            }

            for (int i = index; i < nums.length; i++) {
                if (target == nums[i]) {
                    result[1] = i;
                }
            }

            return result;
        }

        private int binarySearch(int[] nums, int target) {
            int begin = 0;
            int end = nums.length - 1;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (target < nums[mid]) {
                    end = mid - 1;
                } else if (target > nums[mid]) {
                    begin = mid + 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1};
        int[] ints = new leetcode_34().new Solution().searchRange(input, 1);
        System.out.print(ints[0] + "   " + ints[1]);
    }
}
