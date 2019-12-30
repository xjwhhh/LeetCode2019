public class WordDictionary {

    class Node {

        // R links to node children
        private Node[] links;

        private final int R = 26;

        private boolean isEnd;

        public Node() {
            links = new Node[R];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public Node get(char ch) {
            return links[ch -'a'];
        }
        public void put(char ch, Node node) {
            links[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }

    private Node root=new Node();

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new Node());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return match(word, root, 0);
    }

    private boolean match(String word, Node node, int start) {
        if (start == word.length()) {
            return node.isEnd();
        }
        char alpha = word.charAt(start);
        if (alpha == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.links[i] != null && match(word, node.links[i], start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.get(alpha) == null) {
                return false;

            }
            return match(word, node.get(alpha), start + 1);
        }
    }

}
