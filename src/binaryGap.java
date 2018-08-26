/**
 * Author     : WindAsMe
 * File       : binaryGap.java
 * Time       : Create on 18-8-26
 * Location   : ../Home/JavaForLeeCode2/binaryGap.java
 * Function   : LeetCode No.868
 */
public class binaryGap {

    private static int binaryGapResult(int N) {
        int max = 0;
        int count = 0;
        int bit = N % 2;
        while (N > 0) {
             N = N >> 1;
             int temp = N % 2;
             if (bit == 1 && temp == 1) {
                 max = count > bit ? count : bit;
                 count = 0;
             }
             if (bit == 1 && temp == 0)
                 count++;
             if (bit == 0 && temp == 1)
                 bit = 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(binaryGapResult(5));
    }
}
