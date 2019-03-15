package sort;

/**
 * 快排 左边小于等于pivot，右边大于等于pivot
 */
public class QuickSort {

    /**
     * 4，3，2，1 target = 4
     * 1，3，2，4 target = 1
     * 最后划分1与3，2，4
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private static int partition(int[] nums, int start, int end, int target) {
        int tmp = nums[start];
        while (start < end) {
            while (nums[end] >= target && start < end) {
                end--;
            }
            if (start < end) {
                nums[start] = nums[end];
            }
            while (nums[start] <= target && start < end) {
                start++;
            }
            if (start < end) {
                nums[end] = nums[start];
            }
        }
        nums[start] = tmp;

        return nums[start] <= target ? start : start - 1;
    }

    /**
     * 其实这个f分类算法是对的，但是结合快排case，每次划分位置都不曾发生改变，导致栈溢出
     * 4， 3，2，1 target = 4
     * 最后结果依然是4，3，2，1与空组
     * 然后循环进来，位置和target都没有发生变化，造成栈溢出
     */
    private static int partition2(int[] nums, int start, int end, int target) {
        while (start < end) {
            while (nums[end] >= target && start < end) {
                end--;
            }
            while (nums[start] <= target && start < end) {
                start++;
            }
            if (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }

        return nums[start] <= target ? start : start - 1;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (nums == null || left >= right || nums.length <= 1)
            return;
        int mid = partition(nums, left, right, nums[left]);
        quickSort(nums, left, mid);
        quickSort(nums, mid + 1, right);
    }


    public static void main(String[] args) {
        int[] num = new int[]{-1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4, -3};
        quickSort(num, 0, num.length - 1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "    ");
        }

    }
}
