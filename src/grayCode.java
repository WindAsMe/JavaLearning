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
