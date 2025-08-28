import java.util.Arrays;
import java.util.Collections;

public class CaesarCipher {

    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String caesarCipher(String s, int k) {
        char[] source = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char element : source) {

            if (Character.isLetter(element)) {

                boolean isUpper = Character.isUpperCase(element);
                char baseChar = Character.toLowerCase(element);

                char shifted = caesarsSwap(Character.toString(baseChar), k);

                result.append(isUpper ? Character.toUpperCase(shifted) : shifted);
            } else {
                result.append(element);
            }
        }

        return result.toString();

    }

    public static String caesarCipherStream(String s, int k) {

        StringBuilder result = new StringBuilder();
        s.chars().mapToObj(c -> (char) c).map(element -> caesarShift(element, k)).forEach(e -> result.append(e));
        return result.toString();

    }

    //Formula X= (i+k)%26
    public static char caesarsSwap(String e, int k) {
        int index = alphabet.indexOf(e);
        return alphabet.charAt((index + k) % 26);
    }

    public static Character caesarShift(char element, int k) {
        if (Character.isLetter(element)) {

            boolean isUpper = Character.isUpperCase(element);
            char baseChar = Character.toLowerCase(element);

            char shifted = alphabet.charAt((alphabet.indexOf(element) + k) % 26);

            return isUpper ? Character.toUpperCase(shifted) : shifted;
        } else {
            return element;
        }
    }


    public static void main(String[] args) {
        String input = "Abc XyZ!";
        int shift = 3;
        String output = caesarCipher(input, shift);
        System.out.println(output); // Expected: Def AbC!
    }

}
