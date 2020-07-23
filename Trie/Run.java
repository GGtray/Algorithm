package Trie;

public class Run {
    public static void main(String[] args) {
        Trie t1 = new Trie();
        t1.insert("apple");
        // System.out.print(t1.root);
        System.out.print(t1.search("apple"));
        System.out.print(t1.search("app"));
    }
}