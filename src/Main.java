import java.util.Scanner;

/**
 * The main program that returns the data of a person from their email id
 */
public class Main {

    // Constants

    /**
     * The message to display when asking the user for an input
     */
    private static final String INPUT_MESSAGE = "Username: ";

    /**
     * The message to display when an error occurs
     */
    private static final String ERROR_MESSAGE = "There was an error.";

    /**
     * The message to display when outputting the person's full name
     */
    private static final String FULL_NAME_MESSAGE = "Name: ";

    // Methods

    /**
     * Gets information about a person from their email id
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(INPUT_MESSAGE);
        String username = scanner.next();

        Person inputPerson = new Person(username);
        Person outputPerson = LookupController.lookupPerson(inputPerson);

        if (outputPerson == null || outputPerson.getFullname() == null) {
            System.out.println(ERROR_MESSAGE);
            System.exit(0);
        }

        String name = outputPerson.getFullname();
        System.out.println(FULL_NAME_MESSAGE + name);
    }
}
