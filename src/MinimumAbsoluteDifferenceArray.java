import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MinimumAbsoluteDifferenceArray {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        arr.sort(Comparator.naturalOrder());
        /*System.out.println("-----");
        arr.forEach(System.out::println);
        System.out.println("-----");
        IntStream.range(0, arr.size()-1).forEach(System.out::print);
        System.out.println("-----");
        IntStream.range(0, arr.size()-1).map(i->(arr.get(i+1))-arr.get(i)).forEach(System.out::print);
        System.out.println("-----");
        IntStream.range(0, arr.size()-1).map(i->Math.abs(arr.get(i)-arr.get(i+1))).forEach(System.out::print);
        System.out.println("-----");*/

        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int diff = arr.get(i) - arr.get(i - 1);
            if (diff < minAbsDiff) {
                minAbsDiff = diff;
            }
            if (minAbsDiff == 0) break; // Early exit if zero found
        }
        return minAbsDiff;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(Arrays.asList(2, -2, 8, 4, -3)));

    }


}
