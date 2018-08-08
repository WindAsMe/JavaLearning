/**
 * Author     : WindAsMe
 * File       : peakIndexInMountainArray.java
 * Time       : Create on 18-8-8
 * Location   : ../Home/JavaForLeeCode2/peakIndexInMountainArray.java
 * Function   : LeetCode No.852
 */
public class peakIndexInMountainArray {

    private static int peakIndexInMountainArrayResult(int[] A) {
        int start = 0;
        int end = A.length - 1;
        if (A[end] > A[end - 1])
            return end;
        if (A[start] > A[start + 1])
            return start;
        return find(start, end, A);
    }

    private static int find(int start, int end, int[] A) {
        int mid = (start + end) / 2;
        if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
            return mid;
        else {
            if (A[mid] < A[mid - 1])
                return find(start, mid, A);
            else
                return find(mid, end, A);
        }
    }

    public static void main(String[] args) {
        int[] A = {0,2,0};
        System.out.println(peakIndexInMountainArrayResult(A));
    }
}
