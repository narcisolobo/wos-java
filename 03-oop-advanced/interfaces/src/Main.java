public class Main {
    public static void main(String[] args) {
        Car wrangler = new Car();
        wrangler.startEngine();
        wrangler.stopEngine();

        Truck truck = new Truck();
        truck.startEngine();
        truck.stopEngine();

        Guitar fender = new Guitar();
        fender.jam();
        fender.strum();
        fender.tune();

        Piano piano = new Piano();
        piano.jam();

        Bass bass = new Bass();
        bass.solo();
        fender.solo();
    }
}
