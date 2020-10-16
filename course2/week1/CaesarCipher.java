package coursera.course2.week1;

public class CaesarCipher {
    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private int key = 0;

    public CaesarCipher(int key) {
        this.key = key;
    }

    public void appendLetterForCypher(StringBuilder encryptedString, char letter) {
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

    public String encrypt(String stringToEncrypt) {
        StringBuilder encryptedString = new StringBuilder();

        for(int i = 0; i < stringToEncrypt.length(); i++) {
            char letter = stringToEncrypt.charAt(i);
            appendLetterForCypher(encryptedString, letter);
        }
        return encryptedString.toString();
    }
}
