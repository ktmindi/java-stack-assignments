package javaOOP.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(10, "Person1");
        Person person2 = new Person(5, "Person2");
        //person1.objectMethods(person2);
        System.out.println(Person.peopleCount());

        //static methods -- by creating class variables we can have attributes and methods
        //that belong to the class and not the instance of the class 

        System.out.println(Person.numberOfPeople);
        // in person.java file added line 6, and 10
        //remove lines 12-15
        
        // in persontest file remove line 7

        //in last example remove line 13 and add line 8

        //for saving without error purposes need to use person1 and person2 
        
    }
}
