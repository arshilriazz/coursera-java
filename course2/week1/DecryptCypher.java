package coursera.course2.week1;

public class DecryptCypher {
    public void printDeCyphered(String encryptedString) {
        CaesarCypher caesarCypher = new CaesarCypher();
        for(int i = 0; i < 25; i++) {
            String answer = caesarCypher.encrypt(encryptedString, i);
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        DecryptCypher decryptCypher = new DecryptCypher();
        decryptCypher.printDeCyphered("CFOPQ, IBDFLK XQQXZH BXPQ CIXKH!");
    }
}
