package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] <= target) {
            while (nums[left] >= nums[right]) {
                right--;
            }
            return binarySearch(nums, left, right, target);
        } else if (nums[right] >= target) {
            while (nums[left] >= nums[right]) {
                left++;
            }
            return binarySearch(nums, left, right, target);
        } else {
            return -1;
        }
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right || nums[left] > target || nums[right] < target)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        }
        return binarySearch(nums, left, mid - 1, target);
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
        for(int index = 0; index < parts.length; index++) {
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

            int ret = new Solution().search(nums, target);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}