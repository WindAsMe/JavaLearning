 /**
 * Author     : WindAsMe
 * File       : CodecResult.java
 * Time       : Create on 18-9-13
 * Location   : ../Home/JavaForLeeCode2/CodecResult.java
 * Function   : LeetCode No.535
 */
public class CodecResult {

    public static class Codec {

        private String pre;
        private char[] factor = {'A','B', 'C', 'D', 'E', 'a', 'b', 'c', 'd', 'e', '0', '1', '2', '3', '4'};
        private StringBuilder ans;
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            char[] helper = longUrl.toCharArray();
            StringBuilder post = new StringBuilder();
            for (int i = 0; i < 6; i++)
                post.append(factor[(int) (Math.random() * 15)]);

            int mid = longUrl.length() - 1;
            for (; mid >= 0; mid--) {
                if (helper[mid] == '/')
                    break;
            }
            pre = longUrl.substring(0, mid);
            ans = new StringBuilder("http://" + longUrl.substring(mid + 1, longUrl.length()) + "/" + post);
            return ans.toString();
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return pre + ans.substring(6, ans.length() - 7);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
    public static void main(String[] args) {
        Codec c = new Codec();
        System.out.println(c.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(c.decode(c.ans.toString()));
    }
}
