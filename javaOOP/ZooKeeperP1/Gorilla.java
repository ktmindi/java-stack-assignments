package javaOOP.ZooKeeperP1;

public class Gorilla extends Mammal{

    public Gorilla(int energyLevel){
        super(energyLevel);
    }
    public void throwSomething(){
        System.out.println("the gorilla has thrown something");
        this.energyLevel -= 5;

    }

    public void eatBanana(){
        System.out.println("the gorilla has eaten a banana");
        this.energyLevel += 10;
    }
    
    public void climb(){
        System.out.println("the gorilla has climbed a tree");
        this.energyLevel -= 10;
    }
    
}
