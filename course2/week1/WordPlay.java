package coursera.course2.week1;

import java.util.*;

public class WordPlay {
    Character[] arrayOfVowels = new Character[] {'a','e','i','o','u','A','E','I','O','U'};
    List<Character> listOfVowels = Arrays.asList(arrayOfVowels);

    public boolean isVowel(char character) {
        if(listOfVowels.contains(character)) return true;
        return false;
    }

    public String replaceVowels(String string) {
        StringBuilder answer = new StringBuilder();
        for(char character : string.toCharArray()) {
            if(isVowel(character)) answer.append("*");
            else answer.append(character);
        }
        return answer.toString();
    }

    public String emphasize(String string, char ch) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ch) {
                if(i % 2 == 0) answer.append('*');
                else answer.append('+');
            }
            else answer.append(string.charAt(i));
        }
        return answer.toString();
    }
}
