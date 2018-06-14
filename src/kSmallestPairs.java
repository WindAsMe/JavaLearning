import java.util.*;

/**
 * Author     : WindAsMe
 * File       : kSmallestPairs.java
 * Time       : Create on 18-6-14
 * Location   : ../Home/JavaForLeeCode2/kSmallestPairs.java
 * Function   : LeeCode No.373
 */
public class kSmallestPairs {

    private static List<int[]> kSmallestPairsResult(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<>();
        Queue<int[]> queue = new PriorityQueue<>(k,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                int tmp1 = o1[0]+o1[1];
                int tmp2 = o2[0]+o2[1];

                return tmp1 - tmp2;
            }
        });

        for (int aNums1 : nums1) {
            for (int aNums2 : nums2) {
                queue.add(new int[]{ aNums1, aNums2 });
            }
        }

        while(k --> 0){
            int[] tmp = queue.poll();
            if(tmp == null)
                break;
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        kSmallestPairsResult(nums1, nums2, 1);
    }
}
