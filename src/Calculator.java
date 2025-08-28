import java.util.*;

/*
 Compute Average Salary by Department
*/

class Worker {
    String name;
    int departmentId;
    double salary;

    public Worker(String name, int departmentId, double salary) {
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }
}

//for each department I need total of workers and total of salaries

public class Calculator {
    public Map<Integer, Double> calculateAverageByDepartments(List<Worker> workers) {
        // Map to store total salary per department
        Map<Integer, Double> departmentTotalSalaries = new HashMap<>();
        // Map to store worker count per department
        Map<Integer, Integer> departmentWorkerCounts = new HashMap<>();
        // Map to store the final average salary per department
        Map<Integer, Double> departmentAverageSalaries = new HashMap<>();

        // First pass: Iterate through the workers to aggregate total salaries and counts
        for (Worker worker : workers) {
            int departmentId = worker.getDepartmentId();
            double salary = worker.getSalary();

            // Update total salary for the department
            departmentTotalSalaries.put(departmentId,
                    departmentTotalSalaries.getOrDefault(departmentId, 0.0) + salary);

            // Update worker count for the department
            departmentWorkerCounts.put(departmentId,
                    departmentWorkerCounts.getOrDefault(departmentId, 0) + 1);
        }

        // Second pass: Calculate the average for each department
        for (Map.Entry<Integer, Double> entry : departmentTotalSalaries.entrySet()) {
            int departmentId = entry.getKey();
            double totalSalary = entry.getValue();
            int workerCount = departmentWorkerCounts.get(departmentId);

            if (workerCount > 0) { // Avoid division by zero in case of an empty department (though unlikely with this logic)
                double averageSalary = totalSalary / workerCount;
                departmentAverageSalaries.put(departmentId, averageSalary);
            }
        }

        return departmentAverageSalaries;
    }

    // Optional: Add a main method for testing
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Alice", 101, 60000));
        workers.add(new Worker("Bob", 102, 75000));
        workers.add(new Worker("Charlie", 101, 65000));
        workers.add(new Worker("David", 103, 80000));
        workers.add(new Worker("Eve", 102, 70000));
        workers.add(new Worker("Frank", 101, 70000));
        workers.add(new Worker("Grace", 103, 90000));

        Map<Integer, Double> averageSalaries = calculator.calculateAverageByDepartments(workers);

        System.out.println("Average Salaries by Department:");
        for (Map.Entry<Integer, Double> entry : averageSalaries.entrySet()) {
            System.out.printf("Department %d: %.2f%n", entry.getKey(), entry.getValue());
        }

        // Test with an empty list
        List<Worker> noWorkers = new ArrayList<>();
        Map<Integer, Double> noAverageSalaries = calculator.calculateAverageByDepartments(noWorkers);
        System.out.println("\nAverage Salaries for no workers: " + noAverageSalaries); // Should be empty map

        // Test with a department having only one worker
        List<Worker> singleWorkerDept = new ArrayList<>();
        singleWorkerDept.add(new Worker("Solo", 200, 50000));
        Map<Integer, Double> singleAverage = calculator.calculateAverageByDepartments(singleWorkerDept);
        System.out.println("\nAverage Salaries for single worker dept: " + singleAverage); // Should be {200=50000.0}
    }
}
