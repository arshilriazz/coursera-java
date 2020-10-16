package coursera.course4;

import java.util.regex.*;

public class Regex {
    public static void main(String[] args) {
//        String regex = ".s.";
        Pattern pattern = Pattern.compile("[A-Z]*[A-Z]*[a-z]+");
        Matcher matcher = pattern.matcher("a Quiet TQuiet");
//        System.out.println(matcher.matches());
        int count = 0;
        while(matcher.find()) {
            System.out.println(matcher.group());
            count++;
        }
        System.out.println(count);
    }
}
