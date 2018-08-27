import java.util.HashMap;
import java.util.Map;

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
        int num = 0;
        int max = 0;
        int start = 0;
        int end = nums.length - 1;
        for (int i : nums)
            map.merge(i, 1, (a, b) -> a + b);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                num = entry.getKey();
            }
        }
        while (nums[start] != num)
            start++;
        while (nums[end] != num)
            end--;
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArrayResult(nums));
    }
}
