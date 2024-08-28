public class Muppet {
    private static int muppetCount = 0;
    private String firstName;
    private String lastName;

    public Muppet(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        muppetCount++;
    }

    @Override
    public String toString() {
        return "Muppet{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static int getMuppetCount() {
        return muppetCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
