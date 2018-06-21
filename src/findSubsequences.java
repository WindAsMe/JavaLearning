import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : findSubsequences.java
 * Time       : Create on 18-6-21
 * Location   : ../Home/JavaForLeeCode2/findSubsequences.java
 * Function   :
 */
public class findSubsequences {

    private static List<List<Integer>> findSubsequencesResult(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length <= 1) {
            return lists;
        } else {
            int index = 0;
            while (index < nums.length - 1) {
                List<Integer> list = new ArrayList<>();
                int temp = nums[index];
                int compare = temp;
                list.add(temp);

                for (int i = index + 1; i < nums.length ; i ++ ) {
                    if (nums[i] >= compare) {
                        list.add(nums[i]);
                        compare = nums[i];
                        lists.add(list);
                    }
                }
                index ++;
            }
            return lists;
        }
    }


    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> lists = findSubsequencesResult(nums);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
