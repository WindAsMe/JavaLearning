/**
 * Author     : WindAsMe
 * File       : TrieSolution.java
 * Time       : Create on 18-9-3
 * Location   : ../Home/JavaForLeeCode2/TrieSolution.java
 * Function   : LeetCode No.208
 */
public class TrieSolution {

    class TrieNode {
        public char val;
        public TrieNode[] children= new TrieNode[26];
        public boolean isWord;
        public TrieNode(){}
        public TrieNode(char c) {
            this.val= c;
        }
    }

    class Trie {

        private TrieNode root;
        public Trie() {
            root = new TrieNode();
            root.val= ' ';
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode n= root;
            for (int i=0; i<word.length(); i++){
                char c= word.charAt(i);
                if (n.children[c-'a'] ==null)
                    n.children[c-'a']= new TrieNode(c);
                n= n.children[c-'a'];
            }
            n.isWord= true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode n= root;
            for (int i=0; i<word.length(); i++){
                char c= word.charAt(i);
                if (n.children[c-'a'] ==null) return false;
                n= n.children[c-'a'];
            }
            return n.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode n= root;
            for (int i=0; i<prefix.length(); i++){
                char c= prefix.charAt(i);
                if (n.children[c-'a'] ==null) return false;
                n= n.children[c-'a'];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
