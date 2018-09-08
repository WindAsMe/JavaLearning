import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : findMaximumXOR.java
 * Time       : Create on 18-9-8
 * Location   : ../Home/JavaForLeeCode2/findMaximumXOR.java
 * Function   : LeetCode No.421
 */
public class findMaximumXOR {

    // a ^ b = c -> a ^ c = b, b ^ c = a
    private static int findMaximumXORResult(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums)
                set.add(num & mask);
            int tmp = max | (1 << i);
            // System.out.println(mask+"  "+tmp+"  "+max);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
