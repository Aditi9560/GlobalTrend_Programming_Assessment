package assesmentsolutions;
public class Trie {
	
	    private TrieNode root;
	  
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    //insert (word)
	    public void insert(String word) {
	        TrieNode current = root;
	        
	        for (int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            if (current.children[ch - 'a'] == null) {
	                current.children[ch - 'a'] = new TrieNode();
	            }
	            current = current.children[ch - 'a'];
	        }
	        
	        current.isEndOfWord = true;
	    }
	    
	    //search(word)
	    public boolean search(String word) {
	        TrieNode node = searchNode(word);
	        return node != null && node.isEndOfWord;
	    }
	    
	    //starts with(prefix)
	    public boolean startsWith(String prefix) {
	        return searchNode(prefix) != null;
	    }
	    
	    private TrieNode searchNode(String word) {
	        TrieNode current = root;
	        
	        for (int i = 0; i < word.length(); i++) {
	            char ch = word.charAt(i);
	            if (current.children[ch - 'a'] == null) {
	                return null;
	            }
	            current = current.children[ch - 'a'];
	        }
	        
	        return current;
	    }
	    
	    private static class TrieNode {
	        TrieNode[] children;
	        boolean isEndOfWord;
	        
	        TrieNode() {
	            children = new TrieNode[26];
	            isEndOfWord = false;
	        }
	    }
	    
	    public static void main(String[] args) {
	        Trie trie = new Trie();
	        
	        trie.insert("aditi");
	        System.out.println(trie.search("aditi"));  
	        System.out.println(trie.search("adi"));     
	        System.out.println(trie.startsWith("adi")); 
	        trie.insert("adi");
	        System.out.println(trie.search("adi"));     
	    }
	}


