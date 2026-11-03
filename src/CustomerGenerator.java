public class CustomerGenerator {

    public void createCustomers(ServicePoint sp, int n) {
        for (int i = 0; i < n; i++) {
            Customer c = new Customer();
            c.setStartTime(System.currentTimeMillis());
            sp.addToQueue(c);
        }
    }
}