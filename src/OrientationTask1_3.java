public class OrientationTask1_3 {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();

        c1.setStartTime(10);
        c1.setEndTime(25);

        c2.setStartTime(12);
        c2.setEndTime(40);

        c3.setStartTime(System.currentTimeMillis());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c3.setEndTime(System.currentTimeMillis());

        System.out.println("Customer " + c1.getId() + ": time spent = " + c1.getTimeSpent()+ " ms");
        System.out.println("Customer " + c2.getId() + ": time spent = " + c2.getTimeSpent()+ " ms");
        System.out.println("Customer " + c3.getId() + ": time spent = " + c3.getTimeSpent() + " ms");
    }
}