package coursera.course1.week1;

import edu.duke.*;
import edu.duke.Point;

import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for(Point ignored : s.getPoints()) {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double length = 0;
        Point prevPoint = s.getLastPoint();
        for(Point p : s.getPoints()) {
            length += prevPoint.distance(p);
            prevPoint = p;
        }
        int numOfPoints = getNumPoints(s);
        return length/numOfPoints;
    }

    public double getLargestSide(Shape s) {
        Point prevPoint = s.getLastPoint();
        double max = 0;
        for(Point p : s.getPoints()) {
            double length = prevPoint.distance(p);
            prevPoint = p;
            max = Math.max(max, length);
        }
        return max;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        for(Point p : s.getPoints()) {
            largestX = Math.max(largestX, p.getX());
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        for (File f : dr.selectedFiles()) {
            PerimeterAssignmentRunner par = new PerimeterAssignmentRunner();
            double ans = par.getPerimeter(new Shape(new FileResource(f)));
            largestPerimeter = Math.max(largestPerimeter, ans);
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        int largestParameter = 0;
        for(File f : dr.selectedFiles()) {
            PerimeterAssignmentRunner par = new PerimeterAssignmentRunner();
            double ans = par.getPerimeter(new Shape(new FileResource(f)));
            if(ans > largestParameter) temp = f;
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            PerimeterAssignmentRunner par = new PerimeterAssignmentRunner();
            double ans = par.getPerimeter(new Shape(new FileResource(file)));
            System.out.println("perimeter = " + ans);
        }
    }

    public void testFileWithLargestPerimeter() {
        System.out.println(getFileWithLargestPerimeter());
    }

    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File file : dr.selectedFiles()) {
            System.out.println(file);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
    }
}
