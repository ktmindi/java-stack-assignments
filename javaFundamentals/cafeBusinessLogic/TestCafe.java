package javaFundamentals.cafeBusinessLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestCafe {
    public static void main(String[] args) {

        CafeUtil appTest = new CafeUtil();

        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());

        double[] itemPrice = {10.5, 13.5, 19.0, 9.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(itemPrice));
        
        
        List<String> loadMenu = Arrays.asList(
            "drip coffee",
            "cappucino",
            "latte",
            "mocha"
        );


        ArrayList<String> menu = new ArrayList<String>();
        menu.addAll(loadMenu);
        appTest.displayMenu(menu);
    

        ArrayList<String> customers = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }
    }
}