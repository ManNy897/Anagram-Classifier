/**
 * Created by aimunir on 3/27/17.
 */

import java.util.Vector;

public class HashTable {

    Vector<AnagramClass> table;
    private int numElements = 0;

    public HashTable(){
        table = new Vector<>();
        table.setSize(1000);
    }

    public String put(String word, String alphabetizedWord){
        if(numElements > table.size()/2){
           reSize();
        }
        //System.out.println("M value: " + table.size());
        int key = (int) sfold(alphabetizedWord, table.size(), word.length());
        System.out.println("key: " + key);
        //if no current class add new anagram class
        AnagramClass anagramClass = findClass(key, alphabetizedWord);
        if(anagramClass == null){
            System.out.println("Error Occurred in finding anagram class.");
            return "";
        }

        anagramClass.add(word);

        return word;
    }

    public AnagramClass findClass(int key, String alphabetizedWord){
            if(table.get(key) == null){
                System.out.println("null found");
                numElements++;
                table.set(key, new AnagramClass(alphabetizedWord));
                return table.get(key);
            }
            if(table.get(key).anagramClass == alphabetizedWord){
                System.out.println("match made");
                return table.get(key);
            }
            int index = key + 1;
            int hash = index % table.size();
            while(hash != key) {
                if (table.get(hash) == null) {
                    numElements++;
                    table.set(hash, new AnagramClass(alphabetizedWord));
                    return table.get(hash);
                }
                if (table.get(hash).anagramClass == alphabetizedWord) {
                    System.out.println("match made");
                    return table.get(hash);
                }
                index++;
                hash = index % table.size();
            }

            return null;
    }


    public long sfold(String s, int M, int wordLength) {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char c[] = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char c[] = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }
        //System.out.println("Sum: " + Math.abs(sum));
        //System.out.println("M: " + M);
        return(Math.abs(sum) % M);
    }

    public void reSize(){
        Vector<AnagramClass> oldTable = (Vector<AnagramClass>) table.clone();
        table = new Vector<>();
        table.setSize(oldTable.size() * 2);

        for(int i = 0; i < oldTable.size(); i++){
            if(oldTable.get(i) != null){
                AnagramClass currClass = oldTable.get(i);
                int key = (int) sfold(currClass.anagramClass, table.size(), currClass.anagramClass.length());
                rePut(currClass, key);
            }
        }
    }

    public void rePut(AnagramClass anagramClass, int key){
        if(table.get(key) == null){
            table.set(key, anagramClass);
            return;
        }
        int index = key + 1;
        int hash = index % table.size();
        while(hash % table.size() != key){
            if(table.get(hash) == null){
                table.set(hash, anagramClass);
                return;
            }
            index++;
            hash = index % table.size();
        }
    }

    public int getNumElements(){
        return this.numElements;
    }

    public void printTable(){
        for(int i = 0; i < table.size(); i++){
            if(table.get(i) != null){
                table.get(i).printAnagrams();
                System.out.println();
            }
        }
    }

}
