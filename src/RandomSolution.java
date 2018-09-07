import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : RandomSolution.java
 * Time       : Create on 18-9-7
 * Location   : ../Home/JavaForLeeCode2/RandomSolution.java
 * Function   : LeetCode No.398
 */
public class RandomSolution {

    static class Solution {

        private Map<Integer, List<Integer>> map;

        public Solution(int[] nums) {
            this.map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) == null) {
                    map.put(i, new ArrayList<>(i));
                } else {
                    List<Integer> list = map.get(nums[i]);
                    list.add(i);
                    map.put(nums[i], list);
                }
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get((int) (Math.random() * list.size()));
        }

        public void occur() {
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue().toString());
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3};
        Solution s = new Solution(nums);
        s.occur();
    }

}
