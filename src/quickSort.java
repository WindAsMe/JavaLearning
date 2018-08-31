import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : quickSort.java
 * Time       : Create on 18-8-31
 * Location   : ../Home/JavaForLeeCode2/quickSort.java
 * Function   : Quick Sort
 */
public class quickSort {

    private static int[] qsort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void sort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int i = start;
        int j = end;
        int index = start;
        int value = nums[start];
        while (i < j) {
            // System.out.println("sorted: " + Arrays.toString(nums) + "i: " + i + "j: " + j);
            while (j > i && nums[j] > value)
                j--;
            if (nums[j] < value) {
                nums[i] = nums[j];
                nums[j] = value;
                index = j;
            }
            while (j > i && nums[i] < value)
                i++;
            if (nums[i] > value) {
                nums[j] = nums[i];
                nums[i] = value;
                index = i;
            }
        }
        System.out.println("sorted: " + Arrays.toString(nums));
        sort(nums, start, index);
        sort(nums, index + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,2,9,4,8};
        System.out.println(Arrays.toString(qsort(nums)));
    }
}
