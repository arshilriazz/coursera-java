package coursera.course1.week1;

import edu.duke.*;

public class Main {
    public static void main(String[] args) {
        coursera.course1.week1.Point p1 = new coursera.course1.week1.Point(0,0);
        coursera.course1.week1.Point p2 = new Point(3,0);
        System.out.println(p1.distance(p2));
        FileResource fs = new FileResource();
        for(String line : fs.lines()) {
            System.out.println(line);
        }
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
