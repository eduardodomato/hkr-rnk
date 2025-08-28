import java.util.*;
import java.util.stream.Collectors;

public class Calculadora {

    public Map<Integer, Double> calculateAverageByDepartments(List<Worker> workers) {

        return workers.stream().collect(Collectors.groupingBy(Worker::getDepartmentId,Collectors.averagingDouble(Worker::getSalary)));

    }

    public static void main(String... args){

        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Alice", 101, 60000));
        workers.add(new Worker("Bob", 102, 75000));
        workers.add(new Worker("Charlie", 101, 65000));
        workers.add(new Worker("David", 103, 80000));
        workers.add(new Worker("Eve", 102, 70000));
        workers.add(new Worker("Frank", 101, 70000));
        workers.add(new Worker("Grace", 103, 90000));

        //Next two are equals, first parameter is always the KEY
        //Second parameter is how you want the VALUE, a LIST of Objects
        System.out.println(workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId)));
        System.out.println(workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId,Collectors.toList())));

        //Second parameter is how you want the VALUE, a SET of Objects
        System.out.println(workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId,Collectors.toSet())));

        //Second parameter is how you want the VALUE, the COUNT of the Objects grouped
        System.out.println(workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId,Collectors.counting())));

        //Second parameter is how you want the VALUE, the Average of the Objects grouped
        //giving a certain getter of the target object
        System.out.println(workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId,Collectors.averagingDouble(Worker::getSalary))));
        //Here defined as Lambdas
        System.out.println(workers.stream()
                .collect(Collectors.groupingBy((w)->w.getDepartmentId(),
                        Collectors.averagingDouble(w->w.getSalary()))));

        System.out.println(workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId,
                        Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparingDouble(Worker::getSalary))
                        , Optional::get
                        ))));

        System.out.println(workers.stream()
                .collect(Collectors.groupingBy(Worker::getDepartmentId,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingDouble(Worker::getSalary))
                                , optionalWorker-> optionalWorker.get().getSalary()
                        ))));

    }
}
