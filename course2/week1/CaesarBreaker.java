package coursera.course2.week1;

public class CaesarBreaker {

    public int[] countLetters(String message) {
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            counts[(int)(ch - 'a')]++;
        }
        return counts;
    }

    public int maxIndex(int[] values) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                index = i;
            }
        }
        return index;
    }

    public String halfOfString(String message, int start) {
        StringBuilder answer = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            answer.append(message.charAt(i));
        }
        return answer.toString();
    }

    public int getKey(String message) {
        int[] letterFrequencies = countLetters(message);
        int maxDex = maxIndex(letterFrequencies);
        int decryptKey = (26 - (4 - maxDex)) % 26;
        return decryptKey;
    }

    public String decryptTwoKeys(String encrypted) {
        CaesarCypher caesarCypher = new CaesarCypher();
        String firstMessage = halfOfString(encrypted, 0);
        String secondMessage = halfOfString(encrypted, 1);
        int key1 = getKey(firstMessage);
        int key2 = getKey(secondMessage);
        System.out.println("The two keys are " + key1 + " " + key2);
        return caesarCypher.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
    }

    public void testDecrypt() {
        System.out.println(decryptTwoKeys("hiumh"));
    }

    public static void main(String[] args) {
        CaesarBreaker caesarBreaker = new CaesarBreaker();
        caesarBreaker.testDecrypt();
    }
}