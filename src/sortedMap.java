import java.util.*;

/**
 * Author     : WindAsMe
 * File       : sortedMap.java
 * Time       : Create on 18-8-19
 * Location   : ../Home/JavaForLeeCode2/sortedMap.java
 * Function   : The Utility of SortedMap
 */
public class sortedMap {

    public static void main(String[] args) {
        SortedMap<Character, Integer> map = new TreeMap<>();
        map.put('l', 2);
        map.put('b', 9);
        map.put('c', 12);
        map.put('s', 1);
        map.put('n', 7);
        map.put('p', 2);
        map.put('a', 2);
        // map is sort by the key value
        System.out.println("map value: " + map.values());
        System.out.println("map sort by key iteration: ");
        for (Map.Entry<Character, Integer> m : map.entrySet())
            System.out.println(m.toString());

        SortedMap<Character, Integer> sortedMap = new TreeMap<>();
        sortedMap.put('l', 2);
        sortedMap.put('b', 9);
        sortedMap.put('c', 12);
        sortedMap.put('s', 1);
        sortedMap.put('n', 7);
        sortedMap.put('p', 2);
        sortedMap.put('a', 2);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(sortedMap.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        System.out.println("map sort by value iteration: ");
        for(Map.Entry<Character, Integer> mapping :list)
            System.out.println(mapping.getKey()+":"+mapping.getValue());

    }
}
