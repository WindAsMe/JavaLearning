import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : replaceWords.java
 * Time       : Create on 18-8-28
 * Location   : ../Home/JavaForLeeCode2/replaceWords.java
 * Function   : LeetCode No.648
 */
public class replaceWords {

    private static String replaceWordsResult1(List<String> dict, String sentence) {
        StringBuilder result= new StringBuilder();
        HashSet<String> set = new HashSet<>(dict);
        String[] words=sentence.split(" ");
        for (String word1 : words) {
            String word = word1;
            for (int j = 1; j <= word.length() && j < 101; j++) {
                String subWord = word.substring(0, j);
                if (set.contains(subWord)) {
                    word = subWord;
                    break;
                }
            }
            result.append(word).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

    private static String replaceWordsResult(List<String> dict, String sentence) {
        sentence += " ";
        char[] helper = sentence.toCharArray();
        int dic = dict.size();
        // first: sort the repeated sentence in dict
        for (int i = 0; i < dic; i++) {
            for (int j = i + 1; j < dic; j++) {
                if (sort(dict.get(i), dict.get(j))) {
                    if (dict.get(i).length() >= dict.get(j).length()) {
                        dict.remove(i);
                        dic--;
                        i--;
                        j--;
                    } else {
                        dict.remove(j);
                        j--;
                        dic--;
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
                ans.append(compare(temp.toString(), dict)).append(" ");
                temp.delete(0, temp.length());
            }
        }
        ans.delete(ans.length() - 1, ans.length());
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
        dict.add("gymth");
        dict.add("qglnp");
        dict.add("hmgs");
        dict.add("rsz");
        dict.add("upq");
        dict.add("aq");
        dict.add("relo");
        dict.add("hz");
        dict.add("i");
        String sentence = "snhaafs hprzyepsgezd ntc ktogne kluwleaobb nwjatqwpx tzobvpylft s jzrlxuzsw fkkjvorqnhpeoikjepmm rxerxpfjssfvtzvunri rpnaizunsjlppuzppf udoqhtcpcv rtegaohvotz eovfuvymmzywjoytegf cztodouflfgc qtom vlyyboks izzhgin rtnrxmm ovtgafmvzu xxeabovlxmy zrqzsexkerfjiqkyjou ygelavmpdncapreadba y kedhgamqyjaffbex fosrpjojgwzjfaoxn pjqysu esaaoksfsvjabdbk e sknkvxxngqpfdkm dmqfzqjuunrbdmkjp fesdkqewhigg anlrixkeqaexh yhmywgpebtsprje tmwbuqnffycjm otfnqgtetdi ovyrmzo vkeze opq rijfryopiizsitum jyz ynoworq xmqohxpgce eblgjvghxxndaqvknph ghhxzfda onukxgjtdrjmoddqhfl xwmutmcvrzkjzxmtz xslacnagnrlu nidcqwrffyrlosnjjl stwperkfcvyzezbebktq fjhb hhxeturoihcdgkkq evzcmxhrnwvnpbbfsm cshlxs qouyuxwdjwyhfp ceiddqqfp pzbsuxqc qgrbisfcnyhdwmbkdjh cxlxqwi z ihgekczvavdwvivvj fjttwiqxqjgakd diggghnustrtizokcrw earkadvle eufogeidbfrcz cnms gomw rbraz bsbopklfbnbbzcod zbayalermeyxn ckrfpylus ofmpofltxmsideqxx rmkqaxda map gvpqwuofuwue o mkzz njrqnwlihegmpmr dbbpwy t c apljlybekb avgxnubzswldzyln tkxwrskwqkzdueuautg cekskcpocbubavun jezsixdu yepzrfdrhqajotjohmzo fleesmkehkvoj ciloebxldjgwtf ruzc tshzh cgudcyfzppgduvfha grcrveutgkz cfsrzt";


        System.out.println(replaceWordsResult(dict, sentence));
    }
}
