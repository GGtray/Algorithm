package Trie;
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children; // = new HashMap<Character, TrieNode>(); // edges benethe, each edge hold 1 character, connect to its value
    boolean isWord;
    int count; // all words counter including self

    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        boolean isWord = false;
        int count = 0;
    }
}

public class Trie {
    // private static class TrieNode {
    //     Map<Character, TrieNode> children; // edges benethe, each edge hold 1 character, connect to its value
    //     boolean isWord;
    //     int count; // all words counter including self

    //     public TrieNode() {
    //         Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    //         boolean isWord = false;
    //         int count = 0;
    //     }
    // }
    static TrieNode root;
    public Trie() {
        // rooot
        root = new TrieNode();
        // root.children = new HashMap<Character, TrieNode>();
        // root.children = new HashMap<Character, TrieNode>(); // 注意data structure必须要初始化，不然没有实现
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        // if (search(word)) {
        //     return;
        // }
        TrieNode cur =  root;
        for (int i = 0; i < word.length(); i++) {
            
            TrieNode next = cur.children.getOrDefault(word.charAt(i), null);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;
        }
        cur.isWord = true;
        cur.count++;
        return; 
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        // data structure:
        // cur: [root, cur) path in trie has matched string word [0, i); cur's children: being matched at this loop
        // next: one of 
        // i: index of word string, [0, i) has been matched, i: being matched
        
        // algorithm: iterate over one path
        // init: cur = root
        // term: 
        // for each loop: 1
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }

    
}
