import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : uncommonFromSentences.java
 * Time       : Create on 18-10-19
 * Location   : ../Home/JavaForLeeCode2/uncommonFromSentences.java
 * Function   : LeetCode No.884
 */
public class uncommonFromSentences {

    private static String[] uncommonFromSentencesResult(String A, String B) {
        List<String> list = new ArrayList<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        List<String> aList = Arrays.asList(a);
        List<String> bList = Arrays.asList(b);

        for (String s : aList) {
            if (!bList.contains(s) && getTimes(s, aList))
                list.add(s);
        }
        for (String s : bList) {
            if (!aList.contains(s) && getTimes(s, bList))
                list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }

    private static boolean getTimes(String s, List<String> list) {
        int count = 0;
        for (String s1 : list) {
            if (s.equals(s1))
                count++;
        }
        return count < 2;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentencesResult("this apple is sweet", "this apple is sour")));
    }
}
