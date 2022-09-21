package javaFundamentals.WeekOne.DojoBell;


public class DojoBellTest {
    public static void main(String[] args) {
        DojoBell db = new DojoBell();
//use it as its own data type which is a class and call it db 
//this allows us to access our dojobell class 
        //String username = new String("jon");
        DojoBell db2 = new DojoBell();

        db.greeting();
        db.greeting("rachel");
        db2.greeting("ian");


        db.makeArray();
        db.makeOrderList();

        db.makeHash();
    }
}
