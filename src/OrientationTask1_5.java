public class OrientationTask1_5 {
    public static void main(String[] args) {
        ServicePoint checkout = new ServicePoint();
        CustomerGenerator gen = new CustomerGenerator();

        gen.createCustomers(checkout, 4);
        checkout.serve();
    }
}