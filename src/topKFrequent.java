import java.util.*;

/**
 * Author     : WindAsMe
 * File       : topKFrequent.java
 * Time       : Create on 18-9-15
 * Location   : ../Home/JavaForLeeCode2/topKFrequent.java
 * Function   : LeetCode No.692
 */
public class topKFrequent {

    private static List<String> topKFrequentResult(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.merge(word, 1, (a, b) -> a + b);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        List<String> ans = new ArrayList<>();
        list.sort((o1, o2) -> {
            if (o2.getValue() > o1.getValue())
                return 1;
            else if (o2.getValue() < o1.getValue())
                return -1;
            else
                return o1.getKey().compareTo(o2.getKey());
        });
        for (int i = 0; i < k; i++)
            ans.add(list.get(i).getKey());
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequentResult(s, 2));
    }
}
