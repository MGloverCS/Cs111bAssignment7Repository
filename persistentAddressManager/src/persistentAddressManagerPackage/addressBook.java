package persistentAddressManagerPackage;

import java.util.ArrayList; // Imports array list. 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class addressBook { // Creates address book class
	private ArrayList<address> addressContent = new ArrayList<address>(); // Creates specific array list that will be
																			// used as master list for program.
	int currentSelection = -1; // Currect Selection set to defualt value.

	public addressBook() { // This address book function creates three stock contacts to initially populate
							// the address book.
		BufferedReader br;
		try {
			// Reads line from text file, and converts them to individual address entry.
			br = new BufferedReader(new FileReader("persistentAddressBook.txt"));
			String line = null;
			while ((line = br.readLine()) != null) {
				addressContent.add(new address(line));
			}
		}

		catch (IOException e) { // Exception informs user there is currently no txt file storing addresses. New
								// txt file will automatically be created when user closes program.
			System.out.println("txt file not, created new txt file.");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// addressContent.get(0).printAddress();
		// System.out.print(addressContent.get(0).phoneNumber);

		bubbleSort(); // BubbleSort used to order three contacts in array list by last name.

	}

	public void printAddresses() { // Prints Entire address book.
		for (int i = 0; i < addressContent.size(); i++) {
			addressContent.get(i).printAddress();
		}
	}

	public void addAddress() { // Adds address to array list.
		address addedAddress = new address();
		addressContent.add(addedAddress);
		bubbleSort();
	}
	// Booksave appends txt file with current addresses contained within java program.
	public void bookSave() {
		Writer output;
		try {
			output = new BufferedWriter(new FileWriter("persistentAddressBook.txt"));
			for (int i = 0; i < addressContent.size(); i++) {
				output.append(addressContent.get(i).getTokenizedAddress());
			}
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void search() { // Search function finds existing contact based on user input. If user input
							// contacts first name, last name, OR phone number of contact, function will
							// display that contact.
		System.out.print("Enter first name, last name, or phone number of your contact : ");
		String userInput = persistentAddressManagerPackage.inputReader.nextLine();
		for (int i = 0; i < addressContent.size(); i++) {
			if (addressContent.get(i).phoneNumber.compareTo(userInput) == 0 // If statement compares each element (first
																			// name, last name, and phone number) of
																			// each item in array list to user input.
					|| addressContent.get(i).firstName.compareTo(userInput) == 0
					|| addressContent.get(i).firstName.compareTo(userInput) == 0
					|| addressContent.get(i).lastName.compareTo(userInput) == 0) {
				currentSelection = i; // Search sets currentSelection value to contact whose element matched the user
										// input.
				System.out.print("CONTACT FOUND \n");
				addressContent.get(i).printAddress();
				return;
			}
		}
		System.out.print("ERROR: CONTACT NOT FOUND.");
	}

	public void deleteCurrentSelection() { // Function deletes currentSelection contact from Array list.
											// currentSelection contact is determined by using search function.
		if (currentSelection == -1) {
			System.out.print("ERROR: Please use search (option 5) to find a contact to delete.");
		} else {
			addressContent.get(currentSelection).printAddress();
			addressContent.remove(currentSelection);
			System.out.print("ABOVE CONTACT HAS BEEN DELETED\n");
			currentSelection = -1;
		}
	}

	public void bubbleSort() { // Bubblesort function is used to sort array list by contact last name.
		// number of passes
		for (int i = 1; i < addressContent.size(); i++) {
			// comparison loop
			for (int j = 0; j < addressContent.size() - 1; j++) {
				if (addressContent.get(j).lastName.compareTo(addressContent.get(j + 1).lastName) > 0) {
					address temp = addressContent.get(j + 1);
					addressContent.set(j + 1, addressContent.get(j));
					addressContent.set(j, temp);
				}
			}
		}
		currentSelection = -1;
	}

	public void updateContact() { // updateContact function updates individual elements of already existing
									// contacts.
		if (currentSelection == -1) {
			System.out.print("ERROR: Please use search (option 5) to find a contact to update.");
		} else {

			// Function goes through each individual element of contact. If element does not
			// need to be changed, user hits ENTER. If element does need to be changed, the
			// user instead enters the new value for stated element.
			addressContent.get(currentSelection).printAddress();
			System.out.print("\nAbove is current contact information\n");
			System.out.println("Current phone number is : " + addressContent.get(currentSelection).phoneNumber);
			System.out.print("Press ENTER if correct, or input new phone number : ");
			String newInput = persistentAddressManagerPackage.inputReader.nextLine();
			if (newInput.length() > 0) {
				addressContent.get(currentSelection).phoneNumber = newInput;
			}
			System.out.println("Current first name is : " + addressContent.get(currentSelection).firstName);
			System.out.print("Press ENTER if correct, or input new first name : ");
			newInput = persistentAddressManagerPackage.inputReader.nextLine();
			if (newInput.length() > 0) {
				addressContent.get(currentSelection).firstName = newInput;
			}
			System.out.println("Current last name is : " + addressContent.get(currentSelection).lastName);
			System.out.print("Press ENTER if correct, or input new last name : ");
			newInput = persistentAddressManagerPackage.inputReader.nextLine();
			if (newInput.length() > 0) {
				addressContent.get(currentSelection).lastName = newInput;
			}
			System.out.println("Current address is : " + addressContent.get(currentSelection).address);
			System.out.print("Press ENTER if correct, or input new address name : ");
			newInput = persistentAddressManagerPackage.inputReader.nextLine();
			if (newInput.length() > 0) {
				addressContent.get(currentSelection).address = newInput;

			}
			bubbleSort();
		}
	}
}
