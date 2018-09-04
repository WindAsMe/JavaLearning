import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findShortestSubArray.java
 * Time       : Create on 18-8-27
 * Location   : ../Home/JavaForLeeCode2/findShortestSubArray.java
 * Function   : LeetCode No.697
 */
public class findShortestSubArray {

    private static int findShortestSubArrayResult(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = Integer.MAX_VALUE;
        int max;
        for (int i : nums)
            map.merge(i, 1, (a, b) -> a + b);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        // The max occurrence
        max = list.get(list.size() - 1).getValue();
        System.out.println("max: " + max);
        for (int  i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getValue() != max)
                break;
            else {
                int start = 0;
                int end = nums.length - 1;
                int num = list.get(i).getKey();
                while (nums[start] != num)
                    start++;
                while (nums[end] != num)
                    end--;
                len = len > end - start + 1 ? end - start + 1 : len;
            }
        }
        System.out.println(list.toString());
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArrayResult(nums));
    }
}
