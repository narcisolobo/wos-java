// Subclass
public class Car extends Vehicle {
    public String model;

    public Car(int speed, int capacity, String model) {
        super(speed, capacity);
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed);
        System.out.println("Capacity: " + capacity);
    }

    @Override
    public void startEngine() {
        // polymorphism
        super.startEngine();
        System.out.println("Vroom...");
    }
}
