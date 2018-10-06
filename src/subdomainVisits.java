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
        Map<String, Integer> helper = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : cpdomains) {
            int frequency = Integer.valueOf(s.split(" ")[0]);
            String domain = s.split(" ")[1];
            map.put(domain, frequency);
        }
        // System.out.println(map.toString());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            String[] domains = entry.getKey().split("\\.");
            System.out.println(Arrays.toString(domains));
            for (String domain : domains) {
                if (helper.get(domain) == null)
                    helper.put(domain, entry.getValue());
                else
                    helper.put(domain, helper.get(domain) + entry.getValue());
            }
        }
        System.out.println(helper.toString());
        return list;
    }

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisitsResult(s);
    }
}
