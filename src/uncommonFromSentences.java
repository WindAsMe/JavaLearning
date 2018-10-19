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
            if (!bList.contains(s))
                list.add(s);
        }
        for (String s : bList) {
            if (!aList.contains(s))
                list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentencesResult("this apple is sweet", "this apple is sour")));
    }
}
