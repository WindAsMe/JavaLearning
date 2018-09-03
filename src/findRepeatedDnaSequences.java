import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findRepeatedDnaSequences.java
 * Time       : Create on 18-9-3
 * Location   : ../Home/JavaForLeeCode2/findRepeatedDnaSequences.java
 * Function   : LeetCode No.187
 */
public class findRepeatedDnaSequences {

    private static List<String> findRepeatedDnaSequencesResult1(String s) {
        List<String> ans = new ArrayList<>();
        if(s == null || s.length() < 11)
            return ans;

        int hash = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> set = new HashSet<>();
        Set<Integer> unique = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(i < 9) {
                hash = (hash << 2) + map.get(c);
            } else {
                hash = (hash << 2) + map.get(c);
                hash &= (1 << 20) - 1;
                if(set.contains(hash) && !unique.contains(hash)) {
                    ans.add(s.substring(i-9, i+1));
                    unique.add(hash);
                } else
                    set.add(hash);
            }
        }
        return ans;
    }


    // TL
    private static List<String> findRepeatedDnaSequencesResult(String s) {
        if (s.length() < 20)
            return new ArrayList<>();
        char[] helper = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < helper.length - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (valid(i, helper) && !list.contains(temp))
                list.add(temp);
        }
        return list;
    }

    private static boolean valid(int start, char[] helper) {
        for (int i = start + 10; i < helper.length - 10; i++) {
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
        System.out.println(findRepeatedDnaSequencesResult("AAGATCCGTCCCCCCAAGATCCGTC").toString());
    }
}
