import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SockMerchant {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        return ar.stream().collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .mapToInt(socks->(int) (socks/2))
                .sum();

    }

    public static void main(String[] args) {

        List<Integer> socks = Arrays.asList(1, 1, 3, 4, 4, 2, 2, 2);
        int pairs = sockMerchant(socks.size(), socks);
        System.out.println(pairs);
    }

}
