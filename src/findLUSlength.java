/**
 * Author     : WindAsMe
 * File       : findLUSlength.java
 * Time       : Create on 18-9-11
 * Location   : ../Home/JavaForLeeCode2/findLUSlength.java
 * Function   : LeetCode No.521
 */
public class findLUSlength {

    private static int findLUSlengthResult(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        System.out.println(findLUSlengthResult("aba", "cdc"));
    }
}
