/**
 * Author     : WindAsMe
 * File       : consecutiveNumbersSum.java
 * Time       : Create on 18-8-23
 * Location   : ../Home/JavaForLeeCode2/consecutiveNumbersSum.java
 * Function   : LeetCode No.829
 */
public class consecutiveNumbersSum {

    private static int consecutiveNumbersSumResult(int N) {
        int result = 0;
        for (int i = 0; i < N; ++i) {
            if (i * (i + 1) / 2 > N)
                break;
            int as = N - (i + 1) * i / 2;
            if (as % (i + 1) != 0)
                continue;
            if (as / (i + 1) > 0)
                ++result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSumResult(68188380));
    }
}
