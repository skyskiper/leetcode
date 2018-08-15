/**
 * 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/description/
 * Created by xialingpeng on 2018/8/14.
 */
public class leetcode_10 {

    /**
     * 这个算法不支持"aa", "a**"的匹配的，
     * 如果**等重复的相当于一个*，可以考虑在match前就将数据进行转换
     */
    class Solution {
        public boolean isMatch(String text, String pattern) {
            boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];

            //注意 dp[text.length()][x]的初始化不是简单的设为true或者false,
            //因为pattern中的a*也相当于空
            dp[text.length()][pattern.length()] = true;
            for (int i = text.length(); i >= 0; i--) {
                for (int j = pattern.length() - 1; j >= 0; j--) {
                    boolean equals = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
                    if (j < pattern.length() - 1 && pattern.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || (equals && dp[i + 1][j]);
                    } else {
                        dp[i][j] = equals && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }
    }

    public static void main(String[] args) {
        boolean aa = new leetcode_10().new Solution().isMatch("aa", "a**");
        System.out.println(aa);
    }
}
