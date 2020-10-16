package coursera.course1.week2.second;

public class FindGeneWhile {
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        while(currIndex != -1) {
            if((currIndex - startIndex) % 3 == 0) {
                return dna.substring(startIndex, currIndex);
            }
            else {
                currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }
        return "";
    }
}
