import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : partitionLabels.java
 * Time       : Create on 18-8-18
 * Location   : ../Home/JavaForLeeCode2/partitionLabels.java
 * Function   : LeetCode No.763
 */
public class partitionLabels {

    private static List<Integer> partitionLabelsResult(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        // save the last occurrence
        for(int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] = i;
        int start = -1;
        int end = 0;
        for(int i = 0; i < S.length(); i++) {
            end = Math.max(end, map[S.charAt(i) - 'a']);
            if(end == i) {
                ans.add(end - start);
                start = end;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabelsResult("ababcbacadefegdehijhklij").toString());
    }
}
