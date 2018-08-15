import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : dailyTemperatures.java
 * Time       : Create on 18-8-15
 * Location   : ../Home/JavaForLeeCode2/dailyTemperatures.java
 * Function   : LeetCode No.739
 */
public class dailyTemperatures {

    private static int[] dailyTemperaturesResult(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        // Reverse iteration
        // Save the newest index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            int index = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
                if (temp.getKey() > temperatures[i])
                    index = Math.min(index, temp.getValue());
            }
            ans[i] = index == Integer.MAX_VALUE ? 0 : index - i;
            map.put(temperatures[i], i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperaturesResult(temperatures)));
    }
}
