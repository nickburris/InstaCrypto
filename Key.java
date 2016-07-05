/**
 * 
 * Key object definition
 * 
 * This class is used to define encoding/decoding keys and key types
 *
 * @author Lee Lunn
 * @since Mar 12, 2016
 */
public class Key {
	/**
	 * <p>Enumerated types of supported encoding</p>
	 * <p>Possible values:
	 * <ul>
	 * 	<li><strong>CAESAR</strong> - Basic Caesar shift</li>
	 * 	<li><strong>VIGENERE</strong> -  Vigenere matrix encoding
	 * </ul>
	 *
	 */
	public enum KeyType {
		CAESAR,
		VIGENERE
	}
	
	private String key; // Key to use for enconding	
	
	/**
	 * Parameterized constructor
	 * 
	 * @param key Encoding/decoding key
	 */
	public Key(String key) {
		this.key = key;
	}
	
	/**
	 * Retrieve the key
	 * 
	 * @return Key as supplied during object creation
	 */
	public String getKey() { return this.key; }
}
