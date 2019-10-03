/**
 * A person at the University of Southampton
 */
class Person {

    // Properties

    /**
     * The person's university username
     */
    private String username;

    /**
     * The full name and title of the person
     */
    private String fullname;

    // Constructors

    /**
     * Creates a new person
     * @param username The person's university username
     */
    Person(String username) {
        this.username = username;
    }

    /**
     * Creates a new person
     * @param username The person's university username
     * @param fullname The full name and title of the person
     */
    Person(String username, String fullname) {
        this.username = username;
        this.fullname = fullname;
    }

    // Getters and setters

    /**
     * Gets the person's username
     * @return The username of the person
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the person's username
     * @param username The new username of the person
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the person's full name and title
     * @return The title and full name of the person
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the person's full name and title
     * @param fullname The new full name and title of the person
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
