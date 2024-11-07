import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final int maxCapacity;
    private final Queue<Integer> buffer;

    public Buffer(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.buffer = new LinkedList<>();
    }

    public synchronized void produce(int item, int id) throws InterruptedException {
        while (buffer.size() == maxCapacity) {
            wait();
            System.out.println("\u001B[34mBuffer is full. Producer " + id + " is waiting." + "\u001B[0m");
        }
        buffer.add(item);
        notifyAll();
    }

    public synchronized int consume(int id) throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
            System.out.println("\u001B[33mBuffer is empty. Consumer " + id + " is waiting." + "\u001B[0m");
        }
        int item = buffer.poll();
        notifyAll();
        return item;
    }
}