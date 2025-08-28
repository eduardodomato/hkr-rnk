import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeftRotation {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here

        if(arr.size()==1)
            return arr;

        List<Integer> sub = new ArrayList<>(arr.subList(0, d));

        arr.subList(0, d).clear();
        arr.addAll(sub);
        return arr;


    }
}
