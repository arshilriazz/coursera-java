package coursera.course4;

public class Trie {
    int endsHere;
    Trie[] child;

    Trie() {
        endsHere = 0;
        child = new Trie[26];
    }

    public void insert(String str) {
        Trie ptr = this;
        for(int i = 0 ; i < str.length() ; i++) {
            int idx = str.charAt(i) - 'a';
            if(ptr.child[idx] == null) ptr.child[idx] = new Trie();
            ptr = ptr.child[idx];
        }
        ptr.endsHere++;
    }

    public boolean search(String str) {
        Trie ptr = this;
        for(int i = 0 ; i < str.length() ; i++) {
            int idx = str.charAt(i) - 'a';
            if(ptr.child[idx] == null) return false;
            ptr = ptr.child[idx];
        }
        return ptr.endsHere > 0;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("what");
        System.out.println(trie.search("what"));
        System.out.println(trie.search("helli"));
    }
}