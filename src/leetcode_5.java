/**
 * Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Created by xialingpeng on 2018/8/10.
 */
public class leetcode_5 {

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";

            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
                if (i < s.length() - 1) {
                    dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                }
            }

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (!dp[i][j]) {
                        dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    }
                }
            }

            int start = 0, end = 1;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (dp[i][j] && j - i + 1 > end - start) {
                        start = i;
                        end = j + 1;
                    }
                }
            }
            return s.substring(start, end);
        }
    }

    public static void main(String[] args) {
        String str = new leetcode_5().new Solution().longestPalindrome("abcba");
        System.out.print(str);
    }
}
