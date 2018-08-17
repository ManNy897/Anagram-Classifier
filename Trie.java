/**
 * Created by aimunir on 3/30/17.
 */
import java.util.List;

public class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void addWord(String alphabetizedWord, String word){
        root.add(alphabetizedWord, word);
    }

    public List<AnagramClass> getAnagrams(){
        return root.getClasses();
    }
}
