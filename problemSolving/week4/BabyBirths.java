package coursera.problemSolving.week4;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyBirths {
    private String p1 = "/home/arshil/IdeaProjects/OOPS/src/coursera/problemSolving/week4/us_babynames_by_year/yob";
    private String p2 = ".csv";

    public void printNames() {
        FileResource fr = new FileResource();
        for(CSVRecord record : fr.getCSVParser(false)) {
            if(Integer.parseInt(record.get(2)) < 100) {
                System.out.println(
                        "Name " + record.get(0) + " " +
                        "Gender " + record.get(1) + " " +
                        "Num born " + record.get(2)
                );
            }
        }
    }

    public void totalBirths() {
        FileResource fr = new FileResource();
        int boyBirths = 0;
        int girlBirths = 0;
        int births = 0;
        for(CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            if(record.get(1).equals("M")) {
                boyBirths += numBorn;
            }
            else {
                girlBirths += numBorn;
            }
            births += numBorn;
        }
        System.out.println("number of girls names: " + girlBirths);
        System.out.println("number of boys names: " + boyBirths);
        System.out.println("number of names: " + births);
    }

    public int getRank(int year, String name, String gender) {
        int rank = -1;
        FileResource fr = new FileResource(p1 + year + p2);
        for(CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                rank = (int)record.getRecordNumber();
            }
        }
        return rank;
    }

    public int getRankNoYear(File f , String name, String gender) {
        int rank = -1;
        FileResource fr = new FileResource(f);
        for(CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(0).equals(name) && record.get(1).equals(gender)) {
                rank = (int)record.getRecordNumber();
            }
        }
        return rank;
    }

    public String getName(int year, int rank, String gender) {
        String rName = "NO NAME";
        FileResource fr = new FileResource("/home/arshil/IdeaProjects/OOPS/src/coursera/problemSolving/week4/us_babynames_by_year/yob" + year + ".csv");
        for (CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(1).equals(gender) && (int)record.getRecordNumber() == rank) {
                rName = record.get(0);
            }
        }
        return rName;
    }

    public String getNameNoYear(File f, int rank, String gender) {
        String rName = "NO NAME";
        FileResource fr = new FileResource(f);
        for (CSVRecord record : fr.getCSVParser(false)) {
            if(record.get(1).equals(gender) && (int)record.getRecordNumber() == rank) {
                rName = record.get(0);
            }
        }
        return rName;
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String rName = getName(newYear, rank, gender);
        System.out.println(name + " would be " + rName + " in the year " + newYear);
    }

    public int yearOfHighestRank(String name, String gender) {
        int highestYear = -1;
        int highestRank = Integer.MAX_VALUE;
        String fileName = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            int rank = getRankNoYear(f, name, gender);
            if(rank < highestRank) {
                highestRank = rank;
                fileName = f.toString();
            }
        }
        if(fileName == null) return -1;
        fileName = fileName.replaceAll("[^\\d]", "");
        highestYear = Integer.parseInt(fileName);
        return highestYear - 40000;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int totalBirths = 0;
        int rank = getRank(year, name, gender);
        FileResource fr = new FileResource(p1+year+p2);
        for (CSVRecord record : fr.getCSVParser(false)) {
            int currentRank = (int)record.getRecordNumber();
            if(record.get(1).equals(gender) && currentRank < rank ) {
                totalBirths += Integer.parseInt(record.get(2));
            }
        }
        return totalBirths;
    }

    public static void main(String[] args) {
        BabyBirths babyBirths = new BabyBirths();
        int rank = babyBirths.yearOfHighestRank("Jennifer", "F");
        System.out.println(rank);
        System.out.println(babyBirths.getTotalBirthsRankedHigher(1971,"Heather","F"));
    }
}
