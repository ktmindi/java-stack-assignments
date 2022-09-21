//package javaOOP.Vehicle;

//getter and setters 

class Vehicle {
    //private int numberOfWheels;
    //private String color;
    
    // getter
    //public int getNumberOfWheels() {
    //    return numberOfWheels;
    //}
    
    // setter
    //public void setNumberOfWheels(int number) {
    //    numberOfWheels = number;
    //}
    // getter
    //public String getColor() {
    //    return color;
    //}
    // setter
    //public void setColor(String color) {
    //    this.color = color;        // 1
    //}

    

//constructor methods allow us to create default values 
//rather than calling the setter method after the object is created

    //private int numberOfWheels;
    //private String color;
   // public Vehicle(String color) {
   //     this.color = color;







// to allow multiple ways to instantiate our objects we must overload the constructor method


    private int numberOfWheels;
    private String color;
    
    // ex. new Vehicle()
    public Vehicle() {
    }


    // ex. new Vehicle("someColor")    
    public Vehicle(String color) {
        // setting the color attribute to the value from the color parameter
        this.color = color;
    }
    

    // ex. new Vehicle("someColor", 4)    
    public Vehicle(String color, int num) {
        this.color = color;
        this.numberOfWheels = num;
    }


	public String getColor() {
		return null;
	}
        
    // ...
    // getters and setters removed for brevity
    // ...


}
