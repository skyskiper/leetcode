/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/description/
 * Created by xialingpeng on 2018/9/5.
 */
public class leetcode_72 {

//    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//    You have the following 3 operations permitted on a word:
//
//    Insert a character
//    Delete a character
//    Replace a character

    class Solution {
        public int minDistance(String word1, String word2) {
            if (word1 == null || word1.length() <= 0) return word2 != null ? word2.length() : 0;
            if (word2 == null || word2.length() <= 0) return word1.length();

            int[][] dp = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < word1.length() + 1; i++) {
                for (int j = 0; j < word2.length() + 1; j++) {
                    if (i == 0) {
                        dp[0][j] = j;
                    } else if (j == 0) {
                        dp[i][0] = i;
                    } else {
                        //删除操作
                        int delete = dp[i - 1][j] + 1;
                        //插入操作
                        int insert = dp[i][j - 1] + 1;
                        //替换操作
                        int replace = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                        dp[i][j] = Math.min(Math.min(delete, insert), replace);
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}
