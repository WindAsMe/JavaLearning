import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : calPoints.java
 * Time       : Create on 18-8-29
 * Location   : ../Home/JavaForLeeCode2/calPoints.java
 * Function   : LeetCode No.682
 */
public class calPoints {

    private static int calPointsResult(String[] ops) {
        int ans = 0;
        List<String> list = new ArrayList<>();
        Collections.addAll(list, ops);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.toString());
            switch (list.get(i)) {
                case "C":
                    // remove number and "C"
                    list.remove(i - 1);
                    list.remove(i - 1);
                    i -= 2;
                    break;
                case "D":
                    list.remove(i);
                    list.add(i, String.valueOf(Integer.valueOf(list.get(i - 1)) * 2));
                    break;
                case "+":
                    list.remove(i);
                    list.add(i, String.valueOf(Integer.valueOf(list.get(i - 1)) + Integer.valueOf(list.get(i - 2))));
                    break;
            }
        }
        for (String s : list)
            ans += Integer.valueOf(s);
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPointsResult(s));
    }
}
