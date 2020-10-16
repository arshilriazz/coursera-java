package coursera.course1.week2.first;

import java.util.Scanner;

public class Part1 {
    public String findSimpleGene(String dna) {
        String ans = "";
        int startIndex = dna.indexOf("ATG");
        int endIndex = dna.indexOf("TAA", startIndex+2);

        System.out.println("given sample: " + dna);

        if(startIndex == -1 && endIndex == -1) {
            System.out.println("ATG and TAA not found");
        }

        else if(startIndex != -1 && endIndex == -1){
            System.out.println("TAA not found but ATG at " + startIndex);
        }

        else if(startIndex == -1 && endIndex != -1) {
            System.out.println("ATG not found but TAA at " + endIndex);
        }

        else {
            System.out.println("DNA contains ATG and TAA");
            ans = dna.substring(startIndex, endIndex + 3);
            if(ans.length() % 3 == 0) System.out.println(dna + " is a valid dna");
            else System.out.println("It starts with ATG and ends with TAA but not a multiple of 3");
        }
        return ans;
    }

    public void testSimpleGene(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            findSimpleGene(sc.nextLine());
        }
    }
}