public class Guitar extends StringedInstrument implements Jammable {

    @Override
    public void strum() {
        System.out.println("Strumming the guitar.");
    }

    @Override
    public void jam() {
        System.out.println("Jamming on the guitar.");
    }
}
