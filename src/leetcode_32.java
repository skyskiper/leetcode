import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 * Created by xialingpeng on 2018/8/16.
 */
public class leetcode_32 {

//    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    class Solution {

        public int longestValidParentheses(String s) {
            if (s == null || s.length() <= 0) return 0;
            int[] dp = new int[s.length()];
            int max = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int longestValidParentheses = new leetcode_32().new Solution().longestValidParentheses("(()()");
        System.out.println(longestValidParentheses);
    }
}
