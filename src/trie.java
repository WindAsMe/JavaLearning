/**
 * Author     : WindAsMe
 * File       : trie.java
 * Time       : Create on 18-9-3
 * Location   : ../Home/JavaForLeeCode2/trie.java
 * Function   : Trie Tree
 */
public class trie {

    private static class TrieTree {
        public boolean saved;
        public TrieTree[] son = new TrieTree[26];
    }

    public static class Solution {

        private TrieTree tree;
        Solution() {
            tree = new TrieTree();
        }

        private void add(String s) {
            char[] helper = s.toCharArray();
            TrieTree node = tree;
            for (int i = 0; i < helper.length; i++) {
                // This is important
                // If directly new, the previous might be overwrite
                if (node.son[helper[i] - 'a'] == null)
                    node.son[helper[i] - 'a'] = new TrieTree();
                node = node.son[helper[i] - 'a'];
                if (i == helper.length - 1)
                    node.saved = true;
            }
        }

        boolean find(String s) {
            char[] helper = s.toCharArray();
            TrieTree node = tree;
            for (int i = 0; i < helper.length; i++) {
                node = node.son[helper[i] - 'a'];
                if (node == null)
                    return false;
                if (i == helper.length - 1)
                    return node.saved;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.add("apple");
        System.out.println(s.find("apple"));
        System.out.println(s.find("app"));
        System.out.println(s.find("b"));
        s.add("app");
        System.out.println(s.find("apple"));
        System.out.println(s.find("app"));
        System.out.println(s.find("b"));
    }
}
