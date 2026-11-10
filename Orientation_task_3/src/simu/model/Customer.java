package simu.model;

public class Customer {
    private double arrivalTime;
    private double removalTime;

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setRemovalTime(double removalTime) {
        this.removalTime = removalTime;
    }

    public double getTimeInSystem() {
        return removalTime - arrivalTime;
    }

    public void report() {
        System.out.printf("Arrived %8.2f, left %8.2f, time in system %8.2f%n", arrivalTime, removalTime, getTimeInSystem());
    }
}