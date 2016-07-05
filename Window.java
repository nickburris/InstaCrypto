/*
 * The Window class handles the window for Insta Crypto
 * It also implements ActionListener, handling all user input
 */


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Window implements ActionListener{

	//Frame object
	private JFrame frame;
	
	//Text fields
	private JTextArea plainTextBox;
	private JTextArea encryptedTextBox;
	//Key field is a 'password field' meaning it is hidden when typed
	private JPasswordField encryptionKeyField;

	//Buttons
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JButton btnRecallPrevious;
	
	//Combo box
	private JComboBox comboBox;
	
	//Linked list of previous messages
	//Used as a stack. New messages added to front, retrieved messages popped from front.
	private LinkedList messageList;

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//initialize the linkedlist for the message history
		messageList = new LinkedList();
		
		//Set up the window frame
		frame = new JFrame();
		try{ //catch possible error in finding the icon.png image
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
		}catch(Exception e){
			e.printStackTrace();
		}
		frame.setTitle("Insta Crypto");
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); //absolute positioning is used, a survey of sample size 1 determined that this was favourable
		
		//Plain message label
		JLabel lblPlainMessage = new JLabel("Plain Message");
		lblPlainMessage.setBounds(10, 5, 115, 34);
		frame.getContentPane().add(lblPlainMessage);
		
		//Button to encrypt the plain message
		btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(this);
		btnEncrypt.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnEncrypt);
		
		//Plain message box
		plainTextBox = new JTextArea();
		plainTextBox.setBounds(10, 40, 414, 77);
		frame.getContentPane().add(plainTextBox);
		plainTextBox.setColumns(10);

		//Encryption key label
		JLabel lblEncryptionKey = new JLabel("Encryption Key");
		lblEncryptionKey.setBounds(10, 128, 100, 14);
		frame.getContentPane().add(lblEncryptionKey);
		
		//Encryption key text field
		encryptionKeyField = new JPasswordField();
		encryptionKeyField.setBounds(10, 144, 100, 20);
		frame.getContentPane().add(encryptionKeyField);
		encryptionKeyField.setColumns(10);
		
		//Dropdown list label
		JLabel lblEncryptionMethod = new JLabel("Encryption Method");
		lblEncryptionMethod.setBounds(136, 128, 132, 14);
		frame.getContentPane().add(lblEncryptionMethod);
		
		//dropdown list providing the option for which encryption method to use
		String[] cryptOptions = {"Caesar", "Vigenere"};
		comboBox = new JComboBox(cryptOptions);
		comboBox.setBounds(136, 144, 107, 20);
		frame.getContentPane().add(comboBox);
				
		//Button to recall the previous message from the history
		btnRecallPrevious = new JButton("Recall previous");
		btnRecallPrevious.addActionListener(this);
		btnRecallPrevious.setBounds(292, 124, 132, 23);
		frame.getContentPane().add(btnRecallPrevious);
		
		//Encrypted message box label
		JLabel lblEncryptedMessage = new JLabel("Encrypted Message");
		lblEncryptedMessage.setBounds(10, 190, 149, 14);
		frame.getContentPane().add(lblEncryptedMessage);

		//Decrypt button
		btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(this);
		btnDecrypt.setBounds(335, 186, 89, 23);
		frame.getContentPane().add(btnDecrypt);
		
		//Encrypted message text box
		encryptedTextBox = new JTextArea();
		encryptedTextBox.setBounds(10, 215, 414, 85);
		frame.getContentPane().add(encryptedTextBox);
		encryptedTextBox.setColumns(10);
	}

	//action listener implementation
	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Encrypt button press event
		if(event.getSource() == btnEncrypt){
			//make sure the plain text box actually contains text
			if(plainTextBox.getText().equals("")){
				JOptionPane.showMessageDialog(frame, "You must enter text to encrypt.");
				return;
			}
			
			//make sure the encrypted text box does not already contain text
			if(!encryptedTextBox.getText().equals("")){
				//if the encrypted text box contains text, verify override
				if(JOptionPane.showConfirmDialog(frame, "Erase existing encrypted message?") != JOptionPane.YES_OPTION){
					//user does not want to erase current encrypted message
					return;
				}
			}
			
			//safe to continue, create PlainTextMessage object
			PlainTextMessage plain = new PlainTextMessage(plainTextBox.getText());
			
			messageList.addToFront(plain);
			
			Coder coder = null;
			CodedMessage encrypted;
			
			String key = encryptionKeyField.getText(); //used despite deprecation
			
			if(key.equals("")){
				//no key provided
				JOptionPane.showMessageDialog(frame, "You must enter a key.");
				return;
			}
			
			Key encryptionKey = new Key(key);
			
			//determine encryption method
			if(comboBox.getSelectedIndex() == 0){
				//Caesar encryption
				coder = new Caesar();
			}else if(comboBox.getSelectedIndex() == 1){
				//Vigenere encryption
				coder = new Vigenere();
			}
			
			encrypted = coder.encode(plain, encryptionKey);
			
			encryptedTextBox.setText(encrypted.get());
		}
		
		//Decrypt button press event
		else if(event.getSource() == btnDecrypt){
			//make sure the encrypted text box actually contains text
			if(encryptedTextBox.getText().equals("")){
				JOptionPane.showMessageDialog(frame, "You must enter text to decrypt.");
				return;
			}
			
			//make sure the plain text box does not already contain text
			if(!plainTextBox.getText().equals("")){
				//if the plain text box contains text, verify override
				if(JOptionPane.showConfirmDialog(frame, "Erase existing plain text message?") != JOptionPane.YES_OPTION){
					//user does not want to erase current plain text message
					return;
				}
			}
			
			//safe to continue, create message objects
			PlainTextMessage plain;
			CodedMessage encrypted = null;
			
			Coder coder = null;
			
			//retrieve encryption key
			String key = encryptionKeyField.getText(); //used despite deprecation 
			if(key.equals("")){
				//no key provided
				JOptionPane.showMessageDialog(frame, "You must enter a key.");
				return;
			}
			
			Key encryptionKey = new Key(key);
			
			//determine encryption method
			if(comboBox.getSelectedIndex() == 0){
				//Caesar encryption
				coder = new Caesar();
				encrypted = new CodedMessage(encryptedTextBox.getText(), Key.KeyType.CAESAR);
			}else if(comboBox.getSelectedIndex() == 1){
				//Vigenere encryption
				coder = new Vigenere();
				encrypted = new CodedMessage(encryptedTextBox.getText(), Key.KeyType.VIGENERE);
			}
			
			plain = coder.decode(encrypted, encryptionKey);
			
			messageList.addToFront(plain);
			
			plainTextBox.setText(plain.get());
		}
		
		//"Recall previous" button press event
		else if(event.getSource() == btnRecallPrevious){
			if(messageList.getCount() > 0){
				//set the plain text box to the previous message
				plainTextBox.setText(messageList.getFront().getMessage().get());
				//pop previous message from stack
				messageList.removeFront();
			}else{
				JOptionPane.showMessageDialog(frame, "Message history empty.");
			}
		}
	}
}

