import java.util.Arrays;

/**
 * Author     : WindAsMe
 * File       : countPrimes.java
 * Time       : Create on 18-9-2
 * Location   : ../Home/JavaForLeeCode2/countPrimes.java
 * Function   : LeetCode No.204
 */
public class countPrimes {

    private static int countPrimesResult(int n) {
        boolean[] a = new boolean[n];
        int c = 0;

        for(int i = 2; i * i < n; i++) {
            if(!a[i]) {
                for(int j = i; i * j < n; j++) {
                    a[i * j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        for(int i = 2; i < n; i++) {
            if(!a[i])
                ++c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(countPrimesResult(20));
    }
}
