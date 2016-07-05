/**
 * 
 * PlainTextMessage object definition
 *
 * @author Lee Lunn
 * @since Mar 12, 2016
 */
public class PlainTextMessage extends Message {
	/**
	 * Parameterized constructor
	 * 
	 * @param msg Original message content
	 */
	public PlainTextMessage(String msg) {
		super(msg, Message.MessageType.PLAINTEXT);
	}
	
	/**
	 * Return this messages type.
	 * 
	 * @return Message type
	 */
	public Message.MessageType getMessageType() {
		return Message.MessageType.CODED; 
	}	
}
