package persistentAddressManagerPackage;

import java.util.Scanner; //Imports scanner in order for code to accept inputs.

public class address { // Creates address class

	// Sets each element of contact as string values.
	public String phoneNumber;
	public String firstName;
	public String lastName;
	public String address;

	// Constructor #1 prompts and records inputs from user for each element of a
	// contact.
	public address() {
		System.out.print("Enter phone number : ");
		phoneNumber = persistentAddressManagerPackage.inputReader.nextLine();
		System.out.printf("Enter first name : ");
		firstName = persistentAddressManagerPackage.inputReader.nextLine();
		System.out.printf("Enter last name : ");
		lastName = persistentAddressManagerPackage.inputReader.nextLine();
		System.out.printf("Enter address : ");
		address = persistentAddressManagerPackage.inputReader.nextLine();
	}

	// Constructor #2 Accepts initialization as parameter
	public address(String argPhoneNumber, String argFirstName, String argLastName, String argAddress) {
		phoneNumber = argPhoneNumber;
		firstName = argFirstName;
		lastName = argLastName;
		address = argAddress;
	}

	// Overstuffed constructor #3 Sets values of a individual address to values on a
	// line of a txt file. Split is used to parse the individual txt file lines.
	public address(String tockenizableAddress) {
		String[] result = tockenizableAddress.split("\\t");
		phoneNumber = result[0];
		firstName = result[1];
		lastName = result[2];
		address = result[3];
	}

	// Print address function
	public void printAddress() {
		System.out.println("Phone Number : " + phoneNumber);
		System.out.println("First Name : " + firstName);
		System.out.println("Last Name : " + lastName);
		System.out.println("Address : " + address + "\n");
	}
	// Method converts address into a properly formatted string.
	public String getTokenizedAddress() {
		return phoneNumber + "\t" + firstName + "\t" + lastName + "\t" + address + "\n";
	}
}
