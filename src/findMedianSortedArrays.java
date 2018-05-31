/**
 * Author     : WindAsMe
 * File       : findMedianSortedArrays.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/findMedianSortedArrays.java
 * Function   : LeeCode No.4
 */
public class findMedianSortedArrays {

    private static double findMedianSortedArraysResult(int[] nums1, int[] nums2) {
        int nums1L = nums1.length;
        int nums2L = nums2.length;
        double result = 0;
        int i = 0, j = 0, k = 0;
        int[] num = new int[nums1L + nums2L];
        while(i < nums1L && j < nums2L){
            if(nums1[i] < nums2[j]) num[k++] = nums1[i++];
            else num[k++] = nums2[j++];
        }
        while(i == nums1L && j < nums2L){
            num[k++] = nums2[j++];
        }
        while(i < nums1L && j == nums2L){
            num[k++] = nums1[i++];
        }
        if(num.length % 2 == 0){
            result = ((double)(num[num.length / 2] + num[num.length / 2 -1]))/2;
        }
        else{
            result = (double)(num[num.length / 2]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(findMedianSortedArraysResult(num1, num2));
    }

}
