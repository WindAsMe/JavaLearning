import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : combinationSum3.java
 * Time       : Create on 18-6-6
 * Location   : ../Home/JavaForLeeCode2/combinationSum3.java
 * Function   : LeeCode No.216
 */
public class combinationSum3 {

    private static List<List<Integer>> ans = new ArrayList<>();
    private static int[] paths = new int[100];

    private static void robot(int index, int k, int n, int j) {
        if (index >= k) {
            List<Integer> temp = new ArrayList<>();
            int sum = 0;
            for(int i = 0; i < k; i++) {
                sum += paths[i];
                temp.add(paths[i]);
            }
            if (sum == n) {
                ans.add(temp);
            }
            return;
        }
        for(int i = j; i <= 9; i++) {
            paths[index] = i;
            robot(index + 1, k, n, i+1);
        }

    }

    private static List<List<Integer>> combinationSum3Result(int k, int n) {
        ans.clear();
        robot(0, k, n, 1);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3Result(3, 7);
        for (int i = 0 ; i < lists.size() ; i ++ ) {
            for (int j = 0 ; j < 3 ; j ++ ) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
