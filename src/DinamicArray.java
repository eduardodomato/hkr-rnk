import java.util.ArrayList;
import java.util.List;

public class DinamicArray {



    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> seqList = new ArrayList<>();
        int lastAnswer = 0;
        for (int i = 0; i < n; i++) {

            seqList.add(new ArrayList<>());

        }

        List<Integer> result = new ArrayList<>();

        for (List<Integer> q : queries) {
            int index = (q.get(1) ^ lastAnswer) % n;
            int y = q.get(2);

            switch (q.get(0)) {
                case 1:
                    seqList.get(index).add(y);
                    break;
                case 2:
                    int size = seqList.get(index).size();
                    lastAnswer = seqList.get(index).get(y % size);
                    result.add(lastAnswer);
                    break;
            }

        }
        return result;

    }


//    public static int[] dynamicArray(int n, int[][] queries) {
//        // Write your code here
//
//    }

}
