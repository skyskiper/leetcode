import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 *
 * https://leetcode.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (30.02%)
 * Total Accepted:    187.4K
 * Total Submissions: 622.9K
 * Testcase Example:  '"2"\n"3"'
 *
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Example 1:
 * 
 * 
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * 
 * Example 2:
 * 
 * 
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * 
 * 
 * Note:
 * 
 * 
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0
 * itself.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * 
 * 
 */
class Solution {

    private Map<String, String> cache = new HashMap<>();

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0') return "0";
        if (num2.length() == 1 && num2.charAt(0) == '0') return "0";
        int length = Math.min(num1.length(), num2.length());
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        String result = "0";
        for (int i = length - 1; i >= 0; i--) {
            int count = num2.charAt(i) - '0';
            if (count == 0)
                continue;
            String tmp = num1;
            for (int j = 1; j < count; j++) {
                tmp = add(num1, tmp);
            }
            String flag = "";
            for (int j = 0; j < length - 1 - i; j++) {
                flag = flag + "0";
            }
            if (flag != "") {
                tmp = tmp + flag;
            }
            result = add(result, tmp);
        }
        return result;
    }

    public String add(String num1, String num2) {
        if (cache.containsKey(num1 + num2)) {
            return cache.get(num1 + num2);
        }
        if (cache.containsKey(num2 + num1)) {
            return cache.get(num2 + num1);
        }
        int length = Math.max(num1.length(), num2.length());
        StringBuilder result = new StringBuilder();
        char carry = '0';
        for (int i = 0; i <= length; i++) {
            char char1 = '0', char2 = '0';
            if (num1.length() > i) {
                char1 = num1.charAt(num1.length() - 1 - i);
            }
            if (num2.length() > i) {
                char2 = num2.charAt(num2.length() - 1 - i);
            }
            carry = add(char1, char2, carry, result);
        }
        int zero = 0;
        while (result.charAt(zero) == '0') {
            zero++;
        }
        String str = result.substring(zero);
        cache.put(num1 + num2, str);
        return str;
    }

    public char add(char num1, char num2, char carry, StringBuilder builder) {
        int result = num1 + num2 + carry - '0' - '0' - '0';
        if (result > 9) {
            builder.insert(0, result - 10);
            return '1';
        }
        builder.insert(0, result);
        return '0';
    }
}