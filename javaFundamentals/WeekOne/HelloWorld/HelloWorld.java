package javaFundamentals.WeekOne.HelloWorld;
//sometimes package is needed and sometimes its not unsure why 

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        String name = "Corey";
        byte num = 99;
        int num1 = 1;
        //float decimal = 1.5035f;

        System.out.printf("hi my name is %s, i am number - %d", name, num1);
        //System.out.println("Hi my name is "+ name + "i am number" + num1);
    
        greeting("Rachel");
        greeting("Rachel", "java");
        //add(2,10);
        System.out.println(add(2,10));

//conditionals
        if(num > 50){
            System.out.println("its a big number");
        } else{
            System.out.println("its a small number");
        }
        // will bring out its a big number

        if(num >50){
            System.out.println("its a big number");
        } else if (num > 10 && num < 80) {
            System.out.println("its in the middle");
        } else {
            System.out.println("its a small number");
        } //use sysout enter will populate system.out.println

//looops
        for (int i = 0; i <= 255; i++){
            System.out.println(i);
        }
    }

    public static void greeting(String name) {
        System.out.println("Hello, " + name);
    }
    //when your method does not RETURN anything then its return type will be VOID you cannot omit this
    public static void greeting(String name, String stack) {
        System.out.println("Hello, " + name + "welcome to, " + stack);
    }
    //this is called overloading which allows us to use the same/create abstract method that you can pass diff # of arguments into and kind of update or add thngs

    public static int add(int a, int b){
        return a + b;
    }
    //when you return you are not printing so nothing will appear unless you add system.out.println()



}
