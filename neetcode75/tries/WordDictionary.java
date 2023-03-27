package tries;
//https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
import java.util.HashSet;

public class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
}
