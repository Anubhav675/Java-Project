import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();

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

            c.setEndTime(System.currentTimeMillis());
            System.out.println("Customer " + c.getId()+ ": service time " + sleeptime + " ms"+ ", response time " + c.getTimeSpent() + " ms");
        }
    }
}