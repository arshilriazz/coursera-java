package coursera.problemSolving.week2.third;

public class Part2 {
    public static float cgRatio(String dna) {
        int len = dna.length();
        int count = 0;
        for(int i = 0; i < dna.length(); i++) {
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G') count++;
        }
        return (float)count/len;
    }

    public static void main(String[] args) {
        System.out.println(cgRatio("ATGCCATAG"));
    }
}
