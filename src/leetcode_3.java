/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Created by xialingpeng on 2018/9/11.
 */
public class leetcode_3 {

//    Given a string, find the length of the longest substring without repeating characters.

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() <= 0) return 0;
            int[] dp = new int[s.length() + 1];
            int max = 0;
            for (int i = 0; i < s.length() + 1; i++) {
                if (i == 0) {
                    dp[0] = 0;
                } else {
                    dp[i] = findLen(s, i - 1, dp[i - 1]);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        private int findLen(String s, int index, int length) {
            char ch = s.charAt(index);
            for (int i = 1; i <= length; i++) {
                if (s.charAt(index - i) == ch) {
                    return i;
                }
            }
            return length + 1;
        }
    }
}
