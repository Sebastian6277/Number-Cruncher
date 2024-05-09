import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Initials {                                  //THIS IS THE SECOND WINDOW

	JFrame frame;                                       //We make our frame global.
	Images Initials = new Images();                     //We instantiate the Images class.
	Levels levels = new Levels();
	String userInput;                                   
	JButton btnOK;
	FileReader reader;
	
	public int Score;                                                                    //We make our integers variables which will change later in the game 
	public int Stage;
	int numberRange;
	private JTextField textUser;
	
	FileWriter writer;
	/**
	 * Create the application.
	 */
	public Initials(int Stage, int numberRange,int Score) {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : Initials
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              : In this method we call the initialize function.
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/28               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		this.Score = Score;
		this.Stage = Stage;
		this.numberRange = numberRange;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : initialize
		// Method Parameters     : void
		// Method return         : none
		// Synopsis              : In this method we display the  user interface.
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/28             C.Sebastian                    Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(800,300, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInitials = new JLabel("ENTER YOUR INITIALS :");                     //We ask the user to put the initials 
		lblInitials.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInitials.setBounds(115, 42, 279, 35);
		frame.getContentPane().add(lblInitials);
		
		textUser = new JTextField();                                                  //A text field is created for the user to enter their initials.
		textUser.setBounds(130, 115, 190, 35);
		frame.getContentPane().add(textUser);
		textUser.setColumns(10);
		userInput= textUser.getText();                                                //the text entered by the user in the text field is obtained 
                                                                                      //using textUser.getText() and assigned to the userInput variable.
		
		
		btnOK = new JButton("OK");
		btnOK.setBounds(174, 200, 96, 50);
		frame.getContentPane().add(btnOK);
		
		JLabel lblbackground = new JLabel("");   
		lblbackground.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblbackground);
		lblbackground.setIcon(Initials.userInitials);
		
		textUser.getDocument().addDocumentListener(new DocumentListener() {          //A DocumentListener is added to the text field to detect changes
            @Override                                                                //in the text entered by the user and call the method to update the state of the button.
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }
        });
		
		btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {   
                if(fileExist(textUser.getText())) {                                                                                        //If the file exist 
                	if (JOptionPane.showConfirmDialog(null, "There is a file with this name, would you like to use it?", "WARNING",        //We ask the user if they wants to use the file 
                	        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                		List <String> fileRead = fileRead(textUser.getText());                                                             //yes option
                		Levels nextWindow = new Levels(fileRead);
                		System.out.println(textUser.getText());                                                                 //We print the user's initials just for testing proposes 
                        nextWindow.setName(textUser.getText());  
                        frame.dispose();                                                           
                        nextWindow.frame.setVisible(true);   
                	} else {
                		Levels nextWindow = new Levels();                                                                     //If the user says no, we display the game normally                           
                        System.out.println(textUser.getText());
                        nextWindow.setName(textUser.getText());  
                        frame.dispose();                                                            
                        nextWindow.frame.setVisible(true);
                	}
                }
                else {                                                                                                       //If the file does not exist we display the game normally 
            	Levels nextWindow = new Levels();                                                   
                System.out.println(textUser.getText());
                nextWindow.setName(textUser.getText());  
                frame.dispose();                                                            //We delete this window 
                nextWindow.frame.setVisible(true);                                          //We display the next window 
            }
            }
        });
		
		btnOK.setEnabled(false);                                                            //We disable the button ok
	}

	private void updateButtonState() {
		String userInput = textUser.getText();
        if (userInput.matches("[a-zA-Z0-9]+") && userInput.length() >= 3) {                                    //If the user enter the initials correctly we enabled the button.  
            btnOK.setEnabled(true);
        } else {
            btnOK.setEnabled(false);
        }                       
    }
	
	public boolean fileExist(String fileName) {
		
		boolean exist = false;
		File file = new File(fileName+ ".txt");                                                                   //Here we create the new .txt file
		if(file.exists() && !file.isDirectory()) { 
		    exist = true;                                                                                      //We set the file as existing 
		}
		return exist ;
	}
	
	public List <String> fileRead(String fileName) {                                     
		BufferedReader br;
		List <String> data = new ArrayList<String>();
		try {
		  br = new BufferedReader(new FileReader( new File(fileName)+ ".txt"));      
            String line;
            while ((line = br.readLine()) != null) {
            	System.out.println(line);
               data = Arrays.asList(line.split(","));
               System.out.println(data.toString());
            }
            br.close();
        }catch (Exception e) {

		}		
	
		return data;
	}
}
