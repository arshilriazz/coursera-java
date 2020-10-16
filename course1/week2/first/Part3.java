package coursera.course1.week2.first;

public class Part3 {
    public boolean towOccurrences(String stringa, String stringb) {
        int count = 0;
        String[] stringsb = stringb.split(" ");
        for(String string : stringsb) {
            count += noOfOccurrences(stringa, string);
        }
        if(count < 2) return false;
        return true;
    }
    public static int noOfOccurrences(String str1, String str2) {
        int count = 0;
        if(str2.indexOf(str1) != -1) {
            int i = str2.indexOf(str1);
            count++;
            while(i < str2.length()) {
                if(str2.indexOf(str1, i + str1.length()) != -1) {
                    count++;
                    i += str2.indexOf(str1, i + str1.length());
                }
                else break;
            }
        }
        return count;
    }
}
