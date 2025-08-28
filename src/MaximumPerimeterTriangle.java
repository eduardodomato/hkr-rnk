import java.util.Comparator;
import java.util.List;

public class MaximumPerimeterTriangle {


    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        // Write your code here
        sticks.sort(Comparator.reverseOrder());
        int i = 0;
        while (i <= sticks.size() - 3 && sticks.get(i + 2) + sticks.get(i + 1) <= sticks.get(i)) {
            i++;
        }
        if (i <= sticks.size() - 3) {
            return List.of(sticks.get(i + 2), sticks.get(i + 1), sticks.get(i));
        } else {
            return List.of(-1);
        }
    }

    public static List<Integer> maximumPerimeterTriangle2(List<Integer> sticks) {
        // Write your code here
        sticks.sort(Comparator.naturalOrder());
        int i = sticks.size() - 3;
        while (i > 0 && sticks.get(i) + sticks.get(i + 1) <= sticks.get(i+2)) {
            i--;
        }
        if (i >= 0 && sticks.get(i) + sticks.get(i + 1) > sticks.get(i+2)) {
            return List.of(sticks.get(i), sticks.get(i + 1), sticks.get(i+2));
        } else {
            return List.of(-1);
        }
    }

    public static void main(String[] args) {

    }
}
