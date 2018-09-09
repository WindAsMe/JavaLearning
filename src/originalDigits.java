import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : originalDigits.java
 * Time       : Create on 18-9-9
 * Location   : ../Home/JavaForLeeCode2/originalDigits.java
 * Function   : LeetCode No.423
 */
public class originalDigits {

    private static String originalDigitsResult(String s) {
        char[] helper = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int[] nums = new int[10];
        StringBuilder sb = new StringBuilder();
        for (char c : helper)
            map.merge(c, 1, (a, b) -> a + b);
        if (map.get('g') != null)
            nums[8] = map.get('g');
        if (map.get('x') != null)
            nums[6] = map.get('x');
        if (map.get('u') != null)
            nums[4] = map.get('u');
        if (map.get('w') != null)
            nums[2] = map.get('w');
        if (map.get('z') != null)
            nums[0] = map.get('z');
        if (map.get('f') != null)
            nums[5] = map.get('f') - nums[4] ;
        if (map.get('h') != null)
            nums[3] = map.get('h') - nums[8] ;
        if (map.get('s') != null)
            nums[7] = map.get('s') - nums[6] ;
        if (map.get('o') != null)
            nums[1] = map.get('o') - nums[0] - nums[2] - nums[4] ;
        if (map.get('i') != null)
            nums[9] = map.get('i') - nums[5] - nums[6] - nums[8] ;
        for ( int i = 0 ; i < 10 ; i ++ ) {
            while (nums[i] > 0 ) {
                sb.append(String.valueOf(i));
                nums[i]--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigitsResult("owoztneoer"));
    }
}
