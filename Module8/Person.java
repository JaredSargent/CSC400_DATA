package Module8;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    // Constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    // toString for displaying person details
    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }

    // Default comparison (used for sorting by last name)
    @Override
    public int compareTo(Person other) {
        return this.lastName.compareTo(other.lastName);
    }
}