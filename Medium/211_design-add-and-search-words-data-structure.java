class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return helper(word, root, 0);
    }

    private boolean helper(String word, TrieNode node, int pos) {
        if (pos == word.length()) {
            return node.isWord;
        }
        char ch = word.charAt(pos);
        if (ch != '.') {
            return node.children[ch - 'a'] != null && helper(word, node.children[ch - 'a'], pos + 1);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && helper(word, node.children[i], pos + 1)) {
                return true;
            }
        }

        return false;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */