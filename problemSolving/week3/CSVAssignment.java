package coursera.problemSolving.week3;

import edu.duke.*;
import org.apache.commons.csv.*;

public class CSVAssignment {
    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord csvRecord : parser) {
            String country1 = csvRecord.get(0);
            if(country1.equals(country)) {
                String export = csvRecord.get(1);
                return country + " exports " + export;
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for(CSVRecord csvRecord : parser ) {
            String exports = csvRecord.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)) {
                String country = csvRecord.get("Country");
                System.out.println(country);
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int count = 0;
        for(CSVRecord csvRecord : parser ) {
            String exports = csvRecord.get("Exports");
            if(exports.contains(exportItem)) {
                count++;
            }
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            String country = record.get("Country");
            if(value.length() > amount.length()) {
                System.out.println(country + " : "+value);
            }
        }
    }

    public static void main(String[] args) {
        CSVAssignment csvAssignment = new CSVAssignment();
        FileResource fr = new FileResource("/home/arshil/IdeaProjects/OOPS/src/coursera/problemSolving/week3/exports/exports_small.csv");
        CSVParser parser = fr.getCSVParser();
        System.out.println(csvAssignment.countryInfo(parser, "Germany"));
    }
}