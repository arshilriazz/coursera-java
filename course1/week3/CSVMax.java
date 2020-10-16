package coursera.course1.week3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord csvRecord = null;
        for(CSVRecord record : parser) {
            if(csvRecord == null) {
                csvRecord = record;
            }
            else {
                double temp = Double.parseDouble(record.get("TemperatureF"));
                double temp1 = Double.parseDouble(csvRecord.get("TemperatureF"));
                if(temp > temp1) csvRecord = record;
            }
        }
        return csvRecord;
    }

    public CSVRecord hottestDayInFile() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestRecord = null;
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = hottestHourInFile(fr.getCSVParser());
            if(largestRecord == null) largestRecord = currentRecord;
            else {
                double temp = Double.parseDouble(currentRecord.get("TemperatureF"));
                double temp1 = Double.parseDouble(largestRecord.get("TemperatureF"));
                if(temp1 < temp) largestRecord = currentRecord;
            }
        }
        return largestRecord;
    }

    public static void main(String[] args) {
        CSVMax csvMax = new CSVMax();
        CSVRecord record = csvMax.hottestDayInFile();
        System.out.println(record.get("TemperatureF") + " on " + record.get("DateUTC"));
    }
}
