import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : WordDictionaryResult.java
 * Time       : Create on 18-9-6
 * Location   : ../Home/JavaForLeeCode2/WordDictionaryResult.java
 * Function   : LeetCode No.211
 */
public class WordDictionaryResult {

    static class WordDictionary {

        private Set<String> set;

        /** Initialize your data structure here. */
        public WordDictionary() {
            set = new HashSet<>();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            set.add(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            char[] help = word.toCharArray();
            for (int i = 0; i < help.length; i++) {
                if (i == '.') {
                    StringBuilder s = new StringBuilder(word.substring(0, i));
                    for (char c = 'a'; c <= 'z'; c++) {
                        s.append(c).append(word.substring(i + 1, help.length));
                        if (search(s.toString()))
                            return true;
                    }
                }
            }
            return set.contains(word);
        }
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        System.out.println(dict.search("pad")); // false
        System.out.println(dict.search("bad")); // true
        System.out.println(dict.search(".ad")); // true
        System.out.println(dict.search("b..")); // true
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
