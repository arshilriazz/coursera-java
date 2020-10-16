package coursera.course2.week3;

import edu.duke.*;
import java.util.*;

public class LogAnalyzer{
    private ArrayList<LogEntry> logList;

    LogAnalyzer() {
        logList = new ArrayList<LogEntry>();
    }

    public void readFile() {
        FileResource fileResource = new FileResource();
        for (String line : fileResource.lines()) {
            LogEntry entry = WebLogParser.parseEntry(line);
            logList.add(entry);
        }
    }

    public void printAll() {
        for (LogEntry le : logList) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs() {
        Set<String> setOfIPAddresses = new TreeSet<>();
        for(LogEntry logEntry : logList) {
            String ip = logEntry.getIpAddress();
            setOfIPAddresses.add(ip);
        }
        return setOfIPAddresses.size();
    }

    public void printAllHigherThanNum(int num) {
        for(LogEntry logEntry : logList) {
            if(logEntry.getStatusCode() > num) {
                System.out.println(logEntry);
            }
        }
    }

    public int countUniqueIPsInRange(int low, int high) {
        int count = 0;
        Set<String> IpAddressSet = new TreeSet<>();
        for(LogEntry logEntry : logList) {
            int statusCode = logEntry.getStatusCode();
            if(statusCode >= low && statusCode <= high) {
                if(!IpAddressSet.contains(logEntry.getIpAddress())) {
                    count++;
                    IpAddressSet.add(logEntry.getIpAddress());
                }
            }
        }
        return count;
    }

    public Map<String, Integer> countVisitsPerIP() {
        Map<String, Integer> records = new HashMap<>();
        for(LogEntry logEntry : logList) {
            String ip = logEntry.getIpAddress();
            int count = 0;
            if(records.containsKey(ip)) {
                records.put(ip, records.get(ip) + 1);
            }
            else {
                records.put(ip, 1);
            }
        }
        return records;
    }

    public int mostNumberVisitsByIP(Map<String, Integer> records) {
        int max = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> record : records.entrySet()) {
            max = Math.max(record.getValue(), max);
        }
        return max;
    }

    public List<String> iPsMostVisits(Map<String, Integer> records) {
        List<String> ips = new ArrayList<>();
        int max = mostNumberVisitsByIP(records);
        for(Map.Entry<String, Integer> record : records.entrySet()) {
            if(record.getValue() == max) {
                ips.add(record.getKey());
            }
        }
        return ips;
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.testLogAnalyzer();
    }

}
