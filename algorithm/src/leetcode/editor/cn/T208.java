
package leetcode.editor.cn;

//[208]实现 Trie (前缀树)
//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树


public class T208 {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    private static class Trie {

        //俗称字典树，可以看成是26叉树，每个叉表示a-z对应的字母
        Trie[] son;
        boolean end;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            son = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] ch = word.toCharArray();
            Trie root = this;
            for (int i = 0; i < ch.length; i++) {
                if (root.son[ch[i] - 'a'] == null) {
                    root.son[ch[i] - 'a'] = new Trie();
                }
                root = root.son[ch[i] - 'a'];
            }
            //标记为单词末尾
            root.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] ch = word.toCharArray();
            Trie root = this;
            for (int i = 0; i < ch.length; i++) {
                if (root.son[ch[i] - 'a'] == null) {
                    return false;
                }
                root = root.son[ch[i] - 'a'];
            }
            return root.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] ch = prefix.toCharArray();
            Trie root = this;
            for (int i = 0; i < ch.length; i++) {
                if (root.son[ch[i] - 'a'] == null) {
                    return false;
                }
                root = root.son[ch[i] - 'a'];
            }
            for (int i = 0; i < 26; i++) {
                if (son[ch[i] - 'a'] != null) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
