import java.util.Arrays;

public class Anagram {

    /*
        The 'a' in each statement is used to get the index of a character in an array.
        In Java (and many other programming languages), characters are represented by numerical values. For example, in the ASCII or Unicode character sets, the lowercase letters 'a' through 'z' are assigned consecutive integer values.
            'a' has a value (e.g., 97)
            'b' has a value (e.g., 98)
            'c' has a value (e.g., 99)
        When you subtract the character 'a' from another lowercase character, you are essentially performing a subtraction on their numerical values.
        For example, to find the index for the character 'c':
            'c' - 'a'
        This calculates 99 - 97, which equals 2.
        This result, 2, corresponds to the index of 'c' in a zero-indexed array where 'a' is at index 0, 'b' is at index 1, and so on.
        The - 'a' is a concise way to map any lowercase character to an index from 0 to 25. This makes it easy to use a fixed-size array (like int[26]) to keep track of the frequency of each letter of the alphabet.
     */
    public static int anagram(String s) {

        if (s.length() % 2 != 0) {
            //is odd so return -1
            return -1;
        }

        int result = 0;

        int halfLength = s.length() / 2;
        String s1 = s.substring(0, halfLength);
        String s2 = s.substring(halfLength);

        // Assuming only lowercase English letters
        int[] charCount = new int[26];

        for (int i = 0; i < halfLength; i++) {
            charCount[s1.charAt(i) - 'a']++;
        }
        //Arrays.stream(charCount).forEach(System.out::println);

        for (int i = 0; i < halfLength; i++) {

            int index = s2.charAt(i) - 'a';
            if(charCount[index]>0){
                charCount[index]--;
            }else {
                result++;
            }

        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(anagram("abcdjfgcdj"));
    }
}
