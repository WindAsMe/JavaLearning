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
            String[] domains = entry.getKey().split("\\.");
            for (int i = 0; i < domains.length; i++) {
                StringBuilder builder = new StringBuilder();
                for (int i1 = i; i1 < domains.length; i1++) {
                    if (i1 != domains.length - 1)
                        builder.append(domains[i1]).append('.');
                    else
                        builder.append(domains[i1]);
                }

                if (helper.get(builder.toString()) == null)
                    helper.put(builder.toString(), entry.getValue());
                else
                    helper.put(builder.toString(), helper.get(builder.toString()) + entry.getValue());
            }
        }
        for (Map.Entry<String, Integer> entry : helper.entrySet())
            list.add(entry.getValue() + " " + entry.getKey());
        System.out.println(list.toString());
        return list;
    }

    public static void main(String[] args) {
        String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisitsResult(s);
    }
}
