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
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        for (int i = 0; i < k; i++)
            ans.add(list.get(i).getKey());
        return ans;
    }

    public static void main(String[] args) {
        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequentResult(s, 2));
    }
}
