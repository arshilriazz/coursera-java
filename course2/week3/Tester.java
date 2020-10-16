package coursera.course2.week3;

public class Tester {
    public void testLogAnalyzer(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile();
        logAnalyzer.printAll();
        System.out.println(logAnalyzer.iPsMostVisits(logAnalyzer.countVisitsPerIP()));
    }
}
