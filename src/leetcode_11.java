/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 * Created by xialingpeng on 2018/10/16.
 */
public class leetcode_11 {

    class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int l = 0, r = height.length - 1;
            while (l < r) {
                maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
                if (height[l] > height[r]) {
                    r--;
                } else {
                    l++;
                }
            }
            return maxArea;
        }
    }
}
