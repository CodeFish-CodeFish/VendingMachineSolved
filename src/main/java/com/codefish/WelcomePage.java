package com.codefish;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.codefish.Instructions.getInstructions;
import static com.codefish.Products.*;

/*
 * This is your main page where the vending machine application is going to be triggered and
 * all inputs being accepted.
 *
 */
public class WelcomePage {

    // working as expected
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to CodeFish sponsored vending machine!");
        System.out.println("What is your name?");
        boolean keepRunning=true;
        String name = scanner.next();
        System.out.println("Nice to meet you, " + name);
        for ( ;keepRunning;){

            System.out.println("Please press 0 for available options...");

            int allOptions = getIntegerInput(scanner, new Integer[]{0});
            getInstructions(allOptions);

            scanner = new Scanner(System.in);
            System.out.println("Enter what you want to do: ");
            switch (getIntegerInput(scanner, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})) {
                case 1:
                    // method call for get product list
                    getAllInformation();
                    break;
                case 2:
                    System.out.println("Please enter the product name you are looking for");
                    getAllInformation(new Scanner(System.in).nextLine());
                    break;
                case 3:
                    System.out.println("Please enter the product name you are looking for");
                    selectProduct(new Scanner(System.in).nextLine());
                    break;
                case 4:
                    System.out.println("Please enter the product name you are looking for");
                    int price = getProductPrice(new Scanner(System.in).nextLine());
                    System.out.println(price);
                    //getProductPrice(new Scanner(System.in).nextLine());
                    break;
                case 5:
                    getAllPrices();
                    break;
                case 6:
                    System.out.println("Please enter your price range, enter min first then max");
                    setPriceRange(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt());
                    break;
                case 7:

                    System.out.println("Thanks for shopping with us!");
                    keepRunning=false;
                    System.exit(-1);

                    break;
                case 8:
                    System.out.println("Please enter the product name you want to buy");
                    buyAProduct(new Scanner(System.in).nextLine());
                    break;
            }
        }
    }

    private static int getIntegerInput(Scanner scanner, Integer[] expected) {
        int allOptions = -1;
        for (int i = 1; i <= 3; i++) {
            scanner = new Scanner(System.in);
            int input;
            try {
                input = scanner.nextInt();

                if (!Arrays.asList(expected).contains(input)) {
                    throw new IOException();
                }
            } catch (Exception e) {
                if (i < 3) {
                    System.out.println("Please enter 0");
                    System.out.printf("You have %d more retries", 3 - i);
                    System.out.println();
                } else {
                    System.out.println("Sorry, try next time");
                    System.exit(1);
                }
                continue;
            }
            allOptions = input;
            break;
        }
        return allOptions;
    }
}
