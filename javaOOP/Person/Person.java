package javaOOP.Person;

public class Person {
    private int age;
    private String name;
    public static int numberOfPeople = 0;
    public Person(int ageParam, String nameParam) {
        this.age = ageParam;
        this.name = nameParam;
        numberOfPeople++;
    }
    //public void objectMethods(Person anotherObject) {
    //    System.out.println("Class name: " + this.getClass().getSimpleName());
     //   System.out.println("toString: " + this.toString());
      //  System.out.println("Equals: " + this.equals(anotherObject));

    
    public static int peopleCount() {
        return numberOfPeople;
    }
}
