package coursera.course2.week1;

public class CaesarCypher {
    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";

    public void appendLetterForCypher(StringBuilder encryptedString, char letter, int key) {
        if(Character.isUpperCase(letter)) {
            int idx = letter - 'A';
            if(alphabetUpper.indexOf(letter) != -1)
                encryptedString.append(alphabetUpper.charAt((idx+key) % 26));
        }
        else if(Character.isLowerCase(letter)) {
            int idx = letter - 'a';
            if(alphabetLower.indexOf(letter) != -1)
                encryptedString.append(alphabetLower.charAt((idx+key) % 26));
        }
        else {
            encryptedString.append(letter);
        }
    }

    public String encrypt(String stringToEncrypt, int key) {
        StringBuilder encryptedString = new StringBuilder();
        for(int i = 0; i < stringToEncrypt.length(); i++) {
            char letter = stringToEncrypt.charAt(i);
            appendLetterForCypher(encryptedString, letter, key);
        }
        return encryptedString.toString();
    }

    public String encryptTwoKeys(String stringToEncrypt, int key1, int key2) {
        StringBuilder encryptedString = new StringBuilder();
        for(int i = 0; i < stringToEncrypt.length(); i++) {
            char letter = stringToEncrypt.charAt(i);
            if(i % 2 == 0) {
                appendLetterForCypher(encryptedString, letter, key1);
            }
            else {
                appendLetterForCypher(encryptedString, letter, key2);
            }
        }
        return encryptedString.toString();
    }

    public String decrypt(String stringToDecrypt, int key) {
        return encrypt(stringToDecrypt, 26-key);
    }

    public static void main(String[] args) {
        CaesarCypher caesarCypher = new CaesarCypher();
        String ans = caesarCypher.encryptTwoKeys("eerie", 3, 4);
        System.out.println(ans);
    }

}