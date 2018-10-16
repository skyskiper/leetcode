/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * Created by xialingpeng on 2018/9/27.
 */
public class leetcode_8 {

    class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() <= 0) return 0;
            long result = 0;
            boolean match = false;
            boolean minus = false;
            boolean plus = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == ' ') {
                    if (!match && !minus && !plus) {
                        continue;
                    } else {
                        break;
                    }
                } else if (ch >= '0' && ch <= '9') {
                    if (match) {
                        result = result * 10 + (ch - '0');
                    } else {
                        result += (ch - '0');
                    }
                    match = true;
                    if (result > Integer.MAX_VALUE) {
                        break;
                    }
                } else if (ch == '+') {
                    if (match) break;
                    if (minus || plus) return 0;
                    plus = true;
                } else if (ch == '-') {
                    if (match) break;
                    if (plus || minus) return 0;
                    minus = true;
                } else {
                    if (!match) {
                        return 0;
                    } else {
                        break;
                    }
                }
            }
            if (minus) {
                result = -result;
                if (result < Integer.MIN_VALUE) {
                    result = Integer.MIN_VALUE;
                }
            } else {
                if (result > Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                }
            }
            return (int) result;
        }
    }
}
