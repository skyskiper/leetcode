import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * Created by xialingpeng on 2018/9/27.
 */
public class leetcode_84 {

    class Solution {
        public int largestRectangleArea(int[] heights) {
            //stack保存构成递增条形图的index
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                    stack.push(i);
                } else {
                    Integer top = stack.pop();
                    maxArea = Math.max(maxArea, (stack.empty() ? i : i - 1 - stack.peek()) * heights[top]);
                    i--;
                }
            }
            while (!stack.empty()) {
                Integer top = stack.pop();
                maxArea = Math.max(maxArea, (stack.empty() ? heights.length : heights.length - 1 - stack.peek()) * heights[top]);
            }
            return maxArea;
        }
    }
}
