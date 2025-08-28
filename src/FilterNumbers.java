import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class FilterNumbers {

    public static int[] findEvenNumbers(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr1) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }
        for (int num : arr2) {
            if (num % 2 == 0) {
                result.add(num);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)   //conversion needed to get back from Integer to int
                .toArray();
    }

    public static int[] findEvenNumbersStream(int[] arr1, int[] arr2) {

        IntPredicate isEvenPredicate = (num) -> num % 2 == 0;

        return Stream.of(arr1,arr2) //here we have a stream of arrays
                .flatMapToInt(Arrays::stream) //here we flatern to a stream of ints
                .filter(isEvenPredicate) //now we can filter the only valid ones
                .toArray(); //as internally have primitive int don't need conversion

    }

    public static int[] findOddNumbers(int[] arr1, int[] arr2) {
        IntPredicate isOddPredicate = (num) -> num % 2 != 0;

        return Stream.of(arr1,arr2) //here we have a stream of arrays
                .flatMapToInt(Arrays::stream) //here we flatern to a stream of ints
                .filter(isOddPredicate) //now we can filter the only valid ones
                .toArray(); //as internally have primitive int don't need conversion

    }

    public static void main(String[] args) {
        int[] arrOne = {-9, 3, 2, -8, 12, -16};
        int[] arrTwo = {0, 3, -8, -35, 40, 20, 7};

        Arrays.stream(findEvenNumbers(arrOne, arrTwo)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(findEvenNumbersStream(arrOne, arrTwo)).forEach(System.out::print);
        System.out.println();
        Arrays.stream(findOddNumbers(arrOne, arrTwo)).forEach(System.out::print);

    }

}
