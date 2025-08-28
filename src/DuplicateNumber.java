import java.util.Arrays;
import java.util.stream.IntStream;

public class DuplicateNumber {

    public static int[] removeDuplicates(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (arr.length == 1) {
            return arr;
        }
        //by the case that all elements are unique
        int[] uniqueArray = new int[arr.length];
        int uniqueIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean isDup = false;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    isDup = true;
                    break;
                }
            }
            if (!isDup) {
                uniqueArray[uniqueIndex++] = arr[i];
            }
        }
        return Arrays.copyOf(uniqueArray, uniqueIndex);
    }

    public static int[] removeDuplicatesStream(int[] arr) {
        return IntStream.of(arr).distinct().toArray();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatesStream(new int[0]));
    }

}
