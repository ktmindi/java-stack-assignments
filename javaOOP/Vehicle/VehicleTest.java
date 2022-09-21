//package javaOOP.Vehicle;

//getter and setters

class VehicleTest {
    public static void main(String[] args) {
        //Vehicle bike = new Vehicle();
        //Vehicle car = new Vehicle();
        //bike.setNumberOfWheels(2);
        //bike.setColor("red");
        //int bikeWheels = bike.getNumberOfWheels();
        //String bikeColor = bike.getColor();
        //car.setNumberOfWheels(4);
        //car.setColor("green");
        //int carWheels = car.getNumberOfWheels();
        //String carColor = car.getColor();
        //System.out.println("Bike object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
        //System.out.println("Car object - Wheels: " + carWheels + ", Color: " + carColor);





//coonstructor method

        Vehicle redVehicle = new Vehicle("red"); 
        //we have to pass the string red when we create the object
        // or we will get an error
        String color = redVehicle.getColor();
        System.out.println("The Vehicle color is: " + color);

        //output is The Vehicle color is red




    }
}

