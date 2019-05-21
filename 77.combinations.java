/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (46.44%)
 * Likes:    751
 * Dislikes: 42
 * Total Accepted:    200.1K
 * Total Submissions: 421.9K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of 1 ... n.
 * 
 * Example:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, n, k, 1);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int n, int k, int m) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i=m; i<=n; i++) {
            temp.add(i);
            dfs(res, temp, n, k-1, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
