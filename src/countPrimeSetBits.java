/**
 * Author     : WindAsMe
 * File       : countPrimeSetBits.java
 * Time       : Create on 18-8-18
 * Location   : ../Home/JavaForLeeCode2/countPrimeSetBits.java
 * Function   : LeetCode No.762
 */
public class countPrimeSetBits {

    public static int countPrimeSetBitsResult(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R; i++) {
            if (isValid(i))
                ans++;
        }
        return ans;
    }

    private static boolean isValid(int i) {
        int ans = 0;
        while (i > 0) {
            ans += i % 2;
            i = i >> 1;
        }
        System.out.println(ans);
        // ans max is 20
        return ans == 2 || ans == 3 || ans == 5 || ans == 7 || ans == 11 || ans == 13 || ans == 17 || ans == 19;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBitsResult(10, 15));
    }
}
