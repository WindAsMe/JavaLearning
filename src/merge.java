import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : merge.java
 * Time       : Create on 18-5-30
 * Location   : ../Home/JavaForLeeCode2/merge.java
 * Function   : LeeCode No.88
 */
public class merge {

    // Solution 1: Insert directly and Arrays.sort()
    // Solution 2: Insert and judge, move the position
    private static void mergeResult(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        } else if (nums2.length == 0) {
            return;
        } else {
            int j = 0;
            for (int i = m; i < m + n ; i ++ ){
                nums1[i] = nums2[j];
                j += 1;
            }
            Arrays.sort(nums1);
        }
    }

    public static void main(String[] args){
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        mergeResult(num1, 3, num2, 3);

        for (int i = 0 ; i < 6 ; i ++ ){
            System.out.println(num1[i]);
        }
    }
}
