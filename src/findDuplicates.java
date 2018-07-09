import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : findDuplicates.java
 * Time       : Create on 18-6-20
 * Location   : ../Home/JavaForLeeCode2/findDuplicates.java
 * Function   : LeeCode No.442
 */
public class findDuplicates {

    // Ordinary function:
    // After sort, comparing
//    private static List<Integer> findDuplicatesResult(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//        Arrays.sort(nums);
//        for (int i = 0 ; i < nums.length - 1 ; i ++) {
//            if (nums[i] == nums[i + 1]) {
//                list.add(nums[i]);
//            }
//        }
//        return list;
//    }


    // Profound function
    private static List<Integer> findDuplicatesResult(int[] nums) {
        int[] arr = new int[nums.length + 1];

        // Mark the occurrence times
        for (int i : nums) {
            arr[i]++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // If occurrence is 2, add to list
            if(arr[i] > 1){
                list.add(i);
            }

        }

        return list;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = findDuplicatesResult(nums);
        assert list != null;
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
