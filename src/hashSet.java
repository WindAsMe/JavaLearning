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
        set.add("0001");
        set.add("0002");
        if (set.contains("0001"))
            System.out.println("0001 waiting save");
        else
            System.out.println("0001 can be save");
    }
}
