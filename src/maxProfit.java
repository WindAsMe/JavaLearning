/**
 * Author     : WindAsMe
 * File       : maxProfit.java
 * Time       : Create on 18-6-11
 * Location   : ../Home/JavaForLeeCode2/maxProfit.java
 * Function   : LeeCode No.309
 */
public class maxProfit {

    private static int maxProfitResult(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // sdp: no stock or in rest
        // bdp: hold stock
        int[] sdp = new int[prices.length];
        int[] bdp = new int[prices.length];
        sdp[0] = 0;
        bdp[0] = -prices[0];
        for (int i = 1;i < prices.length ;i++ ) {
            sdp[i] = Math.max(sdp[i-1],bdp[i-1] + prices[i]);
            if(i >= 2) {
                bdp[i] = Math.max(bdp[i-1],sdp[i-2] - prices[i]);
            } else {
                bdp[i] = Math.max(bdp[i-1],-prices[i]);
            }
        }
        return sdp[prices.length - 1];
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,0,2};
        System.out.println(maxProfitResult(num));
    }
}
