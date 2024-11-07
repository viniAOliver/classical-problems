
public class Producer implements Runnable {
    private final Buffer buffer;
    private final int id;

    public Producer(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            int item = 0;
            while (true) {
                buffer.produce(item, id);
                System.out.println("\u001B[32mProducer " + id + " produced: " + item + "\u001B[0m");
                item++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
