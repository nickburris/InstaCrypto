import java.io.*;
import java.net.*;

public class Networking {
	/*public static void main(String[] args) throws Exception {
		//client side
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + "\n");
		
		modifiedSentence = inFromServer.readLine();
		System.out.println("Server: " + modifiedSentence);
		clientSocket.close(); //close socket after use
		
		//server side
		String clientSentence;
		String modifiedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while (true) {
			System.out.println("Wating for connections...");
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("A client has connected.  Passing client from welcomeSocket to it's own TCP socket");
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			clientSentence = inFromClient.readLine();
			modifiedSentence = clientSentence + " I modified your setence!\n";
			outToClient.writeBytes(modifiedSentence);
			
		}
		
	}
	 */
	public Networking() {
		// TODO Auto-generated constructor stub
	}

}

/*
 Socket - Combination of IP address and port
 Socket Types (Common)
 	TCP - Trasmission control protocol
 	UDP - User datagram protocol
 	
 	
 
 Client side sockets
 	
 	Socket clientSocket = new Socket(ip address to remote, port)
 	
 Server side socket
 	ServerSocket welcomeSocket = new ServerSocket(port#)
 		Once a client connects, the server passes the client from the listening socket to a new dedicated socket
 	Socket connectionSocket = welcomeSocket.accept()???
 	
 	
 	
 




*/