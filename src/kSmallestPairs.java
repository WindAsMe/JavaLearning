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


    private static void kSmallestPairsResult1(int[] nums1, int[] nums2, int k){
        List<int[]> list = new ArrayList<>();
        for (int aNums1 : nums1) {
            for (int aNums2 : nums2) {
                int[] temp = new int[2];
                temp[0] = aNums1;
                temp[1] = aNums2;
                list.add(temp);
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int temp = (o1[0] + o1[1]) - (o2[0] + o2[1]);
                if (temp == 0) {
                    return o2[0] - o1[0];
                }
                return temp;
            }
        });

        for (int[] aList : list) {
            System.out.println(Arrays.toString(aList));
        }
    }



    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {1, 2, 3};
        kSmallestPairsResult1(nums1, nums2, 1);
    }
}
