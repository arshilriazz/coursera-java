package coursera.problemSolving.week2;

import coursera.problemSolving.week2.first.Part3;

public class Main {
    public static void main(String[] args){
        Part3 p = new Part3();
        boolean ans = p.towOccurrences("atg", "ctgtatgta");
        System.out.println(ans);
    }
}
