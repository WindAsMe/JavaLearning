/**
 * Author     : WindAsMe
 * File       : arrangeCoins.java
 * Time       : Create on 18-6-16
 * Location   : ../Home/JavaForLeeCode2/arrangeCoins.java
 * Function   : LeeCode No.441
 */
public class arrangeCoins {

    // Work out in Math
    private static int arrangeCoinsResult1(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }

    private static int arrangeCoinsResult(int n) {
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long x = mid * (mid + 1L) / 2;
            if (x == n)
                return mid;
            else if (x < n)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return end;
    }


    public static void main(String[] args) {
        System.out.println(arrangeCoinsResult(7534523));
    }
}
