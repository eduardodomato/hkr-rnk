import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadMain {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        //Find letter
        char character = JOptionPane.showInputDialog("Ingresa una letra").charAt(0);
        AtomicBoolean found = new AtomicBoolean(false);

        Runnable thread1 = () -> {
            try {
                Thread.currentThread().setName("Thread-Character");
                for (char i = 'A'; i <= character; i++) {

                    Thread.sleep(500);
                    System.out.print(i);

                    if (i == character) {
                        found.set(true);
                        System.out.println("Letra " + i + " encontrada.");
                        System.out.println("Trabajo del hilo " + Thread.currentThread().getName()
                                + " terminado.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        };

        int number = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero"));
        AtomicInteger atomicInteger = new AtomicInteger(number);

        Runnable thread2 = () -> {
            Thread.currentThread().setName("Thread-Number");

            try {
                while (found.get() == false) {
                    Thread.sleep(600);
                    System.out.println(atomicInteger.getAndDecrement());
                }
                System.out.println("Trabajo del hilo " + Thread.currentThread().getName()
                        + " terminado.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        };

        executor.submit(thread1);
        executor.submit(thread2);
        executor.awaitTermination(30, TimeUnit.SECONDS);
        executor.shutdown();

    }

}
