import java.util.*;

public class TwoArrays {

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        // Write your code here
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(2, 1, 3);
        List<Integer> B = Arrays.asList(7, 8, 9);
        int k = 10;
        System.out.println(twoArrays(k, A, B)); // Output: YES
    }

}
