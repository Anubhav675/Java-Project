public class ClockTest {
    public static void main(String[] args) {
        Clock clock1 = Clock.getInstance();
        Clock clock2 = Clock.getInstance();

        System.out.println("Same object? " + (clock1 == clock2));
        System.out.println("Initial time: " + clock1.getTime());

        clock1.setTime(12.5);
        System.out.println("clock1 time = " + clock1.getTime());
        System.out.println("clock2 time = " + clock2.getTime());

        clock2.setTime(20);
        System.out.println("clock1 time = " + clock1.getTime());
    }
}