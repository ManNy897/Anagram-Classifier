import java.util.ArrayList;
import java.util.List;

/**
 * Created by aimunir on 3/30/17.
 */
public class TrieNode {
    private TrieNode parent;
    TrieNode[] children;
    ArrayList<Integer> childrenIndexes;
    AnagramClass anagramClass;
    boolean terminalNode;
    char character;


    public TrieNode(){
        children = new TrieNode[26];
        childrenIndexes = new ArrayList<>();
        anagramClass = null;
        terminalNode = false;
    }

    public TrieNode(char character){
        children = new TrieNode[26];
        childrenIndexes = new ArrayList<>();
        anagramClass = null;
        this.character = character;
        terminalNode = false;
    }

    public void add(String classChars, String word){
       // System.out.println("Runnning with char: " + classChars + "  and word: " + word);
        if(classChars.length() == 0){
            this.terminalNode = true;
            if(anagramClass == null){
                anagramClass = new AnagramClass();
            }
            //System.out.println("Adding word to class: " + " "+ word);
            anagramClass.add(word);
            return;
        }
        int charPos = classChars.charAt(0) - 'a';
        if(this.children[charPos] == null){
            this.children[charPos] = new TrieNode(classChars.charAt(0));
            this.children[charPos].parent = this;
            this.childrenIndexes.add(charPos);
        }
        this.children[charPos].add(classChars.substring(1), word);
    }

    public List<AnagramClass> getClasses(){
        List<AnagramClass> list = new ArrayList<>();
        if(this.terminalNode){
            list.add(this.anagramClass);
            return list;
        }
        for(Integer index : this.childrenIndexes){
            list.addAll(this.children[index].getClasses());
        }
        return list;
    }


}
