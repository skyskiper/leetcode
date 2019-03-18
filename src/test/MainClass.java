package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int dividend = Integer.parseInt(line);
            line = in.readLine();
            int divisor = Integer.parseInt(line);

            int ret = new Solution().divide(dividend, divisor);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}