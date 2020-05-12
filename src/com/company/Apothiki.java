package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Apothiki {


    private static HashMap<Integer, Ingredient> stock = new HashMap<>();

    public static void addIngredient(Ingredient ingredient) {
        stock.put(ingredient.getId(), ingredient);
    }

    public static void removeIngredient(Ingredient ingredient) {
        stock.remove(ingredient.getId());
    }

//    reducing the quantity of a given ingredient which is used
    public static void useIngredient(int id, int quantity) {
        Ingredient ing = stock.get(id);
        ing.reduceQuantity(quantity);
    }

//    public static void ????? (Item item) {
//        HashMap<Integer, Integer> quantities = item.getQuantities();
//        Set keys = quantities.keySet();
//        Iterator ingredients = keys.iterator();
//        while (ingredients.hasNext()) {
//            int id = ingredients.next();

    public static HashMap<Integer, Ingredient> getStock() {
        return stock;
    }
//            Apothiki.useIngredient();
//        }
//    }

    public static void useItemIngredients(Item item) {
        HashMap<Integer, Integer> quantities = item.getQuantities();
        for(Map.Entry<Integer, Integer> map : quantities.entrySet()) {
            int key = map.getKey();
            int value = map.getValue();
            Apothiki.useIngredient(key, value);
        }
    }

//  epistrefei posa item mporun na ginun me ta ingredients pou exume stin apothiki
    public static int checkItemIngredients(Item item) {
        HashMap<Integer, Integer> quantities = item.getQuantities();
        for(Map.Entry<Integer, Integer> map : quantities.entrySet()) {
            int key = map.getKey();
            int value = map.getValue();

        }
        return 0; //prosorino to avoid errors
    }



//     find an ingredient given the id and returned
    public static Ingredient findIngredient (int id) {
        return (Ingredient) stock.get(id);
    }

    public static void printIngredients() {
        Set menuItemsSet = stock.keySet();
        Iterator myIter = menuItemsSet.iterator();
        System.out.println("STOCK WITH INGREDIENTS LIST");
        while(myIter.hasNext()) {
            Ingredient obj = stock.get(myIter.next());
            System.out.println(obj);
        }
    }

    public static int findIngredient(String name){
        Set ingredientsKeySet = stock.keySet();
        Iterator iterator = ingredientsKeySet.iterator();
        Ingredient ing;
        while(iterator.hasNext()) {
            ing = stock.get(iterator.next());
            if(name.equals(ing.getName())){
                return ing.getId();
            }
        }
        return -1;
    }

    public static void gemiseApothiki(){
        Ingredient ing = new Ingredient ("tomatoes", 100);
        Apothiki.addIngredient(ing);
        ing = new Ingredient("cucumbers", 50);
        Apothiki.addIngredient(ing);
        ing = new Ingredient("pork", 50);
        Apothiki.addIngredient(ing);

    }

    public static void createIngredients() {
        Ingredient ing = new Ingredient ("tomatoes", 100000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("cucumbers", 50000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("pork", 50000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient ("maitanos", 300); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("chicken", 50000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("sieftalia", 100); //kommatia
        Apothiki.addIngredient(ing);
        ing = new Ingredient("potatoes", 40000); //gramaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("kremidi", 10000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("pitta", 100); //kommatia
        Apothiki.addIngredient(ing);
        ing = new Ingredient("tzatziki", 3000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("beef", 10000); //gramaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("taxini", 3000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("pikla", 3000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("ketchup", 3000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("mayonaise", 3000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("xalloumi", 1000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("manitarakia", 10000); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("marouli", 100); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("selino", 100); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("koliantros", 100); //grammaria
        Apothiki.addIngredient(ing);
        ing = new Ingredient("krampi", 100); //grammaria
        Apothiki.addIngredient(ing);
    }

    public static void main(String[] args) {
        Apothiki.gemiseApothiki();
        Apothiki.printIngredients();
    }
}
