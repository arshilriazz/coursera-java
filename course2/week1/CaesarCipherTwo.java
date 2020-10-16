package coursera.course2.week1;

public class CaesarCipherTwo {
    private String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
    private int key1 = 0;
    private int key2 = 0;
    CaesarCipher caesarCipher1 = new CaesarCipher(key1);
    CaesarCipher caesarCipher2 = new CaesarCipher(key2);

    public CaesarCipherTwo(int key1, int key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public String encryptTwoKeys(String stringToEncrypt, int key1, int key2) {
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < stringToEncrypt.length(); i++) {
            char letter = stringToEncrypt.charAt(i);
            if (i % 2 == 0) {
                caesarCipher1.appendLetterForCypher(encryptedString, letter);
            } else {
                caesarCipher2.appendLetterForCypher(encryptedString, letter);
            }
        }
        return encryptedString.toString();
    }
}
