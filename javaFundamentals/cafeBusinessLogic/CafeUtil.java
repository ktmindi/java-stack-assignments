package javaFundamentals.cafeBusinessLogic;


import java.util.ArrayList;

public class CafeUtil {

    //ninja bonus add parameter, numWeeks so that an admin can change the number from 10 to whatever they want
    public int getStreakGoal() {
        int sum = 0;
        for(int week = 1; week <= 10; week++) {
            sum+= week;
        }
        return sum;
    }
    //given array of item prices from an order sum all the prices in the array and return the total
    public double getOrderTotal(double[] itemPrice) {
        double sum = 0;
        for (double price: itemPrice) {
            sum+= price;
        }
        return sum;

    }

    // display the menu
    public void displayMenu(ArrayList<String> menuItems) {
        for (int id = 0; id < menuItems.size(); id++) {
            System.out.printf("%s %s \n", id, menuItems.get(id));
        }
    }


    // add a customer
    public void addCustomer(ArrayList<String> customerList) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %s people ahead of you.\n", customerList.size());
        customerList.add(userName);
        System.out.println(customerList);
    }

    // ninja bonus price chart
    //public void printPriceChart(String product, double price, int maxQuantity) {

    //}

    // ninja bonus display menu
    //public boolean displayMenu(ArrayList<String> menuItems,ArrayList<Double> prices) {

    //}

}