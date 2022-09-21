// at first VSCode said to put package into the code 
package javaFundamentals.CafeJava; //and then running it, it gave me an error until i removed it.
public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLESßß
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        //value is not used double mochaPrice = 3.5;
        double dripCoffeePrice = 2.8;
        double lattePrice = 1.8;
        double cappucinoPrice = 2.1;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        //value is not used String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        //value is not used boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        //value is not used boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        // 1) Cindhuri ordered a coffee
        System.out.println(pendingMessage + customer1); 
        // Should display "your order will be ready shortly Cindhuri"

        // 2) noah orders cappucino check status and let him know if ready
        if(isReadyOrder4) {
            System.out.println(readyMessage + customer4);
            System.out.println(displayTotalMessage + cappucinoPrice);
        }
        else{
            System.out.println(pendingMessage + customer4);
        }
        // 3) Sam orders 2 lattes and would like to know total up front and order status 
        System.out.println(displayTotalMessage + lattePrice * 2);
        if (isReadyOrder2) {
            System.out.println(readyMessage + customer2);
        }
        else{
            System.out.println(pendingMessage + customer2);
        }
        // 4) jimmy just realized he was charge for coffee but had ordered a latte and wants to know the difference in total
        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));
    }
}