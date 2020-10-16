package coursera.course2.week1;

import edu.duke.FileResource;

public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts) {
        for(String word : resource.words()) {
            int length = word.length();
            boolean lastLegitLetter = Character.isLetter(word.charAt(word.length() - 1));
            boolean firstLegitLetter = Character.isLetter(word.charAt(0));
            if(!firstLegitLetter && !lastLegitLetter && length > 1) {
                length -= 2;
            }
            else if(!firstLegitLetter && lastLegitLetter && length != 0) {
                length -= 1;
            }
            else if(!lastLegitLetter && firstLegitLetter && length != 0) {
                length -= 1;
            }
            if(length > 30) length = 30;
            counts[length]++;
        }
    }

    public void testCountWordLengths() {
        int[] counts = new int[15];
        String fileName = "/home/arshil/IdeaProjects/OOPS/src/coursera/arrayslistsandstructureddata/week1/test.txt";
        countWordLengths(new FileResource(fileName), counts);
        int i = 0;
        for(int length : counts) {
            System.out.print(i++ + " " + length);
            System.out.println();
        }
        System.out.println(indexOfMax(counts));
    }

    public int indexOfMax(int[] values) {
        int max = Integer.MIN_VALUE;
        for(int value : values) {
            max = Math.max(value, max);
        }
        return max;
    }

    public static void main(String[] args) {
        WordLengths wordLengths = new WordLengths();
        wordLengths.testCountWordLengths();
    }

}
