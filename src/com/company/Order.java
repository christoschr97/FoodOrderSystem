package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Order {
    private int orderID;
    private static int orderID_tracker = 1;
    private int customerID;
    private int itemCounter; //variable to track the items are being added in the collection
    HashMap<Integer, OrderItem> orderItems;

    public Order(int customerID) {
        this.orderID = orderID_tracker;
        orderID_tracker++;
        this.customerID = customerID;
        this.orderItems = new HashMap<>(5);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", itemCounter=" + itemCounter +
                ", orderItems=" + orderItems +
                '}';
    }

    public int getOrderID(){
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public HashMap<Integer, OrderItem> getOrderItems() {
        return orderItems;
    }

    //  adding
    //  orderItem and increase the counter of the itemCounter tracker
    public void addOrderItem(OrderItem orderItem) {
        orderItems.put(this.itemCounter, orderItem);
        this.itemCounter++;
    }

    public void removeOrderItem(int itemCounter) {
        orderItems.remove(itemCounter);
    }

    //  method to print the items in order
    public void printOrderItems() {
        System.out.println("ORDER WITH ID " + this.getOrderID() + " CREATED SUCCESSFULLY");
        System.out.println("THE ITEMS ARE:");
        Set orderItemsSet = orderItems.keySet();
        Iterator myIter = orderItemsSet.iterator();
        int counter = 1;
        while(myIter.hasNext()){
            OrderItem obj = orderItems.get(myIter.next());
            System.out.println(counter + " " + obj);
            counter++;
        }
    }

}

