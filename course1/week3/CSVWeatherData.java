package coursera.course1.week3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class CSVWeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord csvRecord = null;
        for(CSVRecord record : parser) {
            if(csvRecord == null) {
                csvRecord = record;
            }
            else {
                double temp = Double.parseDouble(record.get("TemperatureF"));
                double temp1 = Double.parseDouble(csvRecord.get("TemperatureF"));
                if(temp < temp1) csvRecord = record;
            }
        }
        return csvRecord;
    }

    public void fileWithColdestTemperature() {
        CSVRecord answer = null;
        DirectoryResource dr = new DirectoryResource();
        File file = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currRow = coldestHourInFile(fr.getCSVParser());
            if(answer == null) file = f;
            else {
                int humidity = Integer.parseInt(currRow.get("TemperatureF"));
                int humidity1 = Integer.parseInt(answer.get("TemperatureF"));
                if(humidity < humidity1) file = f;
            }
        }
        FileResource fr = new FileResource(file);
        for(CSVRecord record : fr.getCSVParser()) {
            System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord csvRecord = null;
        for(CSVRecord record : parser) {
            if(csvRecord == null) {
                csvRecord = record;
            }
            else {
                double humidity = Double.parseDouble(record.get("Humidity"));
                double humidity1 = Double.parseDouble(csvRecord.get("Humidity"));
                if(humidity < humidity1) csvRecord = record;
            }
        }
        return csvRecord;
    }

    public void lowestHumidityInManyFiles() {
        CSVRecord answer = null;
        DirectoryResource dr = new DirectoryResource();
        File file = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currRow = lowestHumidityInFile(fr.getCSVParser());
            if(answer == null) file = f;
            else {
                int humidity = Integer.parseInt(currRow.get("Humidity"));
                int humidity1 = Integer.parseInt(answer.get("Humidity"));
                if(humidity < humidity1) file = f;
            }
        }
        FileResource fr = new FileResource(file);
        CSVRecord record = lowestHumidityInFile(fr.getCSVParser());
        System.out.println(record.get("DateUTC") + " " + record.get("TemperatureF"));
    }

    public void testLowestHumidityInManyFiles() {
        lowestHumidityInManyFiles();
    }

    public String testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        return "Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC");
    }

    public double averageTemperatureInFile(CSVParser parser) {
        int count = 0;
        double sum = 0;
        for(CSVRecord record : parser) {
            double temp = Double.parseDouble(record.get("TemperatureF"));
            sum += temp;
            count++;
        }
        return sum / count;
    }

    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        double averageTemperatureInFile = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + averageTemperatureInFile);
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double sum = 0;
        int count = 0;
        for(CSVRecord record : parser) {
            double humidity = Double.parseDouble(record.get("Humidity"));
            if(humidity >= value) {
                double temp = Double.parseDouble(record.get("TemperatureF"));
                sum += temp;
                count++;
            }
        }
        if(count != 0) return sum/count;
        return 0;
    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double humidity = averageTemperatureWithHighHumidityInFile(parser, 80);
        if(humidity != 0)
            System.out.println("Average Temp when high Humidity is " + humidity);
        else
            System.out.println("No temperatures with that humidity");
    }

    public static void main(String[] args) {
        CSVWeatherData csvWeatherData = new CSVWeatherData();
        csvWeatherData.testLowestHumidityInManyFiles();
    }
}
