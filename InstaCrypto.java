/*
 * The main class for Insta Crypto. Instantiates the Window.
 */


public class InstaCrypto {
	private static Window w;
	
	public static void main(String[] args){
		System.out.println("Running...");
		try {
			w = new Window();
			System.out.println("Window instatiated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
