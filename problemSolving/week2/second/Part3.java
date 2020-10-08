package coursera.problemSolving.week2.second;

public class Part3 {
    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex+3);
        while(currIndex != -1) {
            int diff = currIndex - startIndex;
            if(diff % 3 == 0) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
            }
        }
        return -1;
    }

    public int minimum(int a, int b) {
        if(a < 0 && b < 0) return a;
        else if(a < 0) return b;
        else if(b < 0) return a;
        return Math.min(a,b);
    }

    public int findGene(String dna, int index) {
        int startIndex = dna.indexOf("ATG", index);
        if(startIndex == -1) return -1;
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int min = minimum(taaIndex, tagIndex);
        min = minimum(min, tgaIndex);
        if(min > 0) return min;
        return -1;
    }

    public void countAllGenes(String dna) {
        int index = 0;
        int count = 0;
        while(index < dna.length() - 2) {
            int startIndex = dna.indexOf("ATG", index);
            if(startIndex == -1) break;
            int end = findGene(dna, startIndex);
//            System.out.println(dna.substring(startIndex, end + 3));
            count++;
            index = end + 3;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Part3 p3 = new Part3();
        String dna = "ATGTAAHKJATGAHJGSATAAGJHKJJJKL";
        p3.countAllGenes(dna);
    }
}
