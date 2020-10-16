package coursera.course1.week2.second;

public class Part2 {
    public static int howMany(String str1, String str2) {
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

    public static void main(String[] args) {
        System.out.println(howMany("AA", "ATAAAA"));
    }
}
