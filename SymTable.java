//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  P1.java
// File:             SymTable.java
// Semester:         CS536 Fall 2015
//
// Author:           msmurphy2@wisc.edu
// CS Login:         mmurphy
// Lecturer's Name:  Aws Albarghouthi 
////////////////////////////////////////////////////////////////////////////////

/**
 * This class will be used by the compiler to 
 * represent a symbol table, which will be 
 * implemented as a list of HashMaps. 
 * 
 * The HashMap keys will be Strings and the 
 * associated information will be a Sym.
 * 
 * @author Margaret Murphy
 */

import java.util.*;
import java.util.Map.Entry;

public class SymTable {

	/* Class Variables */
	LinkedList<HashMap<String, Sym>> list = 
			new LinkedList<HashMap<String, Sym>>();
	public HashMap<String, Sym> map;
	public HashMap<String, Sym> firstMap; // first map in list
	String name;
	Sym sym;

	/**
	 * Constructor. Initializes SymTable's list to contain a single, empty
	 * HashMap.
	 */
	SymTable() {
		map = new HashMap<String, Sym>();
		list.add(map);
	}

	/**
	 * Throws EmptySymTableException if list is empty Throws
	 * NullPointerException if either name or sym is null Throws
	 * DuplicateSymException if first hashmap in list already contains given
	 * name as key Otherwise adds given name and sym to first hashmap in list
	 */
	void addDecl(String name, Sym sym) throws DuplicateSymException,
			EmptySymTableException {
		// if SymTable's list is empty, throw Empty
		if (list.isEmpty()) {
			throw new EmptySymTableException();
		}
		// if name or sym or both are null, throw NullPointer Exception
		if ((name == null) || (sym == null)) {
			throw new NullPointerException();
		}
		// if first hashmap in list already contains given name as a key, throw
		// Duplicate

		map = list.peekFirst();
		if (map.containsKey(name)) {
			throw new DuplicateSymException();
		} else {
			map.put(name, sym); // else add given name and sym to first hashmap
		}
	}

	/*
	 * Add a new, empty HashMap to front of list
	 */
	void addScope() {
		list.addFirst(new HashMap<String, Sym>());
	}

	/*
	 * Throws EmptySymTableException if list is empty If first hashmap contains
	 * name as key, returns associated sym Else returns null
	 * 
	 * @return associated sym or null
	 */
	Sym lookupLocal(String name) throws EmptySymTableException {

		firstMap = list.getFirst(); // First hashmap in list

		// if SymTable's list empty, throw Empty
		if (list.isEmpty()) {
			throw new EmptySymTableException();
		} else { // else, if the first HashMap in list contains name as key
			sym = firstMap.get(name);// return associated sym
		}
		return sym;
	}

	/*
	 * Throws EmptySymTableException if list is empty If any hashmap in list
	 * contains name as key, returns first associated sym (closest to front of
	 * list) else returns null.
	 * 
	 * @return associated sym or null
	 */
	Sym lookupGlobal(String name) throws EmptySymTableException {

		// Local Variable
		Sym sym = new Sym(null);
		// if SymTable's list empty, throw Empty
		if (list.isEmpty()) {
			throw new EmptySymTableException();
		}
		// if any hashmap in list contains name as key, return first assoc sym
		// (one from HashMap that is closest to the front of list)
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Sym> map = list.get(i);
			if (map.containsKey(name)) {
				return sym = map.get(name);
			} else
				sym = null;
		}
		return sym;
	}

	/*
	 * Throws EmptySymTableException if list is empty otherwise removes hashmap
	 * from front of list
	 */
	void removeScope() throws EmptySymTableException {

		// if Symtable's list empty, throw empty
		if (list.isEmpty()) {
			throw new EmptySymTableException();
		} else { // else remove HashMap from front of list
			list.removeFirst();
		}
	}

	/*
	 * used for debugging prints SymTable along with each hashmap in the list.
	 */
	void print() {

		// Print "Sym Table"
		System.out.print("\nSym Table\n");

		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Sym> M = list.get(i);
			// Print each HashMap in list
			System.out.print(String.format(M.toString() + "\n"));
		}

		// Print New Line
		System.out.println();
	}
}
