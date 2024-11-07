import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Instantiate a scanner object with try-with-resources statement to
        // automatically close it
        try (Scanner scanner = new Scanner(System.in)) {

            // Getting the buffer size from the user
            System.out.println("Hello world!\nDigite o tamanho do buffer: ");
            int maxCapacity = scanner.nextInt();

            // Getting the number of producers from the user
            System.out.println("Digite o número de produtores: ");
            int numProducers = scanner.nextInt();

            // Getting the number of consumers from the user
            System.out.println("Digite o número de consumidores: ");
            int numConsumers = scanner.nextInt();

            // Instantiate a buffer object
            Buffer buffer = new Buffer(maxCapacity);

            // Instantiate the producer threads
            for (int i = 0; i < numProducers; i++) {
                new Thread(new Producer(buffer, i)).start();
                System.out.println("Producer " + i + " started.");
            }

            // Instantiate the consumer threads
            for (int i = 0; i < numConsumers; i++) {
                new Thread(new Consumer(buffer, i)).start();
                System.out.println("Consumer " + i + " started.");
            }

        }

    }

}
