package coursera.course2.week2;

import edu.duke.FileResource;
import java.util.*;

public class WordFrequencies {

    private List<String> myWords;
    private List<Integer> myFreqs;

    public WordFrequencies(){
        myWords = new ArrayList<>();
        myFreqs = new ArrayList<>();
    }

    public int findUnique(){
        myFreqs.clear();
        myWords.clear();
        FileResource fileResource = new FileResource();
        for(String word : fileResource.words()) {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if(index == -1) {
                myWords.add(word);
                myFreqs.add(1);
            }
            else {
                int currItems = myFreqs.get(index);
                myFreqs.set(index, currItems+1);
            }
        }
        return myWords.size();
    }

    public int findIndexOfMax() {
        int largestIndex = 0;
        int max = 0;
        for(int i = 0; i < myFreqs.size(); i++) {
            int value = myFreqs.get(i);
            if(value > max) {
                max = value;
                largestIndex = i;
            }
        }
        return largestIndex;
    }

    public void tester() {
        int uniqueWords = findUnique();
        System.out.println("unique words: " + uniqueWords);
        for(int i = 0; i < myWords.size(); i++){
            System.out.println(myFreqs.get(i)+" "+ myWords.get(i) );
        }
        int indexOfMax = findIndexOfMax();
        System.out.println("The word with the highest frequency is " + myWords.get(indexOfMax)
                            + " with count " + myFreqs.get(indexOfMax));
    }

    public static void main(String[] args) {
        WordFrequencies wordFrequencies = new WordFrequencies();
        wordFrequencies.tester();
    }
}