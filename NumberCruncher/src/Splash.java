import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Splash {                        //THIS IS THE MAIN WINDOW (FIRST WINDOW)
	

	JFrame frmNumbercrunsher;          //We make our Frame global
	Images Back = new Images();        //We instantiate the Images class
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : void main(String[]args)
		// Method Parameters     : args - The method permits String commands line parameters to be entered. 
		// Method return         : void
		// Synopsis              : In this method we call all the functions.
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/28               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Splash window = new Splash();
				
			window.frmNumbercrunsher.setVisible(true);

			}
		});
	}

	/**
	 * Create the application.
	 */
	public Splash() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : Splash
		// Method Parameters     : none 
		// Method return         : none
		// Synopsis              : In this method we call all the functions.
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/28               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
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
		frmNumbercrunsher = new JFrame();
		frmNumbercrunsher.setResizable(false);
		frmNumbercrunsher.setTitle("NumberCrunsher");
		frmNumbercrunsher.setBounds(450, 250, 1041, 495);
		frmNumbercrunsher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNumbercrunsher.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("PLAY");                               //Here we create a Play button  
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                          //When the user clicks on the button
				
				Initials nextWindow =new Initials(0, 0, 0);                      //We instantiate the Initials Window                  
				
			    nextWindow.frame.setVisible(true);                               //We display the next window 
			    frmNumbercrunsher.dispose();                                     //We delete this window to avoid overlapping
			}
		});
		btnNewButton.setBounds(435, 313, 143, 54);
		frmNumbercrunsher.getContentPane().add(btnNewButton);

		JLabel lblBackground = new JLabel("");                                   //We create a label to set the background 
		lblBackground.setBounds(0, 0, 1025, 456);
		frmNumbercrunsher.getContentPane().add(lblBackground);
		lblBackground.setIcon(Back.backGround);                                 //We call the initials background.

	}
}
