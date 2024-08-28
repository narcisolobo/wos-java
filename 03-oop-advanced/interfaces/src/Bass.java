public class Bass extends StringedInstrument implements Jammable {
    @Override
    public void jam() {
        System.out.println("Jamming on the bass.");
    }

    @Override
    public void solo() {
        System.out.println("Slapping da bass!");
    }

    @Override
    public void strum() {
        System.out.println("Why are you strumming a bass?");
    }
}
