import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : findSubsequences.java
 * Time       : Create on 18-6-21
 * Location   : ../Home/JavaForLeeCode2/findSubsequences.java
 * Function   : LeeCode No.491
 */
public class findSubsequences {

    private static List<List<Integer>> findSubsequencesResult(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return new ArrayList<List<Integer>>(res);
    }

    // DFS
    private static void helper(Set<List<Integer>> res, List<Integer> subList, int[] nums, int start) {
        if (subList.size() >= 2) {
            res.add(new ArrayList<Integer>(subList));
        }
        for (int i = start; i < nums.length; i++) {
            if (subList.size() == 0 || subList.get(subList.size() - 1) <= nums[i]) {
                subList.add(nums[i]);
                helper(res, subList, nums, i + 1);
                // If nums[] = {4, 6, 7, 7}
                // Then the {4, 7, 7} is a kind of answer
                subList.remove(subList.size() - 1);
            }
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
