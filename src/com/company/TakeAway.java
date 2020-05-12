package com.company;

import java.util.HashMap;

public class TakeAway {

    private String name;
    private HashMap<Integer, Order> orders;

    public TakeAway(String name) {
        this.name = name;
        this.orders = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderID(), order);
    }

    public void removeOrder(Order order) {
        orders.remove(order.getOrderID());
    }



}
