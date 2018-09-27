import java.util.Stack;

/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/description/
 * Created by xialingpeng on 2018/9/26.
 */
public class leetcode_85 {

    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) return 0;
            int[] heights = new int[matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        heights[j]++;
                    } else {
                        heights[j] = 0;
                    }
                }
                max = Math.max(largestRectangleArea(heights), max);
            }
            return max;
        }

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
