
public class Test {
	public static void main(String[] args) {
		/*System.out.println(new Vigenere().encode(
			new PlainTextMessage("This is an encoded message using Vigenere"),  
			new Key("ELEPHANT")));
		
		System.out.println(new Vigenere().encode(
				new PlainTextMessage("This is a really long plain text message"
						+ "that has been encoded to demontrate that a long"
						+ "message can be encoded using the Vigenere cipher. "
						+ "You might know it but the key length of the cipher "
						+ "is the same length as the message being encoded.  It"
						+ "works by repeating successively until all letters"
						+ "of the plain message has been translated into"
						+ "encoded letters.  Of course you know this if you are"
						+ "reading this message....oops."),  
				new Key("ELEPHANT")));*/
		
		
		//Caesar testing
		String testStr = "abc ABC xyz XYZ";
		System.out.println("PLAIN MESSAGE:");
		System.out.println(testStr+"\n");
		System.out.println("ENCODED MESSAGE (Key: 0):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("0")));
		System.out.println("DECODED MESSAGE (Key: 0):");
		CodedMessage a= new Caesar().encode(new PlainTextMessage(testStr), new Key("0"));
		System.out.println(new Caesar().decode(a, new Key("0"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: 1):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("1")));
		System.out.println("DECODED MESSAGE (Key: 1):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("1"));
		System.out.println(new Caesar().decode(a, new Key("1"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: 286):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("286")));
		System.out.println("DECODED MESSAGE (Key: 286):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("286"));
		System.out.println(new Caesar().decode(a, new Key("286"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: 5):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("5")));
		System.out.println("DECODED MESSAGE (Key: 5):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("5"));
		System.out.println(new Caesar().decode(a, new Key("5"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: 95):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("95")));
		System.out.println("DECODED MESSAGE (Key: 95):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("95"));
		System.out.println(new Caesar().decode(a, new Key("95"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: 94):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("94")));
		System.out.println("DECODED MESSAGE (Key: 94):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("94"));
		System.out.println(new Caesar().decode(a, new Key("94"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: -1):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("-1")));
		System.out.println("DECODED MESSAGE (Key: -1):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("-1"));
		System.out.println(new Caesar().decode(a, new Key("-1"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: -43):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("-43")));
		System.out.println("DECODED MESSAGE (Key: -43):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("-43"));
		System.out.println(new Caesar().decode(a, new Key("-43"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: WhyWouldYouEnterLettersForCaeser):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("WhyWouldYouEnterLettersForCaeser")));
		System.out.println("DECODED MESSAGE (Key: WhyWouldYouEnterLettersForCaeser):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("WhyWouldYouEnterLettersForCaeser"));
		System.out.println(new Caesar().decode(a, new Key("WhyWouldYouEnterLettersForCaeser"))+"\n");
		
		System.out.println("ENCODED MESSAGE (Key: adj\\['DAE Ddlaemd9384u130jq):");
		System.out.println(new Caesar().encode(new PlainTextMessage(testStr), new Key("adj\\['DAE Ddlaemd9384u130jq)")));
		System.out.println("DECODED MESSAGE (Key: adj\\['DAE Ddlaemd9384u130jq):");
		a= new Caesar().encode(new PlainTextMessage(testStr), new Key("adj\\['DAE Ddlaemd9384u130jq)"));
		System.out.println(new Caesar().decode(a, new Key("adj\\['DAE Ddlaemd9384u130jq)"))+"\n");
	}
}
