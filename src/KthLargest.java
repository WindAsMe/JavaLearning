import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : KthLargest.java
 * Time       : Create on 18-8-12
 * Location   : ../Home/JavaForLeeCode2/KthLargest.java
 * Function   : LeetCode No.703
 */
public class KthLargest {

    private static class Solution {
        private List<Integer> list;
        private int k;

        public Solution(int k, int[] nums) {
            this.k = k;
            list = new ArrayList<>();
            for (int num : nums)
                list.add(num);
            list.sort((o1, o2) -> o2 - o1);
        }

        public int add(int val) {
            System.out.println("list: " + list.toString());
            if (list.size() == 0)
                list.add(val);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < val) {
                    list.add(i, val);
                    break;
                }
            }
            return list.get(k - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {};
        Solution s = new Solution(1, arr);
        System.out.println(s.add(-3));
        System.out.println(s.add(-2));
        System.out.println(s.add(-4));
        System.out.println(s.add(0));
        System.out.println(s.add(4));

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
