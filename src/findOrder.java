import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findOrder.java
 * Time       : Create on 18-9-4
 * Location   : ../Home/JavaForLeeCode2/findOrder.java
 * Function   : LeetCode No.210
 */
public class findOrder {

    private static int[] findOrderResult(int numCourses, int[][] prerequisites) {
        int[] map = new int[numCourses];
        int[] res = new int[numCourses];

        for (int[] prerequisite : prerequisites)
            map[prerequisite[1]]++;

        Queue<Integer> que = new LinkedList<>();
        int index = numCourses - 1;
        for(int i = 0; i < numCourses; i++) {
            if(map[i] == 0) {
                que.add(i);
                res[index--] = i;
            }
        }

        while(!que.isEmpty() ){
            int k = que.remove();
            for (int[] prerequisite : prerequisites) {
                int l = prerequisite[1];
                if (k == prerequisite[0]) {
                    map[l]--;
                    if (map[l] == 0) {
                        que.add(l);
                        res[index--] = l;
                    }
                }
            }
        }
        if(index != -1)
            return new int[0];
        else
            return res;
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
