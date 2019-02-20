import java.util.ArrayList;
import java.util.List;

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 * Created by xialingpeng on 2018/10/16.
 */
public class leetcode_139 {

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];

            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("cats");
        input.add("dog");
        input.add("sand");
        input.add("and");
        input.add("cat");
        System.out.println(new leetcode_139().new Solution().wordBreak("catsandog", input));
    }
}
