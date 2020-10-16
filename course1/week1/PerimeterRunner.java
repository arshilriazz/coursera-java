package coursera.course1.week1;

import edu.duke.Point;
import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape shape) {
        // Start with totalPerim = 0
        double perimeter = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = shape.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : shape.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            perimeter = perimeter + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return perimeter;
    }

    public void testPerimeter () {
        FileResource fileResource = new FileResource();
        double perimeter = getPerimeter(new Shape(fileResource));
        System.out.println("perimeter = " + perimeter);
    }
}
