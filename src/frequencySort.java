import java.util.*;

/**
 * Author     : WindAsMe
 * File       : frequencySort.java
 * Time       : Create on 18-6-15
 * Location   : ../Home/JavaForLeeCode2/frequencySort.java
 * Function   : LeeCode No.451
 */
public class frequencySort {

    // Using Map is more efficient comparing with List

    // First thought is sorted by Map
    // But map has no obvious sort function
//    private static String frequencySortResult(String s) {
//        // USING TreeMap to save the frequency
//        Map<Character, Integer> map = new TreeMap<>();
//        for (int i = 0 ; i < s.length() ; i ++ ) {
//            char temp = s.charAt(i);
//            Integer value = map.get(temp);
//            if ( value == null) {
//                map.put(temp, 1);
//            } else {
//                value += 1;
//                map.put(temp, value);
//            }
//        }
//
//    }


    // Second sorted by List
    // Using List<char[]> to save
    private static String frequencySortResult(String s) {
        // USING List to save the frequency
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            boolean mark = false;
            for (int index = 0; index < list.size(); index++) {
                // If in list has this word:
                if (list.get(index)[0] == temp) {
                    char[] old = list.get(index);
                    char[] late = new char[2];
                    late[0] = temp;
                    late[1] = (char) (old[1] + 1);
                    list.remove(old);
                    list.add(late);
                    mark = true;
                    break;
                }
            }
            if (!mark) {
                char[] late = new char[2];
                late[0] = temp;
                late[1] = '1';
                list.add(late);
            }
        }

        list.sort(new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                int temp = o2[1] - o1[1];
                if (temp >= 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        StringBuilder result = new StringBuilder();
        for (char[] aList : list) {
            for (int j = 0; j < aList[1] - 48; j++) {
                result.append(aList[0]);
            }
        }

        return result.toString();

    }


    public static void main (String[]args){
        frequencySortResult("aqwqqqqa");
    }
}
