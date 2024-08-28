public class Car implements Startable {

    @Override
    public void startEngine() {
        System.out.println("Car engine starting.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopping.");
    }
}
