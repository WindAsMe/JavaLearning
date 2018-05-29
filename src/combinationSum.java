import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : combinationSum.java
 * Time       : Create on 18-5-29
 * Location   : ../Home/JavaForLeeCode2/combinationSum.java
 * Function   : LeeCode No.39
 */
public class combinationSum {

    private static List<List<Integer>> combinationSumResult(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0){
            return result;
        } else {
            List<Integer> temp = new ArrayList<>();
            int tempSum = 0;
            addList(result, temp, tempSum, candidates, target);
            System.out.println(result.size());
        }
        return null;
    }

    private static void addList(List<List<Integer>> result, List<Integer> temp, int tempSum, int[] candidates, int target){
        for (int candidate : candidates) {
            if (tempSum + candidate == target) {
                temp.add(candidate);
                result.add(temp);
                temp.remove(temp.size() - 1);
            } else if (tempSum + candidate < target) {
                temp.add(candidate);
                addList(result, temp, tempSum + candidate, candidates, target);
            }

        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> list = combinationSumResult(nums, 4);

    }
}
