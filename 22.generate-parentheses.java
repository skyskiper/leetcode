import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (53.33%)
 * Total Accepted:    307.5K
 * Total Submissions: 575.4K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, "");
        return result;
    }

    public void generateParenthesis(int open, int close, String current) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        if (open > 0) {
            generateParenthesis(open - 1, close, current + "(");
        }
        if (close > 0 && close > open) {
            generateParenthesis(open, close - 1, current + ")");
        }
    }
}
