import java.net.URI;
import java.net.URL;

/**
 * A person at the University of Southampton
 */
class Person {

    // Constants

    /**
     * The protocol for the URI to query a person's username
     */
    private static final String URI_PROTOCOL = "https";

    /**
     * The host for the URI to query a person's username
     */
    private static final String URI_HOST = "www.ecs.soton.ac.uk";

    /**
     * The base path for the URI to query a person's username
     */
    private static final String URI_BASE_PATH = "/people/";

    // Instance variables

    /**
     * The person's university username
     */
    private String username;

    /**
     * The full name and title of the person
     */
    private String fullname;

    /**
     * The person's telephone number
     */
    private String telephone;

    // Constructors

    /**
     * Creates a new person
     * @param username The person's university username
     */
    Person(String username) {
        this.username = username;
    }

    // Getters

    /**
     * Gets the person's username
     * @return The username of the person
     */
    String getUsername() {
        return username;
    }

    /**
     * Gets the person's full name and title
     * @return The title and full name of the person
     */
    String getFullname() {
        return fullname;
    }

    /**
     * Gets the person's telephone number
     * @return The telephone number
     */
    String getTelephone() {
        return telephone;
    }

    /**
     * Gets the URL of the person's public profile page
     * @return The URL of the person's public page
     */
    URL getURL() {
        String fullPath = URI_BASE_PATH + this.username;

        try {
            URI uri = new URI(URI_PROTOCOL, URI_HOST, fullPath, null);
            return uri.toURL();
        } catch(Exception e) {
            return null;
        }
    }

    // Setters

    /**
     * Sets the person's username
     * @param username The new username of the person
     */
    void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the person's full name and title
     * @param fullname The new full name and title of the person
     */
    void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Sets the person's telephone number
     * @param telephone The new telephone number
     */
    void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
