/**
 * Created by aimunir on 3/29/17.
 */
import java.util.ArrayList;

//class containing list of anagrams
public class AnagramClass {
    int wordCount = 0;
    ArrayList<String> words;

    public AnagramClass(){
        words = new ArrayList<>();
    }

    public String add(String word){
        words.add(word);
        wordCount++;
        return word;
    }

    public void printAnagrams(){
        System.out.println("Word Count: " + wordCount);
        for(int i = 0; i < words.size(); i++){
            System.out.print(words.get(i) + ", ");
        }
        System.out.println();
    }


}
