import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : deleteAndEarn.java
 * Time       : Create on 18-8-17
 * Location   : ../Home/JavaForLeeCode2/deleteAndEarn.java
 * Function   : LeetCode No.704
 */
public class deleteAndEarn {

    private static int deleteAndEarnResult(int[] nums) {
        if (nums.length < 1)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[add(map, nums)+ 1];
        // for (Map.Entry<Integer, Integer> m : map.entrySet())
        //     System.out.println(m.toString());

        ans[1] = map.get(1) == null ? 0 : map.get(1);
        for (int i = 2; i < ans.length; i++)
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + (map.get(i) == null ? 0 : map.get(i)));
        // System.out.println(Arrays.toString(ans));
        return ans[ans.length - 1];
    }

    private static int add(Map<Integer, Integer> map, int[] nums) {
        int flag = 0;
        for (int i : nums) {
            flag = i > flag ? i : flag;
            map.merge(i, i, (a, b) -> map.get(b) + b);
        }
        return flag;
    }


    public static void main(String[] args) {
        int[] ans = {3};
        System.out.println(deleteAndEarnResult(ans));
    }
}
