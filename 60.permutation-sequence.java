import java.util.List;

/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 *
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (32.52%)
 * Likes:    801
 * Dislikes: 217
 * Total Accepted:    136.5K
 * Total Submissions: 414.2K
 * Testcase Example:  '3\n3'
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * Given n and k, return the k^th permutation sequence.
 * 
 * Note:
 * 
 * 
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 4, k = 9
 * Output: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        // 求出1到n-1的阶乘
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int currentIndex = k / factorial[n - 1 - i];
            result.append(nums.get(currentIndex));
            nums.remove(currentIndex);
            k = k % factorial[n - 1 - i];
        }

        return result.toString();
    }
}
