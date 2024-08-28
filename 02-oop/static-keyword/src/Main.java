public class Main {
    public static void main(String[] args) {
        Muppet kermit = new Muppet("Kermit", "the Frog");
        System.out.println(kermit.getFirstName());
        kermit.setFirstName("Kermy");
        System.out.println(kermit.getFirstName());

        System.out.println(kermit.getLastName());
        System.out.println(Muppet.getMuppetCount()); // 1

        Muppet piggy = new Muppet("Miss", "Piggy");
        System.out.println(piggy.getFirstName());
        System.out.println(piggy.getLastName());
        piggy.setLastName("Piggies");
        System.out.println(piggy.getLastName());
        System.out.println(Muppet.getMuppetCount()); // 2

        System.out.println(piggy); // test toString()
    }
}
