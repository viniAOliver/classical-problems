
public class Consumer implements Runnable {
    private final Buffer buffer;
    private final int id;

    public Consumer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = buffer.consume(id);
                System.out.println("\u001B[31mConsumer " + id + " consumed: " + item + "\u001B[0m");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
