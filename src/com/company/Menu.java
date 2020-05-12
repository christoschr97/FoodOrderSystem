package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Menu {

//    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<Integer, Item> menu = new HashMap<>();

    public static void addMenuItem(Item item) {
        menu.put(item.getId(), item);
    }

    public static void removeMenuItem(Item item) {
        menu.remove(item.getId());
    }

//  tipwnei ola ta items pou einai sto menu
    public static void printMenuItems() {
        Set menuItemsSet = menu.keySet();
        Iterator myIter = menuItemsSet.iterator();
        System.out.println("MENU ITEMS LIST");
        while(myIter.hasNext()) {
            Item obj = menu.get(myIter.next());
            System.out.println(obj);
        }
    }

    public static HashMap<Integer, Item> getMenu() {
        return menu;
    }

    //  return the item with specific id given
    public static Item findItem(int id) {
        return menu.get(id);
    }


    public static void createItems() {

        Item item = new Item(5, "pitta souvlaki xoirino", 5, 5);
        Menu.addMenuItem(item);

        item = new Item(4.5, "pitta souvlaki kotopoulo", 5, 6);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta sieftalia", 10, 10);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta mix", 10, 10);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta xalloumi", 10, 10);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta manitarakia", 10, 10);
        Menu.addMenuItem(item);

        item = new Item(5, "pitta souvlaki xoirino enisximeni", 5, 5);
        Menu.addMenuItem(item);

        item = new Item(4.5, "pitta souvlaki kotopoulo enisximeni", 5, 6);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta sieftalia enisximeni", 10, 10);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta mix enisximeni", 10, 10);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta xalloumi enisximeni", 10, 10);
        Menu.addMenuItem(item);

        item = new Item(8.5, "pitta manitarakia enisximeni", 10, 10);
        Menu.addMenuItem(item);
    }
}
