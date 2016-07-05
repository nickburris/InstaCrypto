/**
 * Message object definition
 *
 * @author Lee Lunn
 * @since Mar 12, 2016
 */
public abstract class Message {
	/**
	 * <p>Enumerated types of messages</p>
	 * <p>Possible values:
	 * <ul>
	 * 	<li><strong>CODED</strong> - Text is encrypted</li>
	 * 	<li><strong>PLAINTEXT</strong> -  Text is not encrypted
	 * </ul>
	 *
	 */	
	public enum MessageType { CODED, PLAINTEXT }
	private String content; // message content
	private MessageType contentType; 
	
	/**
	 * Parameterized constructor
	 * 
	 * @param c String representing message content
	 */
	public Message(String c, MessageType type) {
		this.content = c;
		this.contentType = type;
	}
	
	/**
	 * Set the message content to the supplied string
	 * 
	 * @param c Message content
	 */
	public void set(String c) { this.content = c; }
	
	/**
	 * Retrieve the message content
	 * 
	 * @return The message
	 */
	public String get() { return this.content; }
	
	/**
	 * Retrieve the type of message this object represents
	 * 
	 * @return Type of message
	 */
	public abstract MessageType getMessageType();
	
	public String toString() {
		return this.content;
	}
	
	/**
	 * Check if this message is equivalent to another message
	 * 
	 * @param msg The message object to compare with
	 * @return A boolean representing if the content and contentType of the two messages are the same
	 */
	public boolean equals(Message msg) {
		return (msg.get().equals(content)) && (msg.getMessageType() == contentType);
	}
}
