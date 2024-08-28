public class Main {
    public static void main(String[] args) {
        Car wrangler = new Car(100, 4, "Jeep Wrangler");
        wrangler.displayInfo();

        System.out.println("Car startEngine:");
        wrangler.startEngine();
        wrangler.startEngine(true);

        Vehicle vehicle = new Vehicle(100, 4);
//        vehicle = new Car(100, 4, "BMW H3");
        System.out.println("Vehicle startEngine:");
        vehicle.startEngine();
        vehicle.startEngine(true);
    }
}
