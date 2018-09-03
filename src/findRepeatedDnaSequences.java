import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findRepeatedDnaSequences.java
 * Time       : Create on 18-9-3
 * Location   : ../Home/JavaForLeeCode2/findRepeatedDnaSequences.java
 * Function   : LeetCode No.187
 */
public class findRepeatedDnaSequences {

    private static List<String> findRepeatedDnaSequencesResult(String s) {
        if (s.length() < 20)
            return new ArrayList<>();
        char[] helper = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < helper.length - 10; i++) {
            if (valid(i, helper))
                list.add(s.substring(i, i + 10));
        }
        return list;
    }

    private static boolean valid(int start, char[] helper) {
        for (int i = start + 10; i < helper.length; i++) {
            if (equal(start, i, helper))
                return true;
        }
        return false;
    }

    private static boolean equal(int i1, int i2, char[] helper) {
        for (int i = 0; i < 10; i++) {
            if (helper[i1 + i] != helper[i2 + i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequencesResult("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString());
    }
}
