/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/description/
 * Created by xialingpeng on 2018/8/15.
 */
public class leetcode_91 {

    class Solution {
        public int numDecodings(String s) {
            if (s == null || s.isEmpty()) return 0;

            int[] dp = new int[s.length() + 1];
            for (int i = 0; i <= s.length(); i++) {
                if (!canDecode(s, i - 1)) {
                    return 0;
                }
                if (i == 0 || i == 1) {
                    dp[i] = 1;
                } else if (match(s.charAt(i - 2), s.charAt(i - 1))) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[s.length()];
        }

        //数字0是否能被编码
        private boolean canDecode(String s, int index) {
            if (index < 0) return true;
            if (index == 0) return s.charAt(0) != '0';
            if (s.charAt(index) == '0') {
                return s.charAt(index - 1) == '1' || s.charAt(index - 1) == '2';
            }
            return true;
        }

        private boolean match(char a, char b) {
            //10， 20只有一种组合
            if (a == '1') {
                return b >= '1' && b <= '9';
            }
            if (a == '2') {
                return b >= '1' && b <= '6';
            }
            return false;
        }
    }
}
