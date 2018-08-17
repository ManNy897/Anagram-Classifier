import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by aimunir on 3/27/17.
 */
public class Classifier {

    //list containing tries which contain classified anagrams
    ClassifiedTree tree = new ClassifiedTree();

    //read in dictionary
    public void readDict(String dir) {
        try {
            String word;
            BufferedReader br = new BufferedReader(new FileReader(dir));
            Alphabetizer alphabetizer = new Alphabetizer();
            while ((word = br.readLine()) != null) {
                String alphabetizedWord = alphabetizer.alphabetize(word);
                classify(alphabetizedWord, word);
            }
            printAnagrams();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }





    //classify sorted word
    public void classify(String alphabetizedWord, String word){
        tree.add(alphabetizedWord, word);
    }

    //retrieve list of all anagram classes and print out all words from each class
    public void printAnagrams(){
        List<AnagramClass> anagrams = tree.getAnagramsList();
        for(AnagramClass anagram: anagrams){
            anagram.printAnagrams();
        }
    }
}
