package persistentAddressManagerPackage; //Creates address book package.

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; //Imports scanner in order for code to accept inputs.

public class persistentAddressManagerPackage { // Creates public class addressManager
	public static final Scanner inputReader = new Scanner(System.in); // Creates a universal scanner that is
																		// referencable by all objects. This makes use
																		// of scanner much easier in other objects.

	public static void main(String[] args) { // Creates main function.
		addressBook myAddressBook = new addressBook(); // Creates address book arraylist for main function.
		int userInput = 9; // Sets user input to default value.
		while (userInput != 6) { // While statement creates program to loop, until user wishes to exit program by
									// inputting 6.
			System.out.print("\nPress the appopriate number for the corresponding option (1 Through 6) : "); // User
																												// prompted
																												// to
																												// input
																												// appropriate
																												// value
																												// for
																												// desired
																												// menu
																												// item.
			System.out.print("\n");
			System.out.print( // Prints menu.
					"\n1 - Insert a new contact \n2 - Update an existing contact \n3 - Delete a contact \n4 - List all contacts  \n5 - Search for contact by first name, last name, or phone number \n6 - Exit ");
			System.out.print("\n");
			System.out.print("\nChoose your option: ");
			userInput = inputReader.nextInt();
			inputReader.nextLine(); // User inputs desired menu item number.

			// Switch statement is used. Cases of switch statement represent different
			// options of the main menu. All cases reference myAddressBook object.
			switch (userInput) {
			case 1: // Case 1 adds new contacts to contact list.
				myAddressBook.addAddress();
				break;
			case 2: // Case 2 updates existing contacts.
				myAddressBook.updateContact();
				break;
			case 3: // Case Deletes existing contacts.
				myAddressBook.deleteCurrentSelection();
				break;
			case 4: // Case 4 Prints entire list of contacts.
				myAddressBook.printAddresses();
				break;
			case 5: // Case 5 runs search function to find specific contacts.
				myAddressBook.search();
				break;
			}
			// If user exits program, program will clear txt file and append the file with
			// all addresses currently stored within java program.
			PrintWriter writer;
			try {
				writer = new PrintWriter("persistentAddressBook.txt");
				writer.print("");
				writer.close();
				myAddressBook.bookSave();
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		inputReader.close(); // Closes universal scanner.
	}
}