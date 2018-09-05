import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : containsNearbyDuplicate.java
 * Time       : Create on 18-9-5
 * Location   : ../Home/JavaForLeeCode2/containsNearbyDuplicate.java
 * Function   : LeetCode No.219
 */
public class containsNearbyDuplicate {

    private static boolean containsNearbyDuplicateResult(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        System.out.println(containsNearbyDuplicateResult(nums, 1));
    }
}
