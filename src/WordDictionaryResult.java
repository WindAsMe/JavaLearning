/**
 * Author     : WindAsMe
 * File       : WordDictionaryResult.java
 * Time       : Create on 18-9-6
 * Location   : ../Home/JavaForLeeCode2/WordDictionaryResult.java
 * Function   : LeetCode No.211
 */
public class WordDictionaryResult {

    static class WordDictionary {

        class TrieNode {
            TrieNode[] son;
            boolean valid;

            private TrieNode() {
                this.son = new TrieNode[26];
                this.valid = false;
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            char[] helper = word.toCharArray();
            for (char aHelper : helper) {
                if (node.son[aHelper - 'a'] == null)
                    node.son[aHelper - 'a'] = new TrieNode();
                node = node.son[aHelper - 'a'];
            }
            node.valid = true;
            // System.out.println(root.son[1].son[0].son[3].valid);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            System.out.println(word);
            char[] helper = word.toCharArray();
            // replace the '.' to 'a' - 'z'
            for (int i = 0; i < helper.length; i++) {
                if (helper[i] == '.') {
                    for (char c = 'a'; c <= 'z'; c++) {
                        StringBuilder s = new StringBuilder(word.substring(0, i));
                        s.append(c).append(word.substring(i + 1, helper.length));
                        if (search(s.toString()))
                            return true;
                    }
                }
            }

            // Must the certain String
            TrieNode node = root;
            for (char aHelper : helper) {
                node = node.son[aHelper - 'a'];
                if (node == null)
                    return false;
            }
            return node.valid;
        }
    }

    // Use the Set and Recursion: TL
//    static class WordDictionary {
//
//        private Set<String> set;
//
//        /** Initialize your data structure here. */
//        public WordDictionary() {
//            set = new HashSet<>();
//        }
//
//        /** Adds a word into the data structure. */
//        public void addWord(String word) {
//            set.add(word);
//        }
//
//        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//        public boolean search(String word) {
//            System.out.println("word: " + word);
//            char[] help = word.toCharArray();
//            System.out.println(Arrays.toString(help));
//            for (int i = 0; i < help.length; i++) {
//                if (help[i] == '.') {
//                    for (char c = 'a'; c <= 'z'; c++) {
//                        StringBuilder s = new StringBuilder(word.substring(0, i));
//                        s.append(c).append(word.substring(i + 1, help.length));
//                        if (search(s.toString()))
//                            return true;
//                    }
//                }
//            }
//            return set.contains(word);
//        }
//    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        //.addWord("mad");
        System.out.println(dict.search("pad")); // false
        // System.out.println(dict.search("bad")); // true
        System.out.println(dict.search(".ad")); // true
        System.out.println(dict.search("...")); // true
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
