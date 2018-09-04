import java.net.Inet4Address;
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
        if (numCourses == 1)
            return new int[]{0};
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
            dfs(i, numCourses, new ArrayList<>(), ans, helper, prerequisites);
        int zero = 0;
        for (int a : ans) {
            if (a == 0)
                zero++;
        }
        if (zero > 1)
            return new int[0];
        else
            return ans;
    }

    private static void dfs(int start, int numCourses, List<Integer> list, int[] ans,  int[] helper, int[][] prerequisites) {
        int[] copy = helper.clone();
        copy[start] = -1;
        list.add(start);
        // System.out.println("list: " + list.toString() + " copy: " + Arrays.toString(copy));
        if (list.size() > numCourses)
            return;
        if (list.size() == numCourses) {
            for (int i = 0; i < numCourses; i++)
                ans[i] = list.get(i);
        } else {
            for (int[] i : prerequisites) {
                if (i[1] == start)
                    copy[i[0]]--;
            }
            for (int i = 0; i < helper.length; i++) {
                if (copy[i] == 0) {
                    // System.out.println("start: " + i);
                    dfs(i, numCourses, list, ans, copy, prerequisites);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] pre = {
                {1,0}
//                {2,0},
//                {3,1},
//                {3,2}
        };
        System.out.println(Arrays.toString(findOrderResult(5, pre)));
    }
}
