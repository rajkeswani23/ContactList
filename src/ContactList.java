//Raj Keswani
//January 22, 2024
import java.util.ArrayList;
import java.util.Scanner;
public class ContactList
{
    private ArrayList<Person> contacts;

    public ContactList()
    {
        this.contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts()
    {
        return contacts;
    }

    public void addContact(Person contact)
    {
        contacts.add(contact);
    }

    // For each loop that goes through the contacts in the array list contact and prints their toString
    public void printContacts()
    {
        for (Person contact : contacts)
        {
            System.out.println(contact.toString());
        }
    }

    // This method uses bubble sort to order the contacts
    // It uses the compareContacts method to compare two contacts alphabetically
    public void sort(int sortBy)
    {
        for (int i = contacts.size() - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                //If it is greater than 0 (second contact comes first alphabetically), it means they need to switch
                if(compareContacts(contacts.get(j), contacts.get(j+1), sortBy) > 0)
                {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }

    // Method to compare the contacts that takes in two Person objects
    // The method sortBy helps determine whether first name, last name, or phone number should be compared
    public int compareContacts(Person p1, Person p2, int sortBy)
    {
        if (sortBy == 0)
        {
            return p1.getFirstName().compareTo(p2.getFirstName());
        }
        else if (sortBy == 1)
        {
            return p1.getLastName().compareTo(p2.getLastName());
        }
        else
        {
            return p1.getPhoneNumber().compareTo(p2.getPhoneNumber());
        }
    }

    // Method filters through contacts first name to see if any of the contacts match the contact taken in parameter
    // Returns the contact if it does but null if it doesn't
    public Person searchFirstName(String firstName)
    {
        for (Person contact : contacts)
        {
            if (contact.getFirstName().equals(firstName))
            {
                return contact;
            }
        }
        return null;
    }

    // This method filters through contacts last name to see if any of the contacts match the contact taken in parameter
    // Returns the contact if it does but null if it doesn't
    public Person searchLastName(String lastName)
    {
        for (Person contact : contacts)
        {
            if (contact.getLastName().equals(lastName))
            {
                return contact;
            }
        }
        return null;
    }

    // This method filters through contacts number to see if any of the contacts match the contact taken in parameter
    // Returns the contact if it does but null if it doesn't
    public Person searchPhoneNumber(String phoneNumber)
    {
        for (Person contact : contacts)
        {
            if (contact.getPhoneNumber().equals(phoneNumber))
            {
                return contact;
            }
        }
        return null;
    }

    // This method takes in a name/number to search and takes in a number to indicate first name, last name, or number
    public Person search(String value, int attribute)
    {
        if (attribute == 0)
        {
            return searchFirstName(value);
        }

        else if (attribute == 1)
        {
           return searchLastName(value);
        }

        else
        {
           return searchPhoneNumber(value);
        }
    }

    // This method goes through the contacts and prints the students
    public void listStudents()
    {
        for (Person contact : contacts)
        {
            if (contact instanceof Student)
            {
                System.out.println(contact.toString());
            }
        }
    }

    // This code is used to run the game
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Keep running until user puts in 0 to exit
        while (choice != 0)
        {
            System.out.println("Menu");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Name");
            System.out.println("3. List All Contacts by Last Name");
            System.out.println("4. List All Contacts By Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search By First Name");
            System.out.println("7. Search By Last Name");
            System.out.println("8. Search By Phone Number");
            System.out.println("0. Exit");

            System.out.println("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // If the user wants to add a contact it will ask a series of questions

            if (choice == 1)
            {
                System.out.println("Select a type of contact to add:");
                System.out.println("1. Student");
                System.out.println("2. Musician");

                System.out.println("Enter your choice: ");
                int contactType = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Please fill in the following information:");

                System.out.println("First Name: ");
                String firstName = scanner.nextLine();

                System.out.println("Last Name ");
                String lastName = scanner.nextLine();

                System.out.println("Phone Number: ");
                String phoneNumber = scanner.nextLine();

                // If the contact is a student, give them a grade
                if (contactType == 1)
                {
                    System.out.println("Grade: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    addContact(new Student(firstName, lastName, phoneNumber, grade));
                }

                // If the contact is a musician, give them an instrument
                if (contactType == 2)
                {
                    System.out.println("Instrument: ");
                    String instrument = scanner.nextLine();
                    addContact(new Musician(firstName, lastName, phoneNumber, instrument));
                }
            }


            else if (choice > 1 && choice < 5)
            {
                // Choice - 2 would give you 0, 1, or 2.
                // This is used to determine if first name, last name, or number is sorted
                sort(choice - 2);
                printContacts();
            }

            else if (choice == 5)
            {
                listStudents();
            }


            else if (choice > 5 && choice < 9)
            {
                // This if else statement helps seperate first and last name from phone number
                if (choice == 6 || choice == 7)
                {
                    System.out.println("Enter a Name: ");
                }
                else
                {
                    System.out.println("Enter a Phone Number: ");
                }
                String nameOrNumber = scanner.nextLine();
                // Choice - 6 is either 0, 1, or 2 signifying first name, last name, or phone number for search method
                Person foundContact = search(nameOrNumber, choice - 6);

                if (foundContact != null)
                {
                    System.out.println(foundContact.toString());
                }

                else
                {
                    System.out.println(nameOrNumber + " is not in the list.");
                }
            }
        }

        System.out.println("Thank you for using Contact List. You have exited.");
    }
}
