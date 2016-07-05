/**
 * Caesar object definition
 * 
 * This class provides encoding/decoding operations for the Caesar Cipher
 *
 * @author Amelia Stead
 * @author Ryan Stubbert
 * 
 * @since Mar 16, 2016
 */
public class Caesar implements Coder {
	//private constants
	private static final String NUMERIC = "0123456789";
	private static final int FIRST_CH_INDEX = 32;	//ASCII ' '
	private static final int LAST_CH_INDEX = 126;	//ASCII '~'
	private static final int RANGE = LAST_CH_INDEX - FIRST_CH_INDEX + 1;
	
	//constructor
	public Caesar(){}
	
	/**
	 * Encodes message using Caesar cipher. Loops through all regular ASCII characters
	 * (as defined by FIRST_CH_INDEX and LAST_CH_INDEX), 
	 * producing RANGE possible translations.
	 */
	public CodedMessage encode(PlainTextMessage message, Key key) {
		char[] msg = message.get().toCharArray();
		int shift = convertKey(key);
		char[] encoded = msg.clone();
		
		for (int i = 0; i < encoded.length; i++) {
			encoded[i] = (char)((encoded[i]+shift-FIRST_CH_INDEX) % RANGE + FIRST_CH_INDEX);
		}
		
		return new CodedMessage(String.valueOf(encoded), Key.KeyType.CAESAR);
	}
	/**
	 * Decodes message using Caesar cipher. Loops through all regular ASCII characters
	 * (as defined by FIRST_CH_INDEX and LAST_CH_INDEX), 
	 * undoes effect encode method assuming identical key is provided 
	 *
	 * @param message CodedMessage
	 * @param key Key
	 * @return Plain Text Message
	 */

	public PlainTextMessage decode(CodedMessage message, Key key) {
		char[] msg = message.get().toCharArray();
		int shift = convertKey(key);
		char[] decoded = msg.clone();
		
		for (int i = 0; i < decoded.length; i++) {
			if((decoded[i]-shift-FIRST_CH_INDEX)<0)
			{
				decoded[i] = (char)((LAST_CH_INDEX+1)+(decoded[i]-shift-FIRST_CH_INDEX) % RANGE );
			}
			else
				decoded[i] = (char)((decoded[i]-shift-FIRST_CH_INDEX) % RANGE + FIRST_CH_INDEX);
		}
		return new PlainTextMessage(String.valueOf(decoded));
	}
	
	/**
	 * Converts a key containing a String of any characters to an integer
	 * between 0 and RANGE-1 inclusive.
	 * 
	 * @param key
	 * @return An integer in [0,RANGE-1]
	 */
	private int convertKey(Key key) {
		char[] keyData = key.getKey().toCharArray();
		int result;
		
		//check if directly parsable, otherwise convert using hash code
		boolean parsable = true;
		if (NUMERIC.indexOf(keyData[0]) == -1 && keyData[0] != '-') {
			parsable = false;
		} else {
			for (int i = 1; i < keyData.length; i++) {
				if (NUMERIC.indexOf(keyData[i]) == -1) {
					parsable = false;
					break;
				}
			}
		}
		if (parsable)
			result = Integer.parseInt(key.getKey());
		else
			result = key.getKey().hashCode();
		
		//restrict to [0,51]
		if (result < 0)
			result = RANGE - Math.abs(result) % RANGE;
		else
			result = Math.abs(result) % RANGE;
		
		return result;
	}
}

