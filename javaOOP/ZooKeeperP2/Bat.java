package javaOOP.ZooKeeperP2;

public class Bat extends Mammal{

    public Bat(int energyLevel){
        super(energyLevel);
    }
    public void eatHumans(){
        System.out.println("the so-well, nevermind");
        this.energyLevel += 25;

    }

    public void attackTown(){
        System.out.println("the sound of a town on fire");
        this.energyLevel -= 100;
    }
    
    public void fly(){
        System.out.println("the sound of a bat taking off");
        this.energyLevel -= 50;
    }
    
}

