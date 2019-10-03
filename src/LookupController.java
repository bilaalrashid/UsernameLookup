import java.net.URL;

/**
 * Manages the lookup of a person's full data
 */
class LookupController {

    /**
     * Gets the full data for a person
     * @param person The person to lookup
     * @return The updated person
     */
    static Person lookupPerson(Person person) {
        URL url = person.getURL();

        if (url != null) {
            String html = NetworkController.fetchHTML(url);

            if (html != null) {
                return person;
            }
        }

        return null;
    }

}
