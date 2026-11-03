import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();

    private long totalTime = 0;
    private int count = 0;

    public void addToQueue(Customer a) {
        queue.addFirst(a);
    }

    public Customer removeFromQueue() {
        return queue.removeLast();
    }

    public void serve() {
        while (!queue.isEmpty()) {
            Customer c = removeFromQueue();

            int sleeptime = (int) (Math.random() * 500) + 100;

            try {
                Thread.sleep(sleeptime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            totalTime = totalTime + sleeptime;
            count++;

            c.setEndTime(System.currentTimeMillis());
            System.out.println("Customer " + c.getId() + ": service time " + sleeptime + " ms" + ", response time " + c.getTimeSpent() + " ms");
        }
    }

    public double getAverageServiceTime() {
        if (count == 0) {
            return 0.0;
        }
        return (double) totalTime / count;
    }
}