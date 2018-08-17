/**
 * Created by aimunir on 3/29/17.
 */

import java.util.Arrays;

public class Alphabetizer {

    //alphabetizes string---to complete with original implimentation
    public String alphabetize(String word){
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
