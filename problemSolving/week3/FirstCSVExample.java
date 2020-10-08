package coursera.problemSolving.week3;

import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public static void readCSV() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser) {
            System.out.println(record.get("name"));
        }
    }

    public static void main(String[] args) {
        readCSV();
    }
}
