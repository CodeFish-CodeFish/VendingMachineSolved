package com.codefish;

public class Instructions {


    public static void getInstructions(int input) {

        switch (input) {
            case 0:
                System.out.println("Press ");
            case 1:
                System.out.println("1 - List all items/products, names of products");
            case 2:
                System.out.println("2 - Get item/product info (details, availability), price and inventory number");
            case 3:
                System.out.println("3 - Select a product");
            case 4:
                System.out.println("4 - Get item/product price");
            case 5:
                System.out.println("5 - List all prices");
            case 6:
                System.out.println("6 - Set price range");
            case 7:
                System.out.println("7 - Exit");
            case 8:
                System.out.println("8 - Buy an item");
                /*
                 * Vending machine options are:
                 * 1- List all items/products, names of products
                 * 2 - Get item/product info (details, availability), price and inventory number
                 * 3 - Select a product
                 * 4 - Get item/product price
                 * 5 - List all prices
                 * 6 - Set price range
                 * 7 - Exit
                 * 8 - Buy an item
                 */
                break;
            default:
                System.out.println("Please enter 0");
        }
    }

}
