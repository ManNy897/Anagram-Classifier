import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by aimunir on 3/27/17.
 */

//list of tries containing classified anagrams. Tries are separated based on size of input which is designated by the index in the list
//so index 4 of list contains a trie only of words of length 4
public class ClassifiedTree {

    //list of tries. initiated to length 10
    private Vector<Trie> tree = new Vector<>(10);

    public void add(String alphabetizedWord, String word){
        //increase length of list if word longer than 10 is input
        int index = word.length();
        if(index >= tree.size()){
            tree.setSize(index + 1);
        }
        if(tree.get(index) == null){
            tree.set(index, new Trie());
        }
        //add word to appropriate trie
        tree.get(index).addWord(alphabetizedWord, word);
    }

    //retrieve list of all anagram classes
    public List<AnagramClass> getAnagramsList(){
        List<AnagramClass> anagrams = new ArrayList<>();
        for(int i = 0; i < tree.size(); i++){
            if(tree.get(i) != null){
                anagrams.addAll(tree.get(i).getAnagrams());
            }
        }
        return anagrams;
    }



}
