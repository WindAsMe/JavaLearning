import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : hashSet.java
 * Time       : Create on 18-8-18
 * Location   : ../Home/JavaForLeeCode2/hashSet.java
 * Function   : The Utility of hashSet
 */
public class hashSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder("0010");
        set.add(sb.toString());
        set.add("0001");
        set.add("0002");
        if (set.contains("0010"))
            System.out.println("StringBuilder is in set");
        else
            System.out.println("StringBuilder isn't in set");
    }
}
