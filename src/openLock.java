import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : openLock.java
 * Time       : Create on 18-8-18
 * Location   : ../Home/JavaForLeeCode2/openLock.java
 * Function   : LeetCode  No.752
 */
public class openLock {

    private static int ans = Integer.MAX_VALUE;

    private static int openLockResult(String[] deadends, String target) {
        if ("0000".equals(target))
            return 0;
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Set<String> save = new HashSet<>();
        save.add("0000");
        StringBuilder sb = new StringBuilder("0000");
        for (int i = 0; i < 4; i++) {
            int a = sb.charAt(i) - '0';
            sb.replace(i, i + 1, String.valueOf((a + 1) % 10));
            bfs(save, set, sb, target, 1);
        }
        return ans;
    }

    private static void bfs(Set<String> save, Set<String> set, StringBuilder sb, String target, int time) {
        if (target.equals(sb.toString()))
            ans = Math.min(ans, time);
        else if (!save.contains(sb.toString()) && !set.contains(sb.toString())) {
            save.add(sb.toString());
            for (int i = 0; i < 4; i++) {
                int a = sb.charAt(i) - '0';
                sb.replace(i, i + 1, String.valueOf((a + 1) % 10));
                bfs(save, set, sb, target, time + 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLockResult(deadends, target));
    }
}

