
/**
 * CodedMessage object definition
 * 
 * @author Lee Lunn
 * @since Mar 12, 2016
 */
public class CodedMessage extends Message {
	private Key.KeyType keyType; // Type of encoding used to encode this message
	
	/**
	 * Parameterized constructor
	 * 
	 * @param msg Encoded message
	 * @param type Type of encoding used
	 */
	public CodedMessage(String msg, Key.KeyType type) {
		super(msg, Message.MessageType.CODED);
		this.keyType = type;
	}
	
	/**
	 * Retrieve the type of encoding for this message
	 * 
	 * @return Encoding type
	 * 
	 * @see Key.KeyType
	 * 
	 */
	public Key.KeyType getType() { return this.keyType;}
	
	/**
	 * Return this messages type.
	 * 
	 * @return Message type
	 */	
	public Message.MessageType getMessageType() {
		return Message.MessageType.CODED; 
	}
	
	/**
	 * Override for parent set().  Do not allow changing coded messages after 
	 * object creation.
	 * 
	 * @param msg Content of message
	 */
	public void set(String msg) {
		return;
	}
}
