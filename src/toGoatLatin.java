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
            } else {
                if (temp.length() == 0 && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    reverse = c;
                    needed = true;
                } else
                    temp.append(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatinResult("I speak Goat Latin"));
    }
}
