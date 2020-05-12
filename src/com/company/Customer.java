package com.company;

import java.util.ArrayList;

public class Customer {

    private String name;
    private int id;
    private static int id_tracker;
    private String town;
    private ArrayList<Order> orderHistory;


    public Customer(String name, String town) {
        this.town = town;
        this.name = name;
        this.id = id_tracker;
        id_tracker++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }



}
