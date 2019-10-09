import java.util.Scanner;

/**
 * The main program that returns the data of a person from their email username
 */
public class Main {

    /**
     * Gets information about a person from their email username
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        String username = inputUsername();
        Person inputPerson = new Person(username);

        Person outputPerson = LookupController.lookupPerson(inputPerson);

        if (checkForError(outputPerson)) {
            System.out.println(Strings.ERROR_MESSAGE);
            System.exit(0);
        }

        outputDetails(outputPerson);
    }

    /**
     * Prompts the user to input a username
     * @return The inputted username
     */
    private static String inputUsername() {
        System.out.print(Strings.INPUT_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        scanner.close();

        return username;
    }

    /**
     * Checks if there was an error in the process
     * @param person The outputted person
     * @return If an error is detected
     */
    private static boolean checkForError(Person person) {
        return person == null
                || person.getFullname() == null
                || person.getTelephone() == null
                || person.getEmail() == null;
    }

    /**
     * Outputs the fetched details to the user
     * @param person The person to output details about
     */
    private static void outputDetails(Person person) {
        String name = person.getFullname();
        System.out.println(Strings.FULL_NAME_MESSAGE + name);

        String telephone = person.getTelephone();
        System.out.println(Strings.TELEPHONE_MESSAGE + telephone);

        String email = person.getEmail();
        System.out.println(Strings.EMAIL_MESSAGE + email);
    }


}
