import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClosestNumbers {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        arr.sort(Comparator.naturalOrder());
        List<Integer> result = new ArrayList<>();
        int smallestMarker=Integer.MAX_VALUE;

        for (int i = 0 ; i <= arr.size()-2 ; i ++) {
            if(Math.abs(arr.get(i)-arr.get(i+1)) <= smallestMarker){
                if(Math.abs(arr.get(i)-arr.get(i+1)) < smallestMarker){
                    result.clear();
                    smallestMarker=Math.abs(arr.get(i)-arr.get(i+1));
                }
                result.add(arr.get(i));
                result.add(arr.get(i+1));
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }


}
