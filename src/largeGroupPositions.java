import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : largeGroupPositions.java
 * Time       : Create on 18-8-24
 * Location   : ../Home/JavaForLeeCode2/largeGroupPositions.java
 * Function   : LeetCode No.830
 */
public class largeGroupPositions {

    private static List<List<Integer>> largeGroupPositionsResult(String S) {
        List<List<Integer>> lists = new ArrayList<>();
        char[] s = S.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 1; i < s.length; i++) {
            // System.out.println("start: " + start + " end: " + end);
            if (s[i] == s[i - 1])
                end++;
            else {
                if (end - start >= 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    lists.add(list);
                }
                start = i;
                end = i;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> lists = largeGroupPositionsResult(s);
        for (List<Integer> list : lists)
            System.out.println(list.toString());
    }
}
