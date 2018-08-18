import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : partitionLabels.java
 * Time       : Create on 18-8-18
 * Location   : ../Home/JavaForLeeCode2/partitionLabels.java
 * Function   : LeetCode No.763
 */
public class partitionLabels {

    private static List<Integer> partitionLabelsResult(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        // save the last occurrence
        for(int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] = i;
        int start = -1;
        int end = 0;//start是下一个字段的首字母的前一个位置，第一个字段的首字母的位置一定是0
        for(int i = 0; i < S.length(); i++) {
            end = Math.max(end, map[S.charAt(i) - 'a']);//不断更新末尾指针的位置
            if(end == i) {//当i指针的位置和末尾指针的位置相同时意味着[start,end]之间的字母的最后出现位置都在[start,end]，尾指针无法再更新
                ans.add(end - start);//当前字段的长度
                start = end;//start是下一个字段的首字母的前一个位置
            }
        }
        return ans;
    }
}
