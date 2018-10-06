import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : subdomainVisits.java
 * Time       : Create on 18-10-6
 * Location   : ../Home/JavaForLeeCode2/subdomainVisits.java
 * Function   : LeetCode No.811
 */
public class subdomainVisits {

    private static List<String> subdomainVisitsResult(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            int frequency = Integer.valueOf(s.split(" ")[0]);
            String domain = s.split(" ")[1];
            map.put(domain, frequency);
        }
        System.out.println(map.toString());
        return null;
    }

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisitsResult(s);
    }
}
