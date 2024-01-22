//Raj Keswani
//January 22, 2024
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Welcome to your contact list");
        System.out.println("Please pick from the following menu options");
        System.out.println();
        // Makes a contact list object to run the run method on
        ContactList contactList = new ContactList();
        contactList.run();
    }
}