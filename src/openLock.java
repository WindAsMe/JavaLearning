import java.util.*;

/**
 * Author     : WindAsMe
 * File       : openLock.java
 * Time       : Create on 18-8-18
 * Location   : ../Home/JavaForLeeCode2/openLock.java
 * Function   : LeetCode  No.752
 */
public class openLock {

    private static int openLockResult(String[] deadends, String target) {
        Set<String> used = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add("0000");
        used.add("0000");
        for (String d:deadends) {
            if(d.equals("0000"))
                return -1;
            used.add(d);
        }
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size --> 0){
                String cur = q.poll();
                if(cur.equals(target))
                    return ans;
                String[] newStr = next(cur);
                for (int i = 0; i < 8; i++) {
                    if(!used.contains(newStr[i])){
                        q.add(newStr[i]);
                        used.add(newStr[i]);
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private static String[] next(String lock){
        String[] res  = new String[8];
        for (int i = 0; i < 4; i++) {
            res[i * 2] = lock.substring(0, i) + ((lock.charAt(i) - '0' + 1) % 10) + lock.substring(i + 1, 4);
            res[i * 2 + 1] = lock.substring(0, i)+((lock.charAt(i) - '0' + 9) % 10) + lock.substring(i + 1, 4);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLockResult(deadends, target));
    }
}

