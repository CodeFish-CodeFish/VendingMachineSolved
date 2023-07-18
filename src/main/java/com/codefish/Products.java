package com.codefish;

import java.util.Scanner;

public class Products {

    /*
	 * Please add more vending machine features
	 * - Buy a product
	 * - Search for a product
	 * - Get list of products
	 */

    private static String[] products  = new String[] {"Monitor", "Mouse", "Keyboard", "USB cable", "Charger", "Mouse pad"};
    private static int[]    prices    = new int[] {100, 70, 89, 17, 99, 5};
    private static int[]    inventory = new int[] {4, 10, 5, 10, 5, 7};

    public static String[] getAllPrices() {
        System.err.println("Product: price");
        for (int j = 0; j < products.length; j++) {
            System.out.println(products[j] + ": $" + prices[j]);
        }
        return products;
    }

    public static int getProductPrice(String productName) {
        int index = 0;
        for (String s : products) {
            if (productName.equalsIgnoreCase(s)) {
                //System.out.println(prices[index]);
                return prices[index];
            }
            index++;
        }
        System.out.println("Sorry the product you entered is not available");
        return -1;
    }

    public static void selectProduct(String productName) {

    	//loop over the product list to find out if it is available in our vending machine
		//if yes find the price (tip: call a specific method)
		//and verify this product is available in inventory
		//ask if customer wants to buy it -> if yes call another method to buy a product
//											-> if no call method to cancel it
        Scanner scanner=new Scanner(System.in);
        boolean isAvailable=false;

        for(int i=0;i<products.length;i++){
            if(products[i].equalsIgnoreCase(productName)){
                if(inventory[i]>0){
                    isAvailable=true;
                }
            }
        }
        if(isAvailable){
            System.out.println(getProductPrice(productName));
            System.out.println("Do you want to buy this product? (Y/N)");
            String answer=scanner.next();
            if(answer.equalsIgnoreCase("y")){
                buyAProduct(productName);
            }else {
                return;
            }
        }else {
            System.out.println("This product is not available in this vendong machine");
        }

    }

    public static void buyAProduct(String productName) {

        /*
        Apply payment logic.
        Apply give back change logic
        Apply inventory update logic: if someone buys an item, we should decrement number of available items.
         */
        Scanner s=new Scanner(System.in);
        int price=getProductPrice(productName);

        if(price>-1){
            int indexNum=findIndex(productName);
            int invNumber=inventory[indexNum];
            if(invNumber>0){
                do {
                    System.out.println("You have to enter $"+price+" to buy this product");
                    int userMoney=s.nextInt();
                    if(userMoney>price){
                        System.out.println("Here is your change $"+(userMoney-price));
                        System.out.println("Thank you for shopping with us!");
                        indexNum=findIndex(productName);
                        inventory[indexNum]=--inventory[indexNum];
                        break;
                    }
                    else if(price==userMoney){
                        System.out.println("Thank you for shopping with us!");
                        indexNum=findIndex(productName);
                        inventory[indexNum]=--inventory[indexNum];
                        break;
                    }
                    else {
                        int diff=price-userMoney;
                        System.out.println("You entered $"+diff+" less");
                        System.out.println("Do you wish to continue inserting money? (Y/N)");
                        String ans=s.next();
                        if(ans.equalsIgnoreCase("Y")){
                            price=price-userMoney;
                            continue;
                        }
                        else {
                            System.out.println("Here is your $"+userMoney);
                            System.out.println("Thank you, have a great day!");
                            break;
                        }
                    }
                }while (true);
            }else {
                System.out.println("Sorry we don't have "+productName);
            }
        }
    }

    public static void getAllInformation(){
        for (int i=0;i<products.length;i++){
            System.out.println("The price of the "+products[i]+" is "+prices[i]+" and the inventory number for this product is "+inventory[i]);
        }
    }
    public static String getAllInformation(String productName){
        for (int i=0;i<products.length;i++){
            if(products[i].equalsIgnoreCase(productName)){
                System.out.println("Product: "+products[i]+"\n"+
                        "Price: "+prices[i]+"\n"+
                        "Availability: "+inventory[i]);
                return "";
            }
        }
        System.out.println("Sorry we do NOT have that product in our Vending Machine!");
        return "";
    }

    public static int findIndex(String productName){
        for (int i=0;i<products.length;i++){
            if(products[i].equalsIgnoreCase(productName)){
                return i;
            }
        }
        return -1;
    }
    public static void setPriceRange(int min, int max){
        for (int i=0;i<products.length;i++){
            if(prices[i]<=max && prices[i]>=min){
                System.out.println(products[i]);
            }
        }
    }

}
