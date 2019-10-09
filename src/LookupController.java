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
            HTML html = NetworkController.fetchHTML(url);

            if (html != null) {
                String name = html.getChildFromFirstElement("h1", "property", "name");
                person.setFullname(name);

                String telephone = html.getChildFromFirstElement("a", "property", "telephone");
                person.setTelephone(telephone);

                String email = html.getChildFromFirstElement("a", "property", "email");
                person.setEmail(email);

                return person;
            }
        }

        return null;
    }

}
