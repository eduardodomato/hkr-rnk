import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class PickingNumbers {

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here

        int maxValue = a.isEmpty() ? 0 : Collections.max(a);
        int[] freq = new int[maxValue + 2];

        a.forEach(num -> freq[num]++);

        return IntStream.range(0, freq.length - 1)
                .map(i -> freq[i] + freq[i + 1])
                .max()
                .orElse(0);


    }
}
