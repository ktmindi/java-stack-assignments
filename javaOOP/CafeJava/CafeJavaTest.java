package javaOOP.CafeJava;

public class CafeJavaTest {
    public static void main(String[] args) {
        //menu items
        Item item1 = new Item();
        item1.name = "drip coffee";
        item1.price = 10.50;

        Item item2 = new Item();
        item2.name = "cappucino";
        item2.price = 13.50;

        Item item3 = new Item();
        item3.name = "latte";
        item3.price = 19.00;

        Item item4 = new Item();
        item4.name = "mocha";
        item4.price = 9.50;



        //order variables -- order 1 2 3 etc
        Order order1 = new Order();
        System.out.println(order1.total);
        order1.name = "cindhuri";

        Order order2 = new Order();
        order2.name = "jimmy";

        Order order3 = new Order();
        order3.name = "noah";

        Order order4 = new Order();
        order4.name = "sam";

        //application simulations

        // add item 1 to order 2 and update total
        order2.items.add(item1);
        order2.total += item1.price;
        System.out.println(order2.total);

        // add item 2 to order 3 and update total
        order3.items.add(item2);
        order3.total += item2.price;

        // add item 3 to order 4 and update total
        order4.items.add(item3);
        order4.total += item3.price;

        // change order 1 status 
        order1.ready = true;

        // sam ordered two more lattess
        order4.items.add(item3);
        order4.items.add(item3);
        order4.total += item3.price * 2;

        order2.ready = true;



        // testing 
        // order dashboard on the screen of every customer 
        System.out.printf("Customer order number one - %s , your total today is $ %s\n", order1.name, order1.total);
        System.out.printf("Currently ready?  %s\n", order1.ready);

        System.out.println("------------------------\n\n");
        System.out.printf("Customer order number two - %s , your total today is $ %s\n", order2.name, order2.total);
        System.out.printf("Currently ready?  %s\n", order2.ready);

        System.out.println("------------------------\n\n");
        System.out.printf("Customer order number three - %s , your total today is $ %s\n", order3.name, order3.total);
        System.out.printf("Currently ready?  %s\n", order3.ready);

        System.out.println("------------------------\n\n");
        System.out.printf("Customer order number four - %s , your total today is $ %s\n", order4.name, order4.total);
        System.out.printf("Currently ready?  %s\n", order4.ready);
    }
}
