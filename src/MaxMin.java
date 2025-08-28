import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        arr.sort(Comparator.naturalOrder());
        Integer min = Integer.MAX_VALUE;
        for (int i=0; i<= arr.size() - k; i++){
            int diff=arr.get(i+k-1)-arr.get(i);
            if(diff<min){
                min=diff;
            }

        }
        return min;
    }

    public static void main(String[] args) {

    }
}
