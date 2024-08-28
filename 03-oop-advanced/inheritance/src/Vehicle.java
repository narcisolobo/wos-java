// Superclass
public class Vehicle {
    public int speed;
    public int capacity;

    public Vehicle(int speed, int capacity) {
        this.speed = speed;
        this.capacity = capacity;
    }

    public void startEngine() {
        System.out.println("Engine started");
    }

    public void startEngine(boolean warmUp) {
        if (warmUp) {
            System.out.println("Warming up the engine");
        }
        System.out.println("Engine started");
    }
}
