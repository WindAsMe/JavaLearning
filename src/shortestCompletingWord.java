import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : shortestCompletingWord.java
 * Time       : Create on 18-9-20
 * Location   : ../Home/JavaForLeeCode2/shortestCompletingWord.java
 * Function   : LeetCode No.784
 */
public class shortestCompletingWord {

    private static String shortestCompletingWordResult(String licensePlate, String[] words) {
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        String temp = licensePlate.toLowerCase();
        char[] cs = temp.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : cs) {
            if (c >= 'a' && c <= 'z')
                builder.append(c);
        }
        System.out.println(builder);
        return null;
    }

    public static void main(String[] args) {
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        shortestCompletingWordResult(licensePlate, words);
    }
}
