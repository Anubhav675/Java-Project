public class OrientationTask1_6 {
    public static void main(String[] args) {
        CustomerGenerator gen = new CustomerGenerator();
        int[] sizes = {2, 3, 2};

        for (int i = 0; i < sizes.length; i++) {
            System.out.println("Run " + (i + 1) + " (" + sizes[i] + " customers)");

            ServicePoint checkout = new ServicePoint();
            gen.createCustomers(checkout, sizes[i]);
            checkout.serve();

//            System.out.printf("Average service time: %.2f ms%n", checkout.getAverageServiceTime());
            System.out.println();
        }
    }
}