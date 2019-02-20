/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 * Created by xialingpeng on 2018/10/16.
 */
public class leetcode_42 {

    class Solution {

        public int trap(int[] height) {
            if (height == null || height.length < 1) return 0;
            int l = 0, r = height.length - 1, sum = 0;
            int lMax = 0, rMax = 0;
            while (l < r) {
                if (height[l] < height[r]) {
                    if (lMax < height[l]) {
                        lMax = height[l];
                    } else {
                        sum += (lMax - height[l]);
                    }
                    l++;
                } else {
                    if (rMax < height[r]) {
                        rMax = height[r];
                    } else {
                        sum += (rMax - height[r]);
                    }
                    r--;
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] input = {5, 2, 1, 2, 1, 5};
        new leetcode_42().new Solution().trap(input);
    }
}
