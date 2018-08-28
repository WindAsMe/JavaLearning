import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : replaceWords.java
 * Time       : Create on 18-8-28
 * Location   : ../Home/JavaForLeeCode2/replaceWords.java
 * Function   : LeetCode No.648
 */
public class replaceWords {

    private static String replaceWordsResult(List<String> dict, String sentence) {
        sentence += " ";
        char[] helper = sentence.toCharArray();
        // first: sort the repeated sentence in dict
        for (int i = 0; i < dict.size(); i++) {
            for (int j = i + 1; j < dict.size(); j++) {
                if (sort(dict.get(i), dict.get(j))) {
                    if (dict.get(i).length() >= dict.get(j).length()) {
                        dict.remove(i);
                        i--;
                        j--;
                    } else {
                        dict.remove(j);
                        j--;
                    }
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : helper) {
            if (c >= 97 && c <= 122)
                temp.append(c);
            else {
                ans.append(" ").append(compare(temp.toString(), dict));
                temp.delete(0, temp.length());
            }
        }
        return ans.toString();
    }

    private static boolean sort(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = c1.length > c2.length ? c2.length : c1.length;
        for (int i = 0; i < len; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }

    private static String compare(String s, List<String> dict) {
        String ans = s;
        int len = ans.length();
        for (String d : dict) {
            if (len > d.length() && ans.substring(0, d.length()).equals(d)) {
                ans = d;
                len = ans.length();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("rat");
        dict.add("bat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWordsResult(dict, sentence));
    }
}
