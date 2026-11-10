package simu.model;

import java.util.LinkedList;

import simu.framework.Clock;

public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();

    public void addToQueue(Customer customer) {
        queue.add(customer);
    }

    public Customer removeFromQueue() {
        Customer customer = queue.poll();
        customer.setRemovalTime(Clock.getInstance().getTime());
        return customer;
    }

    public boolean hasCustomers() {
        return !queue.isEmpty();
    }
}