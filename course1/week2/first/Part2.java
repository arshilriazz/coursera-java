package coursera.course1.week2.first;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String ans = "";
        String start = "";
        String end = "";

        char firstChar=dna.charAt(0);

        if (Character.isUpperCase(firstChar)) {
            start = startCodon.toUpperCase();
            end = stopCodon.toUpperCase();
        }
        else{
            start = startCodon.toLowerCase();
            end = stopCodon.toLowerCase();
        }

        int startIndex = dna.indexOf(start);
        int endIndex = dna.indexOf(end, startIndex + 2);

        System.out.println("given sample: " + dna);

        if(startIndex == -1 && endIndex == -1) {
            System.out.println("ATG and TAA not found");
        }

        else if(startIndex != -1 && endIndex == -1) {
            System.out.println("TAA not found but ATG at " + startIndex);
        }

        else if(startIndex == -1 && endIndex != -1) {
            System.out.println("ATG not found but TAA at " + endIndex);
        }

        else {
            System.out.println("DNA contains ATG and TAA");
            ans = dna.substring(startIndex, endIndex + 3);
            if(ans.length() % 3 == 0) System.out.println(dna + " is a valid DNA");
            else System.out.println("It starts with ATG and ends with TAA but not a multiple of 3");
        }
        return ans;
    }

    public void testSimpleGene() {
        findSimpleGene("ATAFSTAA","ATG","TAA");
    }
}
