import java.util.LinkedList;
import java.util.Scanner;

public class OrientationTask1_4 {
    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 = queue a customer, 2 = dequeue a customer, 0 = quit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Customer newCustomer = new Customer();
                    newCustomer.setStartTime(System.nanoTime());
                    queue.addFirst(newCustomer);
                    System.out.println("Customer " + newCustomer.getId()+ " joined the queue. Queue size: " + queue.size());
                    break;

                case "2":
                    if (queue.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        Customer served = queue.removeLast();
                        served.setEndTime(System.nanoTime());
                        long nanos = served.getTimeSpent();
                        System.out.println("Customer " + served.getId() + " left the queue after "+ nanos + " ns (" + nanos / 1_000_000 + " ms). Queue size: "+ queue.size());
                    }
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println("Please type 1, 2 or 0.");
            }
        }

        System.out.println("Customers still in the queue: " + queue.size());
    }
}