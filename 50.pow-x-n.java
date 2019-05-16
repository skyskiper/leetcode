/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1d;
        if (n == 1)
            return x;
        int half = n / 2;
        if (n < 0) {
            half = -half;
            x = 1 / x;
        }
        double halfResult = myPow(x, half);
        if (n % 2 == 0) {
            return halfResult * halfResult;
        } else {
            return halfResult * halfResult * x;
        }
    }
}
