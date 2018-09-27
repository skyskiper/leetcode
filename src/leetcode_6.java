/**
 * 6. ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 * Created by xialingpeng on 2018/9/26.
 */
public class leetcode_6 {

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows <= 1) return s;
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < numRows; i++) {
                int j = 0;
                while (i + j < s.length()) {
                    result.append(s.charAt(i + j));

                    if (i != 0 && i != numRows - 1 && i + j + (numRows - 1 - i) * 2 < s.length()) {
                        result.append(s.charAt(i + j + (numRows - 1 - i) * 2));
                    }
                    j += numRows * 2 - 2;
                }
            }
            return result.toString();
        }
    }
}
