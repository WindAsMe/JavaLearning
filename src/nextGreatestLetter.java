import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : nextGreatestLetter.java
 * Time       : Create on 18-8-15
 * Location   : ../Home/JavaForLeeCode2/nextGreatestLetter.java
 * Function   : LeetCode No.744
 */
public class nextGreatestLetter {

    private static char nextGreatestLetterResult(char[] letters, char target) {
        Arrays.sort(letters);
        for (char l : letters) {
            if (l > target)
                return l;
        }
        return letters[0];
    }

    public static void main(String[] args) {
        char[] c = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetterResult(c, 'z'));
    }
}
