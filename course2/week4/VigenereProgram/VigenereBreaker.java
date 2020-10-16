package coursera.course2.week4.VigenereProgram;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder string = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i += totalSlices){
            string.append(message.charAt(i));
        }
        return string.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker ccr = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++){
            String s = sliceString(encrypted, i, klength);
            int a = ccr.getKey(s);
            key[i] = a;
        }
        return key;
    }

    public void breakVigenere (int keyLength) {
//        FileResource fr = new FileResource();
//        String s = fr.asString();
        String s = "Dqf, axa jjbl";
        int[] key = tryKeyLength(s, keyLength, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        String msg = vc.decrypt(s);
        System.out.println(msg);
    }

    public static void main(String[] args) {
        VigenereBreaker vigenereBreaker = new VigenereBreaker();
//        int[] array = vigenereBreaker.tryKeyLength("Heerhefe",3,'e');
//        for(int x : array) {
//            System.out.print(x + " ");
//        }
//        vigenereBreaker.breakVigenere(3);
//        String s = vigenereBreaker.sliceString("Dqf, axa jjbl", 0, 4);
//        System.out.println(s);
        vigenereBreaker.breakVigenere(4);
    }
}
