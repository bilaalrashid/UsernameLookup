import java.util.Scanner;

/**
 * The main program that returns the data of a person from their email id
 */
public class Main {

    /**
     * Gets information about a person from their email id
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Strings.INPUT_MESSAGE);
        String username = scanner.next();
        scanner.close();

        Person inputPerson = new Person(username);
        Person outputPerson = LookupController.lookupPerson(inputPerson);

        if (outputPerson == null || outputPerson.getFullname() == null || outputPerson.getTelephone() == null) {
            System.out.println(Strings.ERROR_MESSAGE);
            System.exit(0);
        }

        String name = outputPerson.getFullname();
        System.out.println(Strings.FULL_NAME_MESSAGE + name);

        String telephone = outputPerson.getTelephone();
        System.out.println(Strings.TELEPHONE_MESSAGE + telephone);
    }

}
