import java.util.*;
import java.util.stream.Collectors;

public class MigrationBirds {

    public static int migratoryBirds(List<Integer> arr) {
        // Group by bird type and count occurrences
        Set<String> a = new HashSet<>();

        Map<Integer, Long> birdCounts = arr.stream()
                .collect(Collectors.groupingBy(x->x , Collectors.counting()));

        System.out.println(birdCounts.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)));
        // Find the bird type with the maximum count
        return birdCounts.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(-1); // Return -1 if the list is empty

    }
    public static void main(String[] args) {
        // Happy path test: most frequent bird is 1
        int result = MigrationBirds.migratoryBirds(Arrays.asList( 2, 2, 1, 1,3));
        if (result == 1) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed. Expected 1, got " + result);
        }
    }
}
