/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (16.11%)
 * Total Accepted:    183.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 2^31 − 1 when the
 * division result overflows.
 * 
 * 
 */
class Solution {

    public static int OVER_FLOW_MAX = 0x7fffffff;
    public static int OVER_FLOW_MIN = 0x80000000;

    public int divide(int dividend, int divisor) {
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long tmpdividend = dividend;
        long tmpdivisor = divisor;
        long newDividend = tmpdividend < 0 ? -tmpdividend : tmpdividend;
        long newDivisor = tmpdivisor < 0 ? -tmpdivisor : tmpdivisor;
        long result = 0;
        while (newDividend >= newDivisor) {
            int factory = 0;
            while (newDividend >= (newDivisor << (factory + 1))) {
                factory++;
            }
            newDividend -= (newDivisor << factory);
            result += (1L << factory);
        }
        result = positive ? result : -result;
        if (result > OVER_FLOW_MAX || result < OVER_FLOW_MIN) {
            return OVER_FLOW_MAX;
        }
        return (int) result;
    }
}