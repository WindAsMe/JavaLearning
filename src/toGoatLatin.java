/**
 * Author     : WindAsMe
 * File       : toGoatLatin.java
 * Time       : Create on 18-8-22
 * Location   : ../Home/JavaForLeeCode2/toGoatLatin.java
 * Function   : LeetCode No.824
 */
public class toGoatLatin {

    private static String toGoatLatinResult(String S) {
        S += " ";
        char[] helper = S.toCharArray();
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int flag = 1;
        char reverse = '0';
        boolean init = true;
        boolean needed = false;
        for (char c : helper) {
            if (c == ' ') {
                if (needed) {
                    temp.append(reverse);
                    needed = false;
                }
                temp.append("ma");
                for (int i = 0; i < flag; i++)
                    temp.append("a");
                flag++;
                ans.append(temp).append(" ");
                temp.delete(0, temp.length());
                init = true;
            } else {
                if (init && temp.length() == 0 && c != 'a' && c != 'A' && c != 'e' && c != 'E' && c != 'i' && c != 'I' && c != 'o' && c != 'O' && c != 'u' && c != 'U') {
                    reverse = c;
                    needed = true;
                    init = false;
                } else
                    temp.append(c);
            }
        }
        ans.delete(ans.length() - 1, ans.length());
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatinResult("The quick brown fox jumped over the lazy dog"));
    }
}
