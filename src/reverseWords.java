/**
 * Author     : WindAsMe
 * File       : reverseWords.java
 * Time       : Create on 18-6-2
 * Location   : ../Home/JavaForLeeCode2/reverseWords.java
 * Function   : LeeCode No.151
 */
public class reverseWords {

    private static String reverseWordsResult(String s) {
        StringBuilder temp = new StringBuilder(s.trim());
        StringBuilder result = new StringBuilder();
        temp.reverse();

        StringBuilder word = new StringBuilder();
        for (int i = 0 ; i < temp.length() ; i ++ ) {
            if (temp.charAt(i) != ' ') {
                word.append(temp.charAt(i));
            } else {
                word.reverse();
                result.append(word).append(" ");
                word = new StringBuilder();
                while (temp.charAt(i + 1) == ' ') {
                    i ++;
                }
            }
        }
        word.reverse();
        result.append(word);
        return result.toString();
    }

    public static void main(String[] args){
        String s = reverseWordsResult(" hello    world    my love   ");
        System.out.println(s);
    }
}
