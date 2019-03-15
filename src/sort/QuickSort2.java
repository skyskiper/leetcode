package sort;

/**
 * 快排 左边小于等于pivot，右边大于pivot
 */
public class QuickSort2 {

    private static int partition(int[] nums, int start, int end, int target) {
        while (start < end) {
            while (nums[start] <= target) {
                start++;
                if (start >= end) {
                    return start;
                }
            }
            while (nums[end] > target) {
                end--;
                if (start >= end) {
                    return start;
                }
            }
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }

        return start;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int tmp = arr[left];
        int mid = partition(arr, left, right, arr[left]);
        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + "    ");
            if (mid != right && i == mid - 1) {
                System.out.print("   split   ");
            }
        }
        System.out.println("mid-" + mid + "target-" + tmp);
        if (mid == right) {
            if (arr[left] > arr[right]) {
                int tmp1 = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp1;
            }
            quickSort(arr, left, right - 1);
        } else {
            quickSort(arr, left, mid - 1);
            quickSort(arr, mid, right);
        }
    }


    public static void main(String[] args) {
        int[] num = new int[]{-1, -2, -3, 4, 1, 3, 0, 3, -2, 1, -2, 2, -1, 1, -5, 4, -3};
        quickSort(num, 0, num.length - 1);
        System.out.println("-------");
        System.out.println("result");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "    ");
        }

    }
}
