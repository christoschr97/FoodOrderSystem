package com.company;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // call the methods to create the ingredients and the items
        Menu.createItems();
        Apothiki.createIngredients();

        Customer christos = new Customer("Christos", "Limassol");
        boolean quit = false;
        while(!quit) {
            printInstructions();
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch(selection) {
                case 0:
                    System.out.println("SHUTTING DOWN!");
                    quit = true;
                    break;
                case 1:
                    createNewOrder(christos);
                    break;
                case 2:
                    addIngredientToStore();
                    break;
                case 3:

                    break;
                case 4:
                    createMenuItem();
                    break;
                case 5:
                    printStock();
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    addIngredientToItem();
                    break;
                case 8:
                    removeIngredientFromItem();
                    break;
                case 9:
                    printItemIngredients();
                    break;
            }
        }

    }

    //print the instructions to user
    public static void printInstructions() {
        System.out.println("================================================");
        System.out.println("============WELCOME TO CHRISTOS KEBAB===========");
        System.out.println("SELECT ONE OF THE FOLLOWING");
        System.out.println("PRESS 1 --> CREATE NEW ORDER");
        System.out.println("PRESS 2 --> ADD INGREDIENTS TO STORE");
        System.out.println("PRESS 3 --> RESTOCK AN INGREDIENT");
        System.out.println("PRESS 4 --> CREATE AND ADD ITEMS TO MENU");
        System.out.println("PRESS 5 --> PRINT STOCK");
        System.out.println("PRESS 6 --> PRINT MENU");
        System.out.println("PRESS 7 --> ADD INGREDIENTS TO AN ITEM OF THE MENU");
        System.out.println("PRESS 8 --> REMOVE INGREDIENTS OF AN ITEM ON THE MENU");
        System.out.println("PRESS 9 --> PRINT THE INGREDIENTS OF AN ITEM");
        System.out.println("PRESS 0 --> QUIT");
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println();
        System.out.println();
    }

    //create new Ingredient and adding it to Store
    public static void addIngredientToStore() {
        System.out.println("======================================================================");
        System.out.println("Please add the name of the ingredient you want to add");
        String name = scanner.nextLine();
        System.out.println("Please add the initial quantity that you have in the stock");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Apothiki.addIngredient(new Ingredient(name, quantity));
    }

    //printing stock
    public static void printStock() {
        Apothiki.printIngredients();
    }

    //printing menu
    public static void printMenu() {
        Menu.printMenuItems();
    }

    //creating a menu item
    public static void createMenuItem() {
        System.out.println("======================================================================");
        System.out.println("Please add the name of the item you want to add");
        String name = scanner.nextLine();
        System.out.println("Please add the initial price that you have in the stock");
        int price = scanner.nextInt();
        scanner.nextLine();
        Menu.addMenuItem(new Item(price, name)); //using the constructor with no prepTime and cookTime for now
    }

    //addingingredient to an already existed / created item
    public static void addIngredientToItem(){
        System.out.println("======================================================================");
        printMenu();
        System.out.println("Choose the item by id to add ingredients in it or 0 to stop");
        int item = scanner.nextInt(); //holds the id of the item
        scanner.nextLine();
        boolean quit = false;
        while(!quit) {
            printStock();
            System.out.println("Choose the ingredient by id to add in the item OR PRESS 0 TO STOP"); //holding the id of the ingredient
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                break;
            } else {
                System.out.println("Enter the quantity of the ingredient");
                int quantity = scanner.nextInt(); //holds the quantity of the new ingredient
                scanner.nextLine();
                Menu.findItem(item).addIngredient(Apothiki.findIngredient(id), quantity);

            }
        }
    }

    //remove ingredient item from
    public static void removeIngredientFromItem() {
        System.out.println("======================================================================");
        printMenu();
        System.out.println("Choose the item by id to add ingredients in it or 0 to stop");
        int item = scanner.nextInt(); //holds the id of the ingredient
        scanner.nextLine();
        boolean quit = false;
        while(!quit) {
            printStock();
            System.out.println("Choose the ingredient by id to remove from the the item");
            int id = scanner.nextInt();
            scanner.nextLine();
            if (id == 0) {
                break;
            } else {
                System.out.println("Enter the quantity of the ingredient");
                int quantity = scanner.nextInt(); //holds the quantity of the new ingredient
                scanner.nextLine();
                Menu.findItem(id).removeIngredient(Apothiki.findIngredient(item));
            }
        }
    }

    //restock an ingredient
    public static void reStockIngredient() {
        System.out.println("======================================================================");
        printStock();
        System.out.println("Choose an ingredient by id to restock it");
        int ingredientId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the new ammount of quantity");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        Apothiki.findIngredient(ingredientId).reStock(quantity);
    }

    //creating new order to a given customer
    public static void createNewOrder(Customer customer) {
        System.out.println("======================================================================");
        printMenu();
        boolean quit = false;
        Order newOrder = new Order(customer.getId());
        while(!quit){
            System.out.println("PLEASE SELECT FROM THE ITEMS ABOVE WITH THE ID or SELECT 0 TO STOP INSERTING ITEMS");
            int id = scanner.nextInt();
            scanner.nextLine();
            if(id == 0) {
                quit = true;
                continue;
            } else {
                newOrder.addOrderItem(new OrderItem(Menu.findItem(id)));
            }
        }
        newOrder.printOrderItems();
    }

    //print ingredients of an item
    public static void printItemIngredients() {
        System.out.println("=======================================================================");
        printMenu();
        System.out.println("PLEASE SELECT THE ITEM BY ID");
        int item_id = scanner.nextInt();
        scanner.nextLine();
    }


}
