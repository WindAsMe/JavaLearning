/**
 * Author     : WindAsMe
 * File       : maxProfit1.java
 * Time       : Create on 18-6-11
 * Location   : ../Home/JavaForLeeCode2/maxProfit1.java
 * Function   : LeeCode No.121
 */
public class maxProfit1 {

    private static int maxProfitResult(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        } else {
            int sum = 0;
            for (int i = 0 ; i < prices.length ; i ++ ) {
                // System.out.println("restMax: " + restMax(i, prices) );
                sum = Math.max(sum, restMax(i, prices) - prices[i]);
            }
            return sum;
        }

    }

    private static int restMax(int index, int[] prices) {
        int biggest = prices[index];
        for (int i = index ; i < prices.length ; i ++ ) {
            if (biggest < prices[i]) {
                biggest = prices[i];
            }
        }
        return biggest;
    }


    public static void main(String[] args) {
        int[] nums = {7,6,5,4,3,5,1};
        System.out.println(maxProfitResult(nums));
    }
}
