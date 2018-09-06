import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : WordDictionaryResult.java
 * Time       : Create on 18-9-6
 * Location   : ../Home/JavaForLeeCode2/WordDictionaryResult.java
 * Function   : LeetCode No.211
 */
public class WordDictionaryResult {


    public static class WordDictionary {

        class TrieNode {
            // Initialize your data structure here.
            char c;
            boolean leaf;
            Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

            public TrieNode(char c) {
                this.c = c;
            }

            public TrieNode(){};
        }

        private TrieNode root = new TrieNode();

        public void addWord(String word) {
            Map <Character, TrieNode> children = root.children;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode t;
                if(children.containsKey(c))
                    t = children.get(c);
                else {
                    t = new TrieNode(c);
                    children.put(c, t);
                }
                children = t.children;
                if(i == word.length() - 1)
                    t.leaf = true;
            }
        }

        public boolean search(String word) {
            return searchNode(word, root);
        }

        public boolean searchNode(String word, TrieNode tn) {
            if(tn == null)
                return false;
            if(word.length() == 0)
                return tn.leaf;

            Map<Character, TrieNode> children = tn.children;
            TrieNode t;
            char c = word.charAt(0);
            if(c == '.') {
                for(char key : children.keySet() )
                    if(searchNode(word.substring(1), children.get(key) )) return true;
                return false;
            } else if(!children.containsKey(c)) {
                return false;
            } else {
                t = children.get(c);
                return searchNode(word.substring(1), t);
            }
        }
    }




//    static class WordDictionary {
//
//        class TrieNode {
//            TrieNode[] son;
//            boolean valid;
//
//            private TrieNode() {
//                this.son = new TrieNode[26];
//                this.valid = false;
//            }
//        }
//
//        private TrieNode root;
//
//        /** Initialize your data structure here. */
//        public WordDictionary() {
//            root = new TrieNode();
//        }
//
//        /** Adds a word into the data structure. */
//        public void addWord(String word) {
//            TrieNode node = root;
//            char[] helper = word.toCharArray();
//            for (char aHelper : helper) {
//                if (node.son[aHelper - 'a'] == null)
//                    node.son[aHelper - 'a'] = new TrieNode();
//                node = node.son[aHelper - 'a'];
//            }
//            node.valid = true;
//            // System.out.println(root.son[1].son[0].son[3].valid);
//        }
//
//        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
//        public boolean search(String word) {
//            return searchNode(word, root);
//        }
//
//
//        public boolean searchNode(String word, TrieNode tn) {
//            if(tn == null)
//                return false;
//            if(word.length() == 0)
//                return tn.valid;
//
//            Map<Character, TrieNode> children = tn.children;
//            TrieNode t = null;
//                char c = word.charAt(0);
//                if(c=='.') {
//                    for(char key : children.keySet() ) {
//                        if(searchNode(word.substring(1), children.get(key) )) return true;
//                    }
//                    return false;
//                } else if(!children.containsKey(c)) {
//                    return false;
//                } else {
//                    t = children.get(c);
//                    return searchNode(word.substring(1), t);
//                }
//        }
//    }

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
        dict.addWord("a");
        //.addWord("mad");
//        System.out.println(dict.search(".")); // true
//        System.out.println(dict.search("a")); // true
//        System.out.println(dict.search("aa")); // false
//        System.out.println(dict.search("a")); // true
        System.out.println(dict.search(".a.")); // false
        System.out.println(dict.search("a.")); // false
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
