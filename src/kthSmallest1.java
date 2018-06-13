/**
 * Author     : WindAsMe
 * File       : kthSmallest1.java
 * Time       : Create on 18-6-13
 * Location   : ../Home/JavaForLeeCode2/kthSmallest1.java
 * Function   : LeeCode No.378
 */
public class kthSmallest1 {

    // Basic perception:
    // mid = (matrix[0][0] + matrix[end][end]) / 2
    // get each row which below mid
    // If sum > k: R = mid - 1
    // Else: L = mid + 1
    private static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int L = matrix[0][0];
        int R = matrix[n - 1][n - 1];
        int ans = 0;
        while (L <= R){
            int mid = L + (R - L )/2;
            if(guess(matrix, mid, n, k)){
                ans = mid;
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return  ans;
    }


    private static boolean guess(int[][] matrix, int g, int n, int k){
        int sum = 0;
        for(int i = 0; i < n; i++){
            int L = 0;
            int R = n - 1;
            int ans = 0;
            while (L <= R){
                int mid = L + (R - L)/2;
                if(matrix[i][mid] < g){
                    ans = mid + 1;
                    L = mid + 1;
                }else {
                    R = mid - 1;
                }
            }
            sum += ans;
        }
        return k > sum;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,4},{2,4,6},{3,5,8}};

    }
}
