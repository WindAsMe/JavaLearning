import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : lexicalOrder.java
 * Time       : Create on 18-9-8
 * Location   : ../Home/JavaForLeeCode2/lexicalOrder.java
 * Function   : LeetCode No.386
 */
public class lexicalOrder {

    private static List<Integer> lexicalOrderResult(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            res.add(cur);
            if (cur * 10 <= n)
                cur = cur * 10;
            else if (cur % 10 != 9 && cur + 1 <= n)
                cur++;
            else {
                while ((cur / 10) % 10 == 9)
                    cur = cur / 10;
                cur = cur / 10 + 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lexicalOrderResult(13).toString());
    }
}
