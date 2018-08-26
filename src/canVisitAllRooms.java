import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : canVisitAllRooms.java
 * Time       : Create on 18-8-26
 * Location   : ../Home/JavaForLeeCode2/canVisitAllRooms.java
 * Function   : LeetCode No.841
 */
public class canVisitAllRooms {

    private static boolean canVisitAllRoomsResult(List<List<Integer>> rooms) {
        boolean[] helper = new boolean[rooms.size()];
        Arrays.fill(helper, false);
        List<Integer> list = rooms.get(0);
        for (Integer i : list)
            dfs(helper, rooms, i);
        for (boolean b : helper) {
            if (!b)
                return false;
        }
        return true;
    }

    private static void dfs(boolean[] helper, List<List<Integer>> rooms, int i) {
        if (!helper[i]) {
            helper[i] = true;
            List<Integer> list = rooms.get(i);
            for (Integer integer : list)
                dfs(helper, rooms, integer);
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        List<Integer> list4 = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(canVisitAllRoomsResult(lists));
    }
}
