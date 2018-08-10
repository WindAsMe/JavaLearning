/**
 * Author     : WindAsMe
 * File       : rotateString.java
 * Time       : Create on 18-8-10
 * Location   : ../Home/JavaForLeeCode2/rotateString.java
 * Function   : LeetCode No.796
 */
public class rotateString {

    private static boolean rotateStringResult(String A, String B) {
        if (A.length() != B.length())
            return false;
        StringBuilder s = new StringBuilder(A);
        // if A.substring(stride, stride + A.length()) == B
        // return true
        int stride = 0;
        int len = A.length();
        while (stride < len) {
            if (s.substring(stride, stride + len).equals(B))
                return true;
            s.append(A.charAt(stride));
            stride++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateStringResult("abcde", "eabcd"));
    }
}
