
/**
 * Coder interface definition
 * 
 * This interface provides definition for standard encryption/decryption 
 * functionality support.
 * 
 * @author Lee Lunn
 * @since Mar 12, 2016
 */
public interface Coder {
	/**
	 * <p>Encodes provided message using supplied key</p>
	 * 
	 * <p><strong>Note: </strong> Implementations should assign the encoding
	 * type to the returned CodedMessage upon encoding.</p>
	 * 
	 * @param message Message to be encoded
	 * @param key Key to apply encoding with
	 * 
	 * @return Encoded message
	 */
	public CodedMessage encode(PlainTextMessage message, Key key);
	
	/**
	 * Decodes provided message using the supplied key
	 * 
	 * @param message Message to decode
	 * @param key Key to decode message
	 * 
	 * @return Decoded message
	 */
	public PlainTextMessage decode(CodedMessage message, Key key);
	
}
