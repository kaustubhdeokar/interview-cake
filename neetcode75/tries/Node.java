package tries;

import java.util.HashSet;

public class Node {
    Node[] arr = new Node[26];
    boolean isEnd = false;
    HashSet<Character> set = new HashSet<>();

    HashSet<Character> getChars(){
        return set;
    }
    boolean containsKey(char ch) {
        return arr[ch - 'a'] != null;
    }

    void insertChar(char ch) {
        arr[ch - 'a'] = new Node();
        set.add(ch);
    }

    Node getChar(char ch) {
        return arr[ch - 'a'];
    }

    void setEnd() {
        isEnd = true;
    }

    boolean getEnd() {
        return isEnd;
    }

}
