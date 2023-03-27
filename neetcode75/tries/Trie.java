package tries;

import java.util.HashSet;
//https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!curr.containsKey(currChar)) {
                curr.insertChar(currChar);
            }
            curr = curr.getChar(currChar);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!curr.containsKey(currChar)) {
                return false;
            }
            curr = curr.getChar(currChar);
        }
        return curr.getEnd();
    }

    public boolean searchWithBlanks(String word) {
        return searchWithBlanks(word, root);
    }

    private boolean searchWithBlanks(String word, Node root) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (currChar == '.') {
                HashSet<Character> set = curr.getChars();
                for (char c : set) {
                    if (searchWithBlanks(word.substring(i+1), curr.getChar(c))) {
                        return true;
                    }
                }
                return false;
            } else if (!curr.containsKey(currChar)) {
                return false;
            }
            curr = curr.getChar(currChar);
        }
        return curr.getEnd();
    }


    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (!curr.containsKey(currChar)) {
                return false;
            }
            curr = curr.getChar(currChar);
        }
        return true;

    }


    public static void main(String[] args) {

        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println("should return true, returns: " + trie.search("apple"));
//
//        System.out.println("should return true, returns: " + trie.startsWith("apple"));
//
//        trie.insert("app");
//        System.out.println("should return true, returns: " + trie.search("app"));

        trie.insert("bad");
        trie.insert("dad");
        trie.insert("mad");
        trie.insert("cad");

        boolean b = trie.searchWithBlanks(".ad");
        System.out.println(b);
    }
}
