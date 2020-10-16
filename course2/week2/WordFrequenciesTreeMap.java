package coursera.course2.week2;

import edu.duke.FileResource;

import java.util.*;

public class WordFrequenciesTreeMap {
    private Map<String, Integer> wordFrequency;

    public WordFrequenciesTreeMap() {
        wordFrequency = new TreeMap<>();
    }

    public int findUnique() {
        wordFrequency.clear();
        FileResource fileResource = new FileResource();
        for(String word : fileResource.words()) {
            word = word.toLowerCase();
            if(!wordFrequency.containsKey(word)) {
                wordFrequency.put(word, 1);
            }
            else {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            }
        }
        return wordFrequency.size();
    }

    public void displayWords() {
        wordFrequency.clear();
        FileResource fileResource = new FileResource();
        for(String word : fileResource.words()) {
            word = word.toLowerCase();
            if(!wordFrequency.containsKey(word)) {
                wordFrequency.put(word, 1);
            }
            else {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            }
        }
        for(Map.Entry<String, Integer> wordPair : wordFrequency.entrySet()) {
            System.out.println(wordPair.getKey() + " " + wordPair.getValue());
        }
    }

    public static void main(String[] args) {
        WordFrequenciesTreeMap wordFrequenciesTreeMap = new WordFrequenciesTreeMap();
        wordFrequenciesTreeMap.displayWords();
    }
}


