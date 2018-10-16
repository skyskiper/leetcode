/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * Created by xialingpeng on 2018/9/27.
 */
public class leetcode_123 {

    class Solution {
        public int maxProfit(int[] prices) {
            return maxProfit(prices, 2);
        }

        /**
         * http://www.cnblogs.com/grandyang/p/4281975.html
         * local[i][times] = max(global[i - 1][times - 1] + max(diff, 0), local[i - 1][times] + diff)
         * global[i][times] = max(local[i][times], global[i - 1][times])
         *
         * @param prices
         * @param times
         * @return
         */
        public int maxProfit(int[] prices, int times) {
            if (prices == null || prices.length <= 1 || times <= 0) return 0;
            int[] global = new int[times + 1];
            int[] local = new int[times + 1];
            for (int i = 1; i < prices.length; i++) {
                int diff = prices[i] - prices[i - 1];
                for (int j = times; j >= 1; j--) {
                    local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                    global[j] = Math.max(local[j], global[j]);
                }
            }
            return global[times];
        }
    }
}
