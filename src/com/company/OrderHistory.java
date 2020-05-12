package com.company;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderHistory {

    private static ObservableList<Order> orders;

    public static void addOrder(Order order) {
        OrderHistory.orders.add(order);
    }

}
