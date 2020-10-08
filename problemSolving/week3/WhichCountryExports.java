package coursera.problemSolving.week3;

import edu.duke.FileResource;
import org.apache.commons.csv.*;

public class WhichCountryExports {
    public static void listExporters(CSVParser parser, String exportOfInterest) {
        for(CSVRecord record : parser) {
            String export = record.get(1);
            if(export.contains(exportOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public static void main(String[] args) {
        FileResource fr = new FileResource("/home/arshil/IdeaProjects/OOPS/src/coursera/problemSolving/week3/exports/exportdata.csv");
        CSVParser csvParser = fr.getCSVParser();
        listExporters(csvParser, "tea");
    }
}
