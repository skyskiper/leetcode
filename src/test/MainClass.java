package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        Arrays.sort(nums);

        long result = Integer.MIN_VALUE + target;
        for (int i = 0; i < nums.length - 2; i++) {
            int tmp = nums[i] + twoSumClosest(nums, i + 1, nums.length - 1, target - nums[i]);
            if (tmp == target) {
                return target;
            }
            if (Math.abs(tmp - target) < Math.abs(result - target)) {
                result = tmp;
            }
        }
        return (int) result;
    }

    public int twoSumClosest(int[] nums, int start, int end, int target) {
        long result = Integer.MIN_VALUE + target;
        while (start < end) {
            int tmp = nums[start] + nums[end];
            if (tmp == target) {
                return target;
            }
            if (Math.abs(tmp - target) < Math.abs(result - target)) {
                result = tmp;
            }
            if (tmp > target) {
                end--;
            } else {
                start++;
            }
        }
        return (int) result;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int ret = new Solution().threeSumClosest(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
