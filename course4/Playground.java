package coursera.course4;

import java.util.*;

public class Playground {
    public static void main(String[] args) {
        int[] array = {8,1,2,3,4,4,5,4,4,4};
        Set<Integer> set = new HashSet<>();
        for(int x : array) {
            set.add(x);
        }
        for(int x : set) {
            System.out.println(x);
        }
    }
}
