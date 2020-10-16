package coursera.course1.week2.third;

import edu.duke.StorageResource;
import edu.duke.FileResource;

public class Part3 {
    public void printAllTheStringsWith9Char(StorageResource sr) {
        int c = 0;
        for(String s : sr.data()) {
            if (s.length() > 9) {
                System.out.println(s);
                c++;
            }
        }
        if(c == 0) System.out.println("no strings with length greater than 9");
    }

    public int countAllTheStringsWith9Char(StorageResource sr) {
        int count = 0;
        for(String s : sr.data()) {
            if (s.length() > 9)
                count++;
        }
        return count;
    }

    public void printingStringsGt35(StorageResource sr) {
        int c = 0;
        for(String s : sr.data()) {
            if(Part2.cgRatio(s) > 0.35) {
                System.out.println(s);
                c++;
            }
        }
        if(c == 0) System.out.println("There are no Strings with cg ratio more than .35");
    }

    public int countStringsGt35(StorageResource sr) {
        int count = 0;
        for(String s : sr.data()) {
            if(Part2.cgRatio(s) > 0.35) {
                count++;
            }
        }
        return count;
    }

    public int lengthOfTheLongestString(StorageResource sr) {
        int max = Integer.MIN_VALUE;
        for(String s : sr.data()) {
            max = Math.max(s.length(), max);
        }
        return max;
    }

    public void processGenes(StorageResource sr) {
        printAllTheStringsWith9Char(sr);
        System.out.println(countAllTheStringsWith9Char(sr));
        printingStringsGt35(sr);
        System.out.println(countStringsGt35(sr));
        System.out.println(lengthOfTheLongestString(sr));
    }

    public static void main(String[] args) {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        Part1 p1 = new Part1();
        StorageResource sr = p1.getAllGenes(dna.toUpperCase());
        Part3 p3 = new Part3();
        p3.processGenes(sr);
    }
}
