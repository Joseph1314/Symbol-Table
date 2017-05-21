/**
 * This class will define a Sym object,
 * initializes a type and returns its type
 * as a String. 
 *  
 * @author Margaret Murphy
 */

public class Sym {
	
    public String symType;
	/**
     * Constructs the Sym with the specified type.
     */
    public Sym(String type) {
        // initialize Sym to have given type
    	symType = type;
    }
	/**
     * Returns the key corresponding to this entry.
     *
     * @return 
     */
    public String getType() {
        // Return type
    	return symType;
    }
    
    /**
     * Converts type into a String value.
     * 
     * @return typeStr;
     */
    public String toString() {
    	// Convert to String and Return
    	return String.format(symType);
    }
	
}
