 /**
 * Author     : WindAsMe
 * File       : findLength.java
 * Time       : Create on 18-8-15
 * Location   : ../Home/JavaForLeeCode2/findLength.java
 * Function   : LeetCode No.718
 */
public class findLength {

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
        System.out.println(findLengthResult(A,B));
    }
}
