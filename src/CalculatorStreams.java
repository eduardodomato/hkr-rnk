import java.util.List;
import java.util.Map;
import java.util.stream.Collectors; // Important for Collectors

/*
 Compute Average Salary by Department using Java Streams
*/

//USES WORKER FROM THE OTHER CLASS
public class CalculatorStreams  {
    public Map<Integer, Double> calculateAverageByDepartments(List<Worker> workers) {
        if (workers == null || workers.isEmpty()) {
            return new java.util.HashMap<>(); // Return an empty map if no workers
        }

        return workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::getDepartmentId, // Group by department ID
                        Collectors.averagingDouble(Worker::getSalary) // Calculate the average salary for each group
                ));
    }

    // Optional: Add a main method for testing
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Worker> workers = new java.util.ArrayList<>();
        workers.add(new Worker("Alice", 101, 60000));
        workers.add(new Worker("Bob", 102, 75000));
        workers.add(new Worker("Charlie", 101, 65000));
        workers.add(new Worker("David", 103, 80000));
        workers.add(new Worker("Eve", 102, 70000));
        workers.add(new Worker("Frank", 101, 70000));
        workers.add(new Worker("Grace", 103, 90000));

        Map<Integer, Double> averageSalaries = calculator.calculateAverageByDepartments(workers);

        System.out.println("Average Salaries by Department (using Streams):");
        for (Map.Entry<Integer, Double> entry : averageSalaries.entrySet()) {
            System.out.printf("Department %d: %.2f%n", entry.getKey(), entry.getValue());
        }

        // Test with an empty list
        List<Worker> noWorkers = new java.util.ArrayList<>();
        Map<Integer, Double> noAverageSalaries = calculator.calculateAverageByDepartments(noWorkers);
        System.out.println("\nAverage Salaries for no workers: " + noAverageSalaries); // Should be empty map

        // Test with a department having only one worker
        List<Worker> singleWorkerDept = new java.util.ArrayList<>();
        singleWorkerDept.add(new Worker("Solo", 200, 50000));
        Map<Integer, Double> singleAverage = calculator.calculateAverageByDepartments(singleWorkerDept);
        System.out.println("\nAverage Salaries for single worker dept: " + singleAverage); // Should be {200=50000.0}
    }
}
