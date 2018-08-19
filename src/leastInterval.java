import java.util.Arrays;
/**
 * Author     : WindAsMe
 * File       : leastInterval.java
 * Time       : Create on 18-8-19
 * Location   : ../Home/JavaForLeeCode2/leastInterval.java
 * Function   : LeetCode No.621
 */
public class leastInterval {

    private static int leastIntervalResult(char[] tasks, int n) {
        int[] c = new int[26];
        int i = 25;
        for(char t : tasks)
            c[t - 'A']++;
        Arrays.sort(c);
        while(i >= 0 && c[i] == c[25])
            i--;
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {
        char[] task = {'B', 'B', 'B', 'A', 'A', 'A'};
        System.out.println(leastIntervalResult(task, 2));
    }
}
