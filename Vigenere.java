/**
 * Vigenere object definition
 * 
 * This class provides encoding/decoding operations for the Vigenere Cipher
 *
 * @author Lee Lunn
 * @author Liam Hartery
 * 
 * @since Mar 15, 2016
 */
public class Vigenere implements Coder {
	private final int ALPHA_OFFSET_START = 65; // UTF-8 'A' character offset
	
	public Vigenere() {
		// Intentionally left blank
	}
	
	/**
	 * Encodes message using Vigenere cipher
	 * 
	 * @see CodedMessage
	 */
	public CodedMessage encode(PlainTextMessage msg, Key key) {
		char[] keyData, // key for encoding
			   message, // message to encode
			   encoded; // encoded message
		int keyPos = 0; // key encoding row index
		
		// convert to char arrays to avoid repetitive slow method calls
		message = msg.get().toCharArray();
		keyData = key.getKey().toCharArray();
		encoded = new char[message.length];

		// loop through the supplied message and encode each character using
		// the appropriate encoding row
		for (int i = 0; i < message.length; i++) {
			encoded[i] = (char)(keyData[keyPos] + 
					(message[i]) - ALPHA_OFFSET_START);

			// reset the key index if the next index is out of bounds
			if (++keyPos > keyData.length - 1 ) { keyPos = 0;  }			
		}
		
		return new CodedMessage(String.valueOf(encoded), Key.KeyType.VIGENERE);
	}
	
   // decodes msg using key
   // returns a new PlainTextMessage object
	public PlainTextMessage decode(CodedMessage msg, Key key) {
		int keyPos = 0;
      char[] encoded = msg.get().toCharArray();
      char[] keyArray = key.getKey().toCharArray();
      char[] decoded = new char[encoded.length];
      
      // iterate through and decode using the key
      // resets key position if it is out of bounds
      for(int i=0;i<encoded.length;i++)
      {
         decoded[i]= (char)(encoded[i] - keyArray[keyPos] + 65);
         if (++keyPos > keyArray.length - 1 ) { keyPos = 0;  }
      }
      // turns our decoded array into a decoded String
      String decodedString = new String(decoded);
      // returns a PlainTextMessage
		return new PlainTextMessage(decodedString);
	}
}
