import java.util.*;

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
        for (String domain : cpdomains) {
            if (domain.length() == 0)
                continue;
            int index = domain.indexOf(' ');
            int time = Integer.valueOf(domain.substring(0, index));
            domain = domain.substring(index + 1);
            map.put(domain, map.getOrDefault(domain, 0) + time);

            while (domain.indexOf('.') != -1) {
                domain = domain.substring(domain.indexOf('.') + 1);
                map.put(domain, map.getOrDefault(domain, 0) + time);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String s = entry.getValue() + " " + entry.getKey();
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisitsResult(s);
    }
}
