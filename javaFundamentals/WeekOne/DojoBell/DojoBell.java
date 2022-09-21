package javaFundamentals.WeekOne.DojoBell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DojoBell {
    //dont want to test our code using this file so we wont write main here
    public void greeting(){
        System.out.println("welcome to dojo bell, can i take your order?");
    }
    //now we have to go to test file and create an instance
    public void greeting(String customer){
        // cannot do this because primitive type cant be null 
        //int num = null;
        //we must do this instead
        //Integer num = null;
        System.out.printf("welcome to dojobell %s, can i take your order?%n", customer);
        // %n means new line
    }

    // arrays
    public void makeArray() {
        int[] numArray = new int[10];
        System.out.println(Arrays.toString(numArray));

        numArray[0] = 1;
        numArray[1] = 2;

       // for (int i = 0; i < numArray.length; i++) {  //fori enter will give you this line of code
       // System.out.println(i);    
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = i + 1; //will set the values 1-10
        }

        System.out.println(Arrays.toString(numArray));
        }
    
    //arraylists
    public void makeOrderList() {
        ArrayList<String> orders = new ArrayList<>();
        System.out.println(orders);
        //adding items to our array this method is meant for strings so if you add an integer you will get an error
        orders.add("dojo del grande");
        orders.add("dojorito");
        orders.add("kickwrap supreme");
        orders.add("dojo pizzaria");
        //CHAINING IS NOT ALLOWED orders.add("pizz").add("caft"); <- this is chaining and it is not allowed

        System.out.println(orders);


        //now lets remove items from the array list

        //orders.remove("dojo pizzaria");
        //System.out.println(orders);
        //cam also remove by index 
        //orders.remove(3); 
        //this will have same result as above
        //System.out.println(orders);
        //getting one of the values -- get value of index 3

        System.out.println(orders.get(3));
        orders.set(3, "baja mountain kick");
        System.out.println(orders.get(3));
        //now we want to change this


        System.out.println(orders.size()); //will give us 4
    }
    
    //hashmapping
    public void makeHash() {
        HashMap<String, Double> priceMap = new HashMap<>(); //you cant use primitive types here you have to use wrapper class MUST IMPORT HASHMAP

        //to add something to hashmap 
        priceMap.put("dojo del grande", 4.99); //price and order name
        priceMap.put("dojorito", 5.99);
        priceMap.put("kickwrap supreme", 3.99);

        System.out.println(priceMap); //will show in one single line and we dont like that so we can change the way the output is by 

        //cant just put pricemap we have to use keyset to include all  keys that are inside 
        for (String order : priceMap.keySet()) {

            System.out.printf("%s : %,2f%n", order, priceMap.get(order));
        }
//to remove something from the price map
        priceMap.remove("dojorito");
        System.out.println(priceMap);
    }
}
