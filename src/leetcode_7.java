/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 * Created by xialingpeng on 2018/9/26.
 */
public class leetcode_7 {

//    Given a 32-bit signed integer, reverse digits of an integer.

    class Solution {
        public int reverse(int x) {
            boolean isNegative = x < 0;
            if (isNegative) x = -x;
            String reverse = new StringBuffer(String.valueOf(x)).reverse().toString();
            int result = 0;
            try {
                result = new Integer(reverse);
            } catch (Exception ignored) {

            }
            return isNegative ? -result : result;
        }
    }
}
