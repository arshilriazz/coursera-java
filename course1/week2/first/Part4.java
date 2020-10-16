package coursera.course1.week2.first;

import edu.duke.FileResource;
import edu.duke.URLResource;

public class Part4 {
    public static void search(){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        FileResource fr = new FileResource();
        for (String s : fr.lines()) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        search();
    }
}