/**
 * Author     : WindAsMe
 * File       : consecutiveNumbersSum.java
 * Time       : Create on 18-8-23
 * Location   : ../Home/JavaForLeeCode2/consecutiveNumbersSum.java
 * Function   : LeetCode No.829
 */
public class consecutiveNumbersSum {

    private static int consecutiveNumbersSumResult(int N) {
        int count = 1;
        for (int i = N - 1; i > 0; i--) {
            int sum = i;
            for (int j = sum - 1; j > 0; j--) {
                sum += j;
                if (sum >= N)
                    break;
            }
            if (sum == N)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSumResult(15));
    }
}
