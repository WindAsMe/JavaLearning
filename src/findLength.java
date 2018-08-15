 /**
 * Author     : WindAsMe
 * File       : findLength.java
 * Time       : Create on 18-8-15
 * Location   : ../Home/JavaForLeeCode2/findLength.java
 * Function   : LeetCode No.718
 */
public class findLength {

     // dp: face the A[i] and B[j]
     // If equal: helper[i][j] = helper[i - 1][j - 1] + 1;
     private static int findLengthResult1(int[] A, int[] B) {
         int[][] helper = new int[A.length][B.length];
         int ans = 0;
         for (int i = 0; i < A.length; i++) {
             for (int j = 0; j < B.length; j++) {
                 if (i > 0 && j > 0 && A[i] == B[j]) {
                     helper[i][j] = helper[i - 1][j - 1] + 1;
                     ans = Math.max(ans, helper[i][j]);
                 } else if (A[i] == B[j]) {
                     helper[i][j] = 1;
                 } else
                     helper[i][j] = 0;
             }
         }
         return ans;
     }

    // TL
    private static int findLengthResult(int[] A, int[] B) {
        int count = 0;
        for (int i = 0 ; i < A.length; i++) {
            int markA = i;
            for (int j = 0; j < B.length; j++) {
                int markB = j;
                if (A[markA] == B[markB]) {
                    while (markA < A.length && markB < B.length && A[markA] == B[markB]) {
                        markA++;
                        markB++;
                    }
                    count = Math.max(count, markA - i);
                    markA = i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(findLengthResult1(A,B));
    }
}
