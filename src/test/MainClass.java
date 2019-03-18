package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int changePos = nums.length - 1;
        while (changePos > 0 && nums[changePos] <= nums[changePos - 1]) {
            changePos--;
        }
        if (nums[changePos - 1] >= nums[changePos]) {
            // 依次递减，此时需要全部倒序
            revert(nums, 0, nums.length - 1);
        } else {
            // changPos（包括changePos）后面的递减，此时从中找出最小的大于changePos-1的数置换
            int changePos2 = nums.length - 1;
            while (nums[changePos - 1] >= nums[changePos2]) {
                changePos2--;
            }

            int tmp = nums[changePos - 1];
            nums[changePos - 1] = nums[changePos2];
            nums[changePos2] = tmp;

            revert(nums, changePos, nums.length - 1);
        }

    }

    private void revert(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            new Solution().nextPermutation(nums);
            String out = integerArrayToString(nums);

            System.out.print(out);
        }
    }
}