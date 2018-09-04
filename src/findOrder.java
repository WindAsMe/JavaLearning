import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : findOrder.java
 * Time       : Create on 18-9-4
 * Location   : ../Home/JavaForLeeCode2/findOrder.java
 * Function   : LeetCode No.210
 */
public class findOrder {

    private static int[] findOrderResult(int numCourses, int[][] prerequisites) {
        if (numCourses < 1)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        int[] helper = new int[numCourses];
        for (int[] i : prerequisites)
            helper[i[0]]++;
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] == 0)
                list.add(i);
        }
        int[] ans = new int[numCourses];
        for (Integer i : list)
            dfs(i, ans, new ArrayList<>(), helper, prerequisites);
        return ans;
    }

    private static void dfs(int start, int[] ans, List<Integer> list, int[] helper, int[][] prerequisites) {
        //  System.out.println(list.toString());
        int[] copy = helper.clone();
        list.add(start);
        copy[start] = -1;

        for (int i : ans) {
            if (i != 0)
                return;
        }
        if (list.size() == ans.length) {
            for (int i = 0; i < ans.length; i++)
                ans[i] = list.get(i);
        } else {
            for (int[] i : prerequisites) {
                if (i[1] == start)
                    copy[i[0]]--;
            }
            // System.out.println(Arrays.toString(copy));
            for (int i = 0; i < copy.length; i++) {
                if (copy[i] == 0)
                    dfs(i, ans, list, copy, prerequisites);
            }
        }
    }

    public static void main(String[] args) {
        int[][] pre = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        System.out.println(Arrays.toString(findOrderResult(4, pre)));
    }
}
