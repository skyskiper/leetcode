/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Created by xialingpeng on 2018/9/27.
 */
public class leetcode_121 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 0) return 0;
            int maxProfit = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else if (prices[i] - min > maxProfit) {
                    maxProfit = prices[i] - min;
                }
            }
            return maxProfit;
        }
    }
}
