public class Main {
    public static void main(String[] args) {
        Muppet kermit = new Muppet("Kermit", "the Frog");
        System.out.println(kermit.getFirstName());
        System.out.println(kermit.getLastName());
        System.out.println(Muppet.getMuppetCount());
        Muppet piggy = new Muppet("Miss", "Piggy");
        System.out.println(piggy.getFirstName());
        System.out.println(piggy.getLastName());
        System.out.println(Muppet.getMuppetCount());
        System.out.println(piggy);
    }
}
