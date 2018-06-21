import java.util.*;

/**
 * Author     : WindAsMe
 * File       : find132pattern.java
 * Time       : Create on 18-6-21
 * Location   : ../Home/JavaForLeeCode2/find132pattern.java
 * Function   :
 */
public class find132pattern {

    private static boolean find132patternResult(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> ranges = new TreeMap<>();
        Set<Integer> keys = new TreeSet<>();
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
            if (ranges.isEmpty()) {
                ranges.put(num, num);
                keys.add(num);
            } else {
                for (int key : keys) {
                    if (key < num) {
                        if (num < ranges.get(key)) {
                            return true;
                        } else {
                            ranges.put(key, num);
                            if (max == num) {
                                ranges.clear();
                                keys.clear();
                                ranges.put(key, num);
                                keys.add(key);
                                break;
                            }
                        }
                    } else if (key > num) {
                        ranges.put(num, num);
                        keys.add(num);
                        break;
                    }
                }
            }
        }
        return false;
    }

    // Brute force: TL
//    private static boolean find132patternResult(int[] nums) {
//        if (nums.length <= 2) {
//            return false;
//        } else {
//            int temp1 = nums[0];
//            int index = 0;
//            while (index <= nums.length - 2) {
//                for (int i = index + 1; i < nums.length; i++) {
//                    if (nums[i] > temp1) {
//                        int temp2 = nums[i];
//                        for (int j = i + 1 ; j < nums.length ; j ++ ) {
//                            if (temp2 > nums[j] && nums[j] > temp1) {
//                                //System.out.println("temp1: " + temp1 + " temp2: " + temp2 + " num[j]: " + nums[j]);
//                                return true;
//                            }
//                        }
//                    }
//                }
//                index ++;
//                temp1 = nums[index];
//            }
//            return false;
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(find132patternResult(nums));
    }
}
