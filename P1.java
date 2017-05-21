//ALL STUDENTS COMPLETE THESE SECTIONS
//Main Class File:  P1.java
//File:             P1.java
//Semester:         CS536 Fall 2015
//
//Author:           msmurphy2@wisc.edu
//CS Login:         mmurphy
//Lecturer's Name:  Aws Albarghouthi 
////////////////////////////////////////////////////////////////////////////////

package P1;

/**
 * This class will be used to test the Sym and SymTable classes. This code tests
 * every Sym and SymTable operation, including both correct and bad calls to the
 * operation that can throw an exception. It produces output if a test fails as
 * well as for the print method of SymTable. If all other methods are correct,
 * the only output will be the print method.
 * 
 * @author Margaret Murphy
 */

public class P1 {
	public static void main(String[] args) {

		// Class Variables
		String nameInt = new String("Integer"); // New Name: Integer
		String nameDbl = new String("Double"); // New Name: Double
		String nameFloat = new String("Float"); // New Name: Float
		Sym symInt = new Sym("int"); // New Sym Object with type of int
		Sym symDbl = new Sym("double"); // New Sym Object with type of double
		Sym symFloat = new Sym("float"); // New Sym Object with type of float
		SymTable symTable = new SymTable(); // Instantiation of new SymTable
											// Object

		// Verify getType returns expected value
		if (!(symInt.getType().equals("int")))
			System.out.println("Doesn't get right type");

		// Verify toString returns expected value
		if (!(symInt.toString().equals("int")))
			System.out.println("toString incorrect");

		// Tests addDecl method
		try {
			symTable.addDecl(nameInt, symInt);
			symTable.addDecl(nameDbl, symDbl);
			// Tests addScope method
			symTable.addScope();
			symTable.addDecl(nameFloat, symFloat);
			// If addDecl doesn't work...
		} catch (EmptySymTableException este) { // symTable's list is empty
			System.out.println("Empty Exception thrown on attempt to add "
					+ "given values to first Hashmap in list.");
		} catch (NullPointerException npe) { // either name or sym is null
			System.out.println("Null Exception thrown on attempt to add "
					+ "given values to first Hashmap in list.");
		} catch (DuplicateSymException dse) { // list already contains given
												// name
			System.out.println("Duplicate Exception thrown on attempt to add"
					+ "given values to first Hashmap in list.");
		}

		// Tests lookupLocal method
		try {
			symTable.lookupLocal(nameInt);
			symTable.lookupLocal(nameDbl);
			symTable.lookupLocal(nameFloat);
		} catch (EmptySymTableException este) { // symTable's list is empty
			System.out.println("Empty Exception thrown on attempt to "
					+ "look up local.");
		}

		// Tests lookupGlobal method
		try {
			symTable.lookupGlobal(nameInt);
			symTable.lookupGlobal(nameDbl);
			symTable.lookupGlobal(nameFloat);
		} catch (EmptySymTableException este) { // symTable's list is empty
			System.out.println("Empty Exception thrown on attempt to "
					+ "look up global.");
		}

		// Tests removeScope method
		try {
			symTable.removeScope();
		} catch (EmptySymTableException este) { // symTable's list is empty
			System.out.println("Exception thrown on attempt to remove "
					+ "from front of list.");
		}
		
		// Print "Sym Table" and each hashmap in list
		symTable.print(); 
	}
}
