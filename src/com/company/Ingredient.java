package com.company;

public class Ingredient{

    private String name;
    private int quantity; // unit depends on product
    private int id;
    private double cost; // cost per unit
    private static int counter = 1;

    public Ingredient(String name, int quantity) {
        id = counter;
        counter++;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    // elegxei an yparxei i posotita ammount
    public boolean checkQuantity(int amount) {
        if(this.quantity >= amount) {
            return true;
        } else {
            return false;
        }
    }

    public void reStock(int amount) {
        if(amount > 0) {
            this.quantity += amount;
        }
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount; //quantity = quantity - amount
    }

//  to string is going to help us printing the items
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", id=" + id +
                ", cost=" + cost +
                '}';
    }
} //end of class
