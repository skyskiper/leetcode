import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/description/
 * Created by xialingpeng on 2018/10/16.
 */
public class leetcode_18 {

    class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4)
                return result;

            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                threeSum(nums, target, i + 1, nums[i]);
            }

            return result;
        }

        public void threeSum(int[] nums, int target, int beginIndex, int exclude1) {
            for (int i = beginIndex; i < nums.length - 2; i++) {
                if (i > beginIndex && nums[i] == nums[i - 1])
                    continue;
                twoSum(nums, target, i + 1, nums.length - 1, exclude1, nums[i]);
            }
        }

        public void twoSum(int[] nums, int target, int begin, int end, int exclude1, int exclude2) {
            while (begin < end) {
                if (exclude1 + exclude2 + nums[begin] + nums[end] == target) {
                    List<Integer> list = new ArrayList();
                    list.add(exclude1);
                    list.add(exclude2);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    result.add(list);
                    while (begin < end && nums[begin] == nums[begin + 1])
                        begin++;
                    while (begin < end && nums[end] == nums[end - 1])
                        end--;
                    begin++;
                    end--;
                } else if (exclude1 + exclude2 + nums[begin] + nums[end] < target)
                    begin++;
                else
                    end--;
            }
        }
    }
}
