/**
 * Author     : WindAsMe
 * File       : longestPalindrome.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/longestPalindrome.java
 * Function   : LeeCode No.5
 */
public class longestPalindrome {

    private static String longestPalindromeResult(String s) {
        char[] in = s.toCharArray();
        int stringLen = s.length();
        boolean[][] len = new boolean[stringLen][stringLen];
        int start = 0;
        int end = 0;
        for(int i = 0; i < stringLen; i++) {
            for(int j = 0; j < stringLen - i; j++) {
                if(i == 0) {
                    len[j][j] = true;
                } else if(i == 1) {
                    if(in[j] == in[j + 1]) {
                        len[j][j + 1] = true;
                    }
                } else {
                    if(in[j] == in[j + i] && len[j + 1][j + i - 1]) {
                        len[j][j + i] = true;
                    }
                }
                if(len[j][j + i] == true) {
                    start = j;
                    end = j + i;
                }
            }
        }
        return s.substring(start, end + 1);
    }


    public static void main(String[] args){
        System.out.println(longestPalindromeResult("aabavew"));
    }
}
