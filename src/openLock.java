import java.util.Arrays;

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
        StringBuilder sb = new StringBuilder("0000");
        for (int i = 0; i < 4; i++) {
            int a = sb.charAt(i) - '0';
            sb.replace(i, i + 1, String.valueOf(a + 1));
            bfs(sb, target, deadends, 1);
            sb.replace(i, i + 1, String.valueOf(a - 1));
            bfs(sb, target, deadends,1);
        }
        return ans;
    }

    private static void bfs(StringBuilder sb, String target, String[] deadends, int times) {
        if (sb.toString().equals(target))
            ans = Math.min(ans, times);
        else if (isContain(deadends, sb.toString())) {
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int a = sb.charAt(i) - '0';
                sb.replace(i, i + 1, String.valueOf(a + 1));
                bfs(sb, target, deadends, 1);
                sb.replace(i, i + 1, String.valueOf(a - 1));
                bfs(sb, target, deadends, 1);
            }
        }
    }

    private static boolean isContain(String[] deadends, String sb) {
        for (String s : deadends) {
            if (s.equals(sb))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLockResult(deadends, target));
    }
}

