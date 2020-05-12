package com.company;

import java.util.HashMap;
public class Item {

    //protected String name;
    private double price, cost;
    private String name;
    private int id;
    private static int counter = 1;
    private int prepTime;
    private int cookTime;

    // maps the ingredient IDs with the quantity required for this Item
    private HashMap<Integer, Integer> quantities;

    public Item(double price, String name) {
        id = counter;
        counter++;
        this.price = price;
        this.name = name;
        this.quantities = new HashMap<>();
    }

    public Item(double price, String name, int prepTime, int cookTime) {
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        id = counter;
        counter++;
        this.price = price;
        this.name = name;
        this.quantities = new HashMap<>();
    }

    public HashMap<Integer, Integer> getQuantities() {
        return quantities;
    }

    //Copy Constructor
    public Item(Item item){
        this.name = item.name;
        this.price = item.price;
        this.prepTime = item.prepTime;
        this.cookTime = item.cookTime;
        this.id = item.id;
        this.quantities = new HashMap<>(item.quantities);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addIngredient (Ingredient ingredient, int quantity) {
        quantities.put(ingredient.getId(), quantity);
    }

//  remove an ingredient given the Ingredient as a parameter
    public void removeIngredient (Ingredient ingredient) {
        quantities.remove(ingredient.getId());
    }

//  change the quantity of an ingredient given the id
    public void changeQuantity(int id, int quantity){
        quantities.replace(id,quantity);
    }

//  find an ingredient given the id as parameter
    public Ingredient findIngredient(int id){
        Ingredient ing = (Ingredient) Apothiki.findIngredient(id);
        return ing;
    }

// toString is just to help us printing the item

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}


