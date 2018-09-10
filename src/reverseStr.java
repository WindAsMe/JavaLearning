/**
 * Author     : WindAsMe
 * File       : reverseStr.java
 * Time       : Create on 18-9-10
 * Location   : ../Home/JavaForLeeCode2/reverseStr.java
 * Function   : LeetCode No.541
 */
public class reverseStr {

    private static String reverseStrResult(String s, int k) {
        char[] chs = s.toCharArray();
        int i = 0;
        while(i < chs.length){
            if(i + 2 * k < chs.length){
                reverse(chs, i, i + k - 1);
                i = i + 2 * k;
            } else if(i + k < chs.length) {
                reverse(chs, i, i + k - 1);
                break;
            } else if(i + k >= chs.length) {
                reverse(chs, i, chs.length - 1);
                break;
            }
        }
        StringBuilder str = new StringBuilder();
        for (char ch : chs)
            str.append(ch);
        return str.toString();
    }

    private static void reverse(char[] chs, int i, int j){//反转字符串中下标i到j的子串
        for(int start = i; start < (j + i + 1) / 2; start++)
            swap(chs, start, j - (start - i));
    }
    private static void swap(char[] chs,int i,int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
