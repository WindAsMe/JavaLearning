import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : grayCode.java
 * Time       : Create on 18-8-31
 * Location   : ../Home/JavaForLeeCode2/grayCode.java
 * Function   : LeetCode No.89
 */
public class grayCode {

    // Gray encode:
    // b'0101: the code must be in 4 bit(firstly add 0)
    // if i and i + 1:
    // b'0101: num[0] != num[1], gray[0] = 1
    private static List<Integer> grayCodeResult(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < (1 << n); i++)
            list.add(i ^ (i >> 1));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(grayCodeResult(12).toString());
    }
}
