public interface Jammable {
    void jam();

    default void solo() {
        System.out.println("Playing sick solo.");
    }
}
