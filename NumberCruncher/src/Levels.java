import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Levels{                                                             
    Initials intials;                                                                     //THIS IS THE THIRD WINDOW 
    Images image = new Images();                                        //We instantiate  our Images class
	GenerateRNumber generator = new GenerateRNumber();                  //We instantiate our GenerateRNumbers class
	
	private static int EASY_RANGE = 10;                           
	private static int MEDIUM_RANGE = 100;                        //We declare the range of each level
	private static int DIFFICULT_RANGE = 1000;
	private static int Easy_Lives = 5;
	private static int Easy_Lives2 = 5;
	private static int Easy_Lives3 = 5;
	private static int Medium_Lives = 7;
	private static int Medium_Lives2 = 7;
	private static int Medium_Lives3= 7;
	private static int Medium_Lives4 = 7;
	private static int Medium_Lives5 = 7;
	private static int Hard_Lives = 11;
	private static int Hard_Lives2 = 11;
	private static int Hard_Lives3= 11;
	private static int Hard_Lives4 = 11;
	private static int Hard_Lives5= 11;
	private static int Hard_Lives6 = 11;
	private static int Hard_Lives7 = 11;
	JFrame frame;                                                       //We make our frame global 
	
	JButton Back;                                                       //We make our buttons global
	JButton btneasy;
	JButton btnSubmit;
	JButton btnModerate;
	JButton btnDifficult;
	
	JLabel lblevel;                                                    //We make our labels global which will change in the game later.
	JLabel lblStage;
	JLabel lblScore;
	JLabel lbllives;
	JLabel lblHArrow;
	JLabel lblNumberRange;
	JLabel lblguess;
	JLabel lblguess_2;
	JLabel lblguess_3;
	JLabel lblguess_4;
	JLabel lblguess_5;
	JLabel lblguess_6;
	JLabel lblguess_7;
	
	private JLabel lblQMatch;                                                               //We make our private labels global which may not change 
	private JLabel Track;
	private JLabel Track_2;
	private JLabel Track_3;
	private JLabel Track_4;
	private JLabel Track_5;
	private JLabel Track_6;
	private JLabel Track_7;
	private JLabel lives;
	private JLabel lives_2;
	private JLabel lives_3;
	private JLabel lives_4;
	private JLabel lives_5;
	private JLabel lives_6;
	private JLabel lives_7;
	private JLabel lblPnumber;
	private JLabel lblGnumber;
	private JLabel lblSArrowD;
	private JLabel lblSwrong;
	private JLabel lblSArrowU;
	private JLabel lblScorrect;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblMatch;
	private JLabel lblMatch_2;
	private JLabel lblMatch_3;
	private JLabel lblMatch_4;
	private JLabel lblMatch_5;
	private JLabel lblMatch_6;
	private JLabel lblMatch_7;
	
	public int Score = 0;                                                                    //We make our integers variables which will change later in the game 
	public int Stage = 1;
	int numberRange;
	int complete = 0;
	
	public String name ="";
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	private JLabel lblarrowI;                                                                //We make the labels for the icons to show the instructions 
	private JLabel lblArrowDI;
	private JLabel lblWrongI;
	private JLabel lblCorrectI;
	private JLabel lblArrow;
	private JLabel lblArrow_2;
	private JLabel lblArrow_3;
	private JLabel lblArrow_4;
	private JLabel lblArrow_5;
	private JLabel lblArrow_6;
	private JLabel lblArrow_7;
	private JLabel lblLnumber;
	private JLabel lblLnumber_2;
	private JLabel lblLnumber_3;
	private JLabel lblLnumber_4;
	private JLabel lblLnumber_5;
	private JLabel lblLnumber_6;
	private JLabel lblLnumber_7;
	
	boolean easyButtonPressed = false;
	boolean mediumButtonPressed = false;
	boolean hardButtonPressed= false;
	
	FileWriter writer;	
    public Levels() {
		initialize();
	}
	public Levels(List<String> data) {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : Levels
		// Method Parameters     : List<String> data : Here we load the data for the previous player
		// Method return         : none
		// Synopsis              : In this method we are going to display the user's data from the previous game 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/06/06               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		initialize();
 
		if(data.get(3).equals("easy")) {                                                           //If the 3rd data is "easy" we display the following values   
			setVisibleLabels();                                                                    // we set the labels visible 
			Easy();                                                                                //We display all the labels that we are going to use in the Easy level
			numberRange =Integer.parseInt(data.get(2));                                            //We get the values in the order we have in the saveUserInitials method
			EASY_RANGE = numberRange;
			lblNumberRange.setText("NUMBER RANGE: "+ EASY_RANGE);                                  //We updated the labels to display the correct values 
			easyButtonPressed = true;
            generator.generateNumber(Levels.this, "easy");                                        //We generated random numbers 
			DisableLabels();                                                                      //We disable the labels or buttons that we are not going to use 
			name=data.get(0);                                                                     
		    Stage = Integer.parseInt(data.get(1).trim());                                      
		    lblStage.setText("STAGE :" + Stage);
		    easyButtonPressed=true;
		    mediumButtonPressed= false;
		    hardButtonPressed =false;
		    Score = Integer.parseInt(data.get(4));
		    lblScore.setText("SCORE: "+Score);
		    Easy_Lives = Integer.parseInt(data.get(5));
		    lives.setText(""+Easy_Lives);
		    Easy_Lives2 = Integer.parseInt(data.get(6));
		    lives_2.setText(""+Easy_Lives2);
		    Easy_Lives3 = Integer.parseInt(data.get(7));
		    lives_3.setText(""+Easy_Lives3);
		} else if(data.get(3).equals("medium")) {                                                  //If the 3rd data is "medium" we display the following values        
			setVisibleLabels();
			Moderate();
			numberRange = Integer.parseInt(data.get(2));
			MEDIUM_RANGE = numberRange;
			lblNumberRange.setText("NUMBER RANGE: "+ MEDIUM_RANGE);
			mediumButtonPressed = true;
			generator.generateNumber(Levels.this, "moderate");
			DisableLabels();
			name = data.get(0);
			Stage = Integer.parseInt(data.get(1).trim());
			lblStage.setText("STAGE: " + Stage);
			easyButtonPressed=false;
			mediumButtonPressed= true;
			hardButtonPressed =false;
			Score = Integer.parseInt(data.get(4));
		    lblScore.setText("SCORE: "+Score);
			Medium_Lives = Integer.parseInt(data.get(5));
			lives.setText("" + Medium_Lives);
			Medium_Lives2 = Integer.parseInt(data.get(6));
			lives.setText("" + Medium_Lives2);
			Medium_Lives3 = Integer.parseInt(data.get(7));
			lives.setText("" + Medium_Lives3);
			Medium_Lives4 = Integer.parseInt(data.get(8));
			lives.setText("" + Medium_Lives4);
			Medium_Lives5 = Integer.parseInt(data.get(9));
			lives.setText("" + Medium_Lives5);		 
		}
		else {                                                                              //If the 3rd data is neither "medium" nor "easy" we display the hard values
			setVisibleLabels();
			Difficult();
			numberRange = Integer.parseInt(data.get(2));
			DIFFICULT_RANGE = numberRange;
			lblNumberRange.setText("NUMBER RANGE: "+ DIFFICULT_RANGE);
			mediumButtonPressed=true;
			generator.generateNumber(Levels.this , "difficult");
		    DisableLabels();
		    name = data.get(0);
		    Stage = Integer.parseInt(data.get(1).trim());
			lblStage.setText("STAGE: " + Stage);
			easyButtonPressed=false;
			mediumButtonPressed= false;
			hardButtonPressed =true;
			Score = Integer.parseInt(data.get(4));
		    lblScore.setText("SCORE: "+Score);
		    Hard_Lives = Integer.parseInt(data.get(5));
		    lives.setText(""+ Hard_Lives);
		    Hard_Lives2 = Integer.parseInt(data.get(6));
		    lives.setText(""+ Hard_Lives2);
		    Hard_Lives3 = Integer.parseInt(data.get(7));
		    lives.setText(""+ Hard_Lives3);
		    Hard_Lives4 = Integer.parseInt(data.get(8));
		    lives.setText(""+ Hard_Lives4);
		    Hard_Lives5 = Integer.parseInt(data.get(9));
		    lives.setText(""+ Hard_Lives5);
		    Hard_Lives6 = Integer.parseInt(data.get(10));
		    lives.setText(""+ Hard_Lives6);
		    Hard_Lives7 = Integer.parseInt(data.get(11));
		    lives.setText(""+ Hard_Lives7);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : initialize()
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              : In this methods we display the interface (player's view)
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/06/06               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
	  
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(250, 40, 1500, 970);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
       
		btneasy = new JButton("EASY");                                      //We create the easy button 
		btneasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleLabels();                                         //We call the functions we are going to need  when the button is bressed 
				Easy();
				numberRange = 10;
				EASY_RANGE = 10;
				easyButtonPressed = true;
	            generator.generateNumber(Levels.this, "easy");             //We call the number range that the easy level needs and generate the numbers from 
				DisableLabels();                                         //GenerateRNumber class
			}
		});
		btneasy.setBounds(557, 122, 418, 188);
		frame.getContentPane().add(btneasy);

		btnModerate = new JButton("MEDIUM");                                 //We create the medium button 
		btnModerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleLabels();                                        //We call the functions we are going to need when the button is pressed 
				Moderate();
				numberRange = 100;                        
				MEDIUM_RANGE = 100;
				mediumButtonPressed = true;
				generator.generateNumber(Levels.this, "moderate");        //We call the number range that the medium level needs and generate the numbers from 
				DisableLabels();                                          //GenerateRNumber class
			}
		});
		btnModerate.setBounds(557, 359, 418, 188);
		frame.getContentPane().add(btnModerate);

		btnDifficult = new JButton("HARD");                                      //We create the hard button 
		btnDifficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisibleLabels();                                             //We call the function we are going to need when the button is pressed 
                Difficult();
				numberRange = 1000;                                            //We declare the range of each level
				DIFFICULT_RANGE = 1000;
                hardButtonPressed = true;
                generator.generateNumber(Levels.this , "difficult");           //We call the number range that the hard level needs and generate the numbers from 
				DisableLabels();                                               //GenerateRNumber class 
			}
		});
		btnDifficult.setBounds(557, 592, 418, 188);
		frame.getContentPane().add(btnDifficult);

		Back = new JButton("Main Menu");                                        //We create our main menu button to go back to the menu
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Splash main = new Splash();
				numberRange = 0;
				EASY_RANGE = 10;                           
				MEDIUM_RANGE = 100;                                              //We declare the range of each level
				DIFFICULT_RANGE = 1000;
				main.frmNumbercrunsher.setVisible(true);
				frame.dispose();	
			}
		});
		Back.setFont(new Font("Tahoma", Font.BOLD, 14));
		Back.setBounds(1121, 794, 187, 76);
		frame.getContentPane().add(Back);
		Back.setVisible(false);
		
		btnSubmit = new JButton("Submit");                                    //We create our Submit button which we will use later in the game 
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (easyButtonPressed) {                                      //if the user pressed the easy button before, we called the SubmitE method 
		            SubmitE();
		        }
				
				if(mediumButtonPressed) {                                    //if the user pressed the medium button before, we called the SubmitM method 
					SubmitM();
				}
				if(hardButtonPressed) {                                     //if the user pressed the hard button before, we called the SubmitH method 
					SubmitH();
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(693, 794, 187, 76);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.setVisible(false);
		
		lblStage = new JLabel("STAGE:" + " " + Stage);                      //We create the stage label to tell the users in which stage they are 
		lblStage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStage.setBounds(28, 29, 76, 14);
		frame.getContentPane().add(lblStage);
		lblStage.setVisible(false);

		lblNumberRange = new JLabel("NUMBER RANGE:");                      //We create the Number range  label to tell the users in which range they are 
		lblNumberRange.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberRange.setBounds(28, 83, 221, 14);
		frame.getContentPane().add(lblNumberRange);
		lblNumberRange.setVisible(false);

		lblScore = new JLabel("SCORE:" + " " + Score);                   //We create the score label to tell the users the score they have 
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScore.setBounds(28, 119, 170, 14);
		frame.getContentPane().add(lblScore);
		lblScore.setVisible(false);

		lblevel = new JLabel("SELECT THE LEVEL");                       //We create the label to ask the user to choose a level (easy, medium, hard) 
		lblevel.setBackground(Color.WHITE);
		lblevel.setForeground(Color.BLACK);
		lblevel.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblevel.setBounds(557, 29, 418, 49);
		frame.getContentPane().add(lblevel);

		Track = new JLabel("TRACK 1");                                       //We create our labels which will have the tracks.
		Track.setFont(new Font("Tahoma", Font.BOLD, 14));
		Track.setBounds(413, 29, 62, 14);
		frame.getContentPane().add(Track);
		Track.setVisible(false);

		Track_2 = new JLabel("TRACK 2");                                     //Track  (easy mode)
		Track_2.setFont(new Font("Tahoma", Font.BOLD, 14)); 
		Track_2.setBounds(586, 29, 62, 14);
		frame.getContentPane().add(Track_2);
		Track_2.setVisible(false);

		Track_3 = new JLabel("TRACK 3");                                    //Track 3  (easy mode)
		Track_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		Track_3.setBounds(748, 29, 62, 14);
		frame.getContentPane().add(Track_3);
		Track_3.setVisible(false);

		Track_4 = new JLabel("TRACK 4");                                    //Track 4  (medium mode)
		Track_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		Track_4.setBounds(913, 29, 62, 14);
		frame.getContentPane().add(Track_4);
		Track_4.setVisible(false);

		Track_5 = new JLabel("TRACK 5");                                   //Track 5  (medium mode)
		Track_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		Track_5.setBounds(1071, 29, 62, 14);
		frame.getContentPane().add(Track_5);
		Track_5.setVisible(false);

		Track_6 = new JLabel("TRACK 6");                                  //Track 6 (hard mode)
		Track_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		Track_6.setBounds(1226, 29, 62, 14);
		frame.getContentPane().add(Track_6);
		Track_6.setVisible(false);

		Track_7 = new JLabel("TRACK 7");                                 //Track 7 (hard mode)
		Track_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		Track_7.setBounds(1392, 29, 62, 14);
		frame.getContentPane().add(Track_7);
		Track_7.setVisible(false);
				 
		lbllives = new JLabel("LIVES :");                               //We create the lives label just as a decoration 
		lbllives.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbllives.setBounds(253, 122, 62, 14);
		frame.getContentPane().add(lbllives);
		lbllives.setVisible(false);
		
		lives = new JLabel("");                                       //We create our labels which will display the user's lives later in the game 
		lives.setHorizontalAlignment(SwingConstants.LEFT);
		lives.setFont(new Font("Tahoma", Font.BOLD, 14));
		lives.setBounds(435, 119, 55, 20);
		frame.getContentPane().add(lives);
		
		lives_2 = new JLabel("");                                   //For track 2
		lives_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lives_2.setBounds(603, 119, 55, 20);
		frame.getContentPane().add(lives_2);
		
		lives_3 = new JLabel("");                                   //For track 3
		lives_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lives_3.setBounds(769, 119, 55, 20);
		frame.getContentPane().add(lives_3);
		
		lives_4 = new JLabel("");                                  //For track 4
		lives_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lives_4.setBounds(935, 119, 55, 20);
		frame.getContentPane().add(lives_4);
		
		lives_5 = new JLabel("");                                  //For track 5
		lives_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lives_5.setBounds(1095, 116, 55, 20);
		frame.getContentPane().add(lives_5);
		
		lives_6 = new JLabel("");                                 //For track 6
		lives_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lives_6.setBounds(1253, 116, 55, 20);
		frame.getContentPane().add(lives_6);
		
		lives_7 = new JLabel("");                                 //For track 7
		lives_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lives_7.setBounds(1419, 116, 55, 20);
		frame.getContentPane().add(lives_7);
		
        lblHArrow = new JLabel("HELP ARROW :");                   //We create our the label just as a decoration 
		lblHArrow.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHArrow.setBounds(234, 223, 105, 14);
		frame.getContentPane().add(lblHArrow);
		lblHArrow.setVisible(false);
		
		lblQMatch = new JLabel("MATCH? :");                      //We create this label to let the user know if the match is correct or not
		lblQMatch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQMatch.setBounds(253, 347, 76, 14);
		frame.getContentPane().add(lblQMatch);
		lblQMatch.setVisible(false);
		
		lblPnumber = new JLabel("PREVIOUS NUMBER:");              //We create a label just as a decoration
		lblPnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPnumber.setBounds(208, 421, 149, 14);
		frame.getContentPane().add(lblPnumber);
		lblPnumber.setVisible(false);
		
		lblGnumber = new JLabel("GUESS NUMBER :");                 //We create a label just as a decoration
		lblGnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGnumber.setBounds(228, 579, 129, 14);
		frame.getContentPane().add(lblGnumber);
		lblGnumber.setVisible(false);
				
		lblMatch = new JLabel("");                                //We create this label to show if the user is correct or not later in the game 
		lblMatch.setBounds(389, 306, 101, 100);
		frame.getContentPane().add(lblMatch);
				
		lblSArrowU = new JLabel("");                             //We create the label to show the icons depending if the user is correct or not 
		lblSArrowU.setBounds(49, 642, 55, 55);
		frame.getContentPane().add(lblSArrowU);
		lblSArrowU.setIcon(image.SarrowUp);
		lblSArrowU.setVisible(false);
		
		lblSArrowD = new JLabel("");
		lblSArrowD.setBounds(49, 708, 55, 55);
		frame.getContentPane().add(lblSArrowD);
		lblSArrowD.setIcon(image.SarrowDown);
		lblSArrowD.setVisible(false);
		
		lblSwrong = new JLabel("");
		lblSwrong.setBounds(49, 774, 55, 55);
		frame.getContentPane().add(lblSwrong);
		lblSwrong.setIcon(image.Swrong);
		lblSwrong.setVisible(false);
		
		lblScorrect = new JLabel("");
		lblScorrect.setBounds(49, 840, 55, 55);
		frame.getContentPane().add(lblScorrect);
		lblScorrect.setIcon(image.Scorrect);
		lblScorrect.setVisible(false);
				                                                                               //We display the instructions 
		lblarrowI = new JLabel("NUMBER TOO HIGH");
		lblarrowI.setFont(new Font("Tahoma", Font.BOLD, 14));                                  //Number too high
		lblarrowI.setBounds(114, 662, 149, 14);
		frame.getContentPane().add(lblarrowI);
		lblarrowI.setVisible(false);
		
		lblArrowDI = new JLabel("NUMBER TOO LOW");                                            //number too low
		lblArrowDI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArrowDI.setBounds(114, 728, 142, 14);
		frame.getContentPane().add(lblArrowDI);
		lblArrowDI.setVisible(false);
		
		lblWrongI = new JLabel("WRONG NUMBER");                                               //Wrong number 
		lblWrongI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWrongI.setBounds(114, 794, 129, 14);
		frame.getContentPane().add(lblWrongI);
		lblWrongI.setVisible(false);
		
		lblCorrectI = new JLabel("CORRECT NUMBER");                                          //Correct number
		lblCorrectI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCorrectI.setBounds(114, 860, 142, 14);
		frame.getContentPane().add(lblCorrectI);
		lblCorrectI.setVisible(false);
		                                                                                     //We display the random numbers the user needs to guess
	    lblguess = new JLabel("");
		lblguess.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblguess.setBounds(429, 485, 46, 14);
		frame.getContentPane().add(lblguess);
		lblguess.setVisible(false);
		
		lblguess_2 = new JLabel("");
		lblguess_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblguess_2.setBounds(602, 485, 46, 14);
		frame.getContentPane().add(lblguess_2);
		lblguess_2.setVisible(false);
		
		 lblguess_3 = new JLabel("");
		lblguess_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblguess_3.setBounds(764, 485, 46, 14);
		frame.getContentPane().add(lblguess_3);
		lblguess_3.setVisible(false);
		
		 lblguess_4 = new JLabel("");
		lblguess_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblguess_4.setBounds(944, 485, 46, 14);
		frame.getContentPane().add(lblguess_4);
		lblguess_4.setVisible(false);
		
		lblguess_5 = new JLabel("");
		lblguess_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblguess_5.setBounds(1104, 485, 46, 14);
		frame.getContentPane().add(lblguess_5);
		lblguess_5.setVisible(false);
		
		lblguess_6= new JLabel("");
		lblguess_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblguess_6.setBounds(1242, 485, 46, 14);
		frame.getContentPane().add(lblguess_6);
		lblguess_6.setVisible(false);
		
		lblguess_7 = new JLabel("");
		lblguess_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblguess_7.setBounds(1408, 485, 46, 14);
		frame.getContentPane().add(lblguess_7);
		lblguess_7.setVisible(false);
		
		textField = new JTextField();                       //We add the text field to ask the user for the number to guess 
		textField.setBounds(389, 570, 101, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(557, 570, 101, 36);
		frame.getContentPane().add(textField_2);
		textField_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(723, 570, 101, 36);
		frame.getContentPane().add(textField_3);
		textField_3.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(889, 570, 101, 36);
		frame.getContentPane().add(textField_4);
		textField_4.setVisible(false);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1049, 570, 101, 36);
		frame.getContentPane().add(textField_5);
		textField_5.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1207, 570, 101, 36);
		frame.getContentPane().add(textField_6);
		textField_6.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1373, 570, 101, 36);
		frame.getContentPane().add(textField_7);
		textField_7.setVisible(false);
						
		lblMatch_2 = new JLabel("");
		lblMatch_2.setBounds(547, 306, 101, 100);
		frame.getContentPane().add(lblMatch_2);
		
		lblMatch_3 = new JLabel("");
		lblMatch_3.setBounds(723, 306, 101, 100);
		frame.getContentPane().add(lblMatch_3);
		
		lblMatch_4 = new JLabel("");
		lblMatch_4.setBounds(889, 306, 101, 100);
		frame.getContentPane().add(lblMatch_4);
		
		lblMatch_5 = new JLabel("");
		lblMatch_5.setBounds(1049, 306, 101, 100);
		frame.getContentPane().add(lblMatch_5);
		
		lblMatch_6 = new JLabel("");
		lblMatch_6.setBounds(1207, 306, 101, 100);
		frame.getContentPane().add(lblMatch_6);
		
		lblMatch_7 = new JLabel("");
		lblMatch_7.setBounds(1373, 306, 101, 100);
		frame.getContentPane().add(lblMatch_7);
		
		lblArrow = new JLabel("");
		lblArrow.setBounds(389, 177, 101, 100);
		frame.getContentPane().add(lblArrow);
		
		lblArrow_2 = new JLabel("");
		lblArrow_2.setBounds(557, 177, 101, 100);
		frame.getContentPane().add(lblArrow_2);
		
		lblArrow_3 = new JLabel("");
		lblArrow_3.setBounds(723, 177, 101, 100);
		frame.getContentPane().add(lblArrow_3);
		
		lblArrow_4 = new JLabel("");
		lblArrow_4.setBounds(889, 177, 101, 100);
		frame.getContentPane().add(lblArrow_4);
		
		lblArrow_5 = new JLabel("");
		lblArrow_5.setBounds(1049, 177, 101, 100);
		frame.getContentPane().add(lblArrow_5);
		
		lblArrow_6 = new JLabel("");
		lblArrow_6.setBounds(1207, 177, 101, 100);
		frame.getContentPane().add(lblArrow_6);
		
		lblArrow_7 = new JLabel("");
		lblArrow_7.setBounds(1373, 177, 101, 100);
		frame.getContentPane().add(lblArrow_7);
		
		lblLnumber = new JLabel("");                                                                                       //We display the last number the user guessed 
		lblLnumber.setBounds(429, 423, 46, 14);
		frame.getContentPane().add(lblLnumber);
		
		lblLnumber_2 = new JLabel("");
		lblLnumber_2.setBounds(586, 423, 46, 14);
		frame.getContentPane().add(lblLnumber_2);
		
		lblLnumber_3 = new JLabel("");
		lblLnumber_3.setBounds(748, 423, 46, 14);
		frame.getContentPane().add(lblLnumber_3);
		
		lblLnumber_4 = new JLabel("");
		lblLnumber_4.setBounds(913, 423, 46, 14);
		frame.getContentPane().add(lblLnumber_4);
		
		lblLnumber_5 = new JLabel("");
		lblLnumber_5.setBounds(1071, 423, 46, 14);
		frame.getContentPane().add(lblLnumber_5);
		
		lblLnumber_6 = new JLabel("");
		lblLnumber_6.setBounds(1226, 423, 46, 14);
		frame.getContentPane().add(lblLnumber_6);
		
		lblLnumber_7 = new JLabel("");
		lblLnumber_7.setBounds(1392, 423, 46, 14);
		frame.getContentPane().add(lblLnumber_7);
		
		JLabel lblPlayer = new JLabel("");
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlayer.setBounds(28, 160, 129, 14);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblBackground = new JLabel("");                                  //We add the background label 
		lblBackground.setBounds(0, -12, 1500, 955);
		frame.getContentPane().add(lblBackground);
		lblBackground.setIcon(image.levelSelector);                           //We attached the image 
	}
	
	public void setGuessLabels(List<Integer> RandomNumbers) {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : setGuessLabels(List<Integer> RandomNumbers)
		// Method Parameters     : List<Integer> RandomNumbers: It allows us to add the number to the labels 
		// Method return         : none
		// Synopsis              : In this methods we are going to add the numbers generated in the labels 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/06/06               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
        lblguess.setText(Integer.toString(RandomNumbers.get(0)));
        lblguess_2.setText(Integer.toString(RandomNumbers.get(1)));
        lblguess_3.setText(Integer.toString(RandomNumbers.get(2)));
        
        if (RandomNumbers.size() > 4) {                                       //if the size is grater than 4  we display the other 2 labels for the medium label 
            lblguess_5.setText(Integer.toString(RandomNumbers.get(4)));
            lblguess_4.setText(Integer.toString(RandomNumbers.get(3)));
        }       
        if (RandomNumbers.size() > 6){                                        //if the size is grater than 6  we display the other 2 labels for the hard label 
            lblguess_7.setText(Integer.toString(RandomNumbers.get(6)));
            lblguess_6.setText(Integer.toString(RandomNumbers.get(5)));
        }
    }
	
	public void DisableLabels() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : DisableLabels()
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we are going to disable the labels we are not going to use 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/29               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		btneasy.setVisible(false);
		btnModerate.setVisible(false);
		btnDifficult.setVisible(false);
		lblevel.setVisible(false);
	}

	public void setVisibleLabels() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : setVisibleLabels()
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we are going to enabled all the labels,buttons that we are going to use in all the levels. 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/29               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		lblStage.setVisible(true);
		lblNumberRange.setVisible(true);
		lblScore.setVisible(true);
		Track.setVisible(true);
		Track_2.setVisible(true);
		Track_3.setVisible(true);
		lbllives.setVisible(true);
		lblHArrow.setVisible(true);
		lblQMatch.setVisible(true);
		lblPnumber.setVisible(true);
		lblGnumber.setVisible(true);
		btnSubmit.setVisible(true);
		textField.setVisible(true);
		textField_2.setVisible(true);
		textField_3.setVisible(true);
		lblSArrowD.setVisible(true);
		lblSArrowU.setVisible(true);
		lblSwrong.setVisible(true);
		lblScorrect.setVisible(true);
		lblarrowI.setVisible(true);
		lblArrowDI.setVisible(true);
		lblWrongI.setVisible(true);
		lblCorrectI.setVisible(true);
		Back.setVisible(true);
	}

	public void Easy() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : Easy()
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we are going to enabled all the labels we are going to use just for the easy level . 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/29               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------

	 lblNumberRange.setText("NUMBER RANGE: " + EASY_RANGE);   //we set the range for the easy level
	 lives.setText("" + Easy_Lives);
	 lives_2.setText("" + Easy_Lives);
	 lives_3.setText("" + Easy_Lives);
	 
	}
	public void Moderate() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : Moderate()
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we are going to enabled all the labels we are going to use just for the medium level . 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/29               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		lblNumberRange.setText("NUMBER RANGE: " + MEDIUM_RANGE);
		Track_4.setVisible(true);
		Track_5.setVisible(true);
		textField_4.setVisible(true);
		textField_5.setVisible(true);
		
		if(EASY_RANGE > 90) {
			 Medium_Lives += Easy_Lives;
			 Medium_Lives2 += Easy_Lives2;
			 Medium_Lives3 += Easy_Lives3;
		}
		
		lives.setText("" + Medium_Lives);
		lives_2.setText("" + Medium_Lives2);
		lives_3.setText("" + Medium_Lives3);
		lives_4.setText("" + Medium_Lives4);
		lives_5.setText("" + Medium_Lives5);
	}
	public void Difficult() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : Difficult()
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we are going to enabled all the labels we are going to use just for the hard level . 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/05/29               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		lblNumberRange.setText("NUMBER RANGE: " + DIFFICULT_RANGE);
		Track_4.setVisible(true);
		Track_5.setVisible(true);
		Track_6.setVisible(true);
		Track_7.setVisible(true);
		textField_4.setVisible(true);
		textField_5.setVisible(true);
		textField_6.setVisible(true);
		textField_7.setVisible(true);
		
		if(MEDIUM_RANGE > 900) {
			Hard_Lives  += Medium_Lives;
			Hard_Lives2 += Medium_Lives2;
			Hard_Lives3 += Medium_Lives3;
			Hard_Lives4 += Medium_Lives4;
			Hard_Lives5 +=Medium_Lives5;
		}
		
		lives.setText("" + Hard_Lives);
		lives_2.setText("" + Hard_Lives2);
		lives_3.setText("" + Hard_Lives3);
		lives_4.setText("" + Hard_Lives4);
		lives_5.setText("" + Hard_Lives5);
		lives_6.setText("" + Hard_Lives6);
		lives_7.setText("" + Hard_Lives7);
	}
	
	public void SubmitE() {
		// -------------------------------------------------------------------------------------------------------------------------------------------
		// Method                : SubmitE()
		// Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we verify if the user guess the correct number just for the easy level. 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/06/06               C.Sebastian                  Initial Setup
		// --------------------------------------------------------------------------------------------------------------------------------------------
		 int guess1 = Integer.parseInt(textField.getText());                 //We obtain the values from the user
		 int guess2 = Integer.parseInt(textField_2.getText());
		 int guess3 = Integer.parseInt(textField_3.getText());
		    
		 if (guess1 < 1 || guess1 > numberRange ||
			        guess2 < 1 || guess2 > numberRange ||
			        guess3 <1 || guess3 > numberRange) {
			        JOptionPane.showMessageDialog(null,"Por favor, ingrese solo números dentro del rango " + 1 + " - " + numberRange + ".");
			    }else {

		    if (guess1 == Integer.parseInt(lblguess.getText())) {           //if the guess is correct 
		    	lblScore.setText("SCORE: " + Score);
		    	textField.setEnabled(false);                                //We disable the button to prevent the user from typing in another number 
		    	lblMatch.setIcon(image.correct);                            //A green arrow will be displayed 
		        complete++;                                                 //We add + 1 to the variable 
		    }
		    if(guess1 >  Integer.parseInt(lblguess.getText())) {           //if the guess is grater than the number 
		    	lblLnumber.setText(textField.getText());
		    	textField.setText("");
		    	lblArrow.setIcon(image.arrowUp);                           //An arrow facing up will be displayed 
		    }
		    if(guess1 <  Integer.parseInt(lblguess.getText())) {           //if the guess is less than the number 
		    	lblLnumber.setText(textField.getText());
		    	textField.setText("");
		    	lblArrow.setIcon(image.arrowDown);                        //An arrow facing down will be displayed 
		    }
		    if(guess1 != Integer.parseInt(lblguess.getText())) {          //The number is not correct     
		    	lblMatch.setIcon(image.wrong);                            //A red "X" will be displayed  
		    	Easy_Lives -= 1;
		    	lives.setText("" + Easy_Lives);
		    }
		    
		   if (guess2 == Integer.parseInt(lblguess_2.getText())) {
			   lblScore.setText("SCORE: " + Score);
			   textField_2.setEnabled(false);
		    	lblMatch_2.setIcon(image.correct);
		    	complete++;
		    }
		   if(guess2 >  Integer.parseInt(lblguess_2.getText())) {
			   lblLnumber_2.setText(textField_2.getText());
			   textField_2.setText("");
			   lblArrow_2.setIcon(image.arrowUp);
		    }
		    if(guess2 <  Integer.parseInt(lblguess_2.getText())) {
		    	lblLnumber_2.setText(textField_2.getText());
		    	textField_2.setText("");
		    	lblArrow_2.setIcon(image.arrowDown);
		    }
		    if(guess2 != Integer.parseInt(lblguess_2.getText())) {
		    	lblMatch_2.setIcon(image.wrong);
		    	Easy_Lives2 -=1;
		    	lives_2.setText("" + Easy_Lives2);
		    }	    
			if (guess3 == Integer.parseInt(lblguess_3.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_3.setIcon(image.correct);
				 textField_3.setEnabled(false);
				complete++;
			}
			if (guess3 > Integer.parseInt(lblguess_3.getText())) {
				lblLnumber_3.setText(textField_3.getText());
				textField_3.setText("");
				lblArrow_3.setIcon(image.arrowUp);
			}
			if (guess3 < Integer.parseInt(lblguess_3.getText())) {
				lblLnumber_3.setText(textField_3.getText());
				textField_3.setText("");
				lblArrow_3.setIcon(image.arrowDown);
			}
			if (guess3 != Integer.parseInt(lblguess_3.getText())) {				
				lblMatch_3.setIcon(image.wrong);
		    	Easy_Lives3 -=1;
		    	lives_3.setText("" + Easy_Lives3);
			}
			if(Easy_Lives ==0 || Easy_Lives2 == 0|| Easy_Lives3 == 0) {                         //If the life is 0 in any of the tracks the player loses the game 
				JOptionPane.showMessageDialog(null, "YOU LOSE THE GAME");
				Splash main = new Splash();
				main.frmNumbercrunsher.setVisible(true);
				frame.dispose();					
			}
		if (complete == 3) {			                                                        //if complete is equals to 3 
			int totalLives = Easy_Lives + Easy_Lives2 + Easy_Lives3;  			                //We add all the lives to know the score
			Score = Score + (totalLives * 10);                                                  //Each attempt is worth 10 points.
			Score += Math.floor(totalLives / 3) * 50;                                           //For each group of 3 you get a bonus of 50 points
			lblScore.setText("SCORE: " + Score);                                                //We update the score label 
			Stage += 1;                                                                         //We increase the stage 
			Easy_Lives +=5;                                                                     //We increase the lives to 5 
			Easy_Lives2 +=5;
			Easy_Lives3 +=5;
			EASY_RANGE +=10; 
			lives.setText("" + Easy_Lives);
			lives_2.setText("" + Easy_Lives2);
			lives_3.setText("" + Easy_Lives3);
			lblStage.setText("STAGE: " + Stage);
			lblNumberRange.setText("NUMBER RANGE: " + EASY_RANGE );
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			lblLnumber.setText("");
			lblLnumber_2.setText("");
			lblLnumber_3.setText("");
			
			lblMatch.setIcon(null);                                                            //We clean all the icons
			lblMatch_2.setIcon(null);
			lblMatch_3.setIcon(null);
			lblArrow.setIcon(null);
			lblArrow_2.setIcon(null);
			lblArrow_3.setIcon(null);
			 
			textField.setEnabled(true);                                                        //We enable the text field
			textField_2.setEnabled(true);
			textField_3.setEnabled(true);
			
			generator.generateNumber(Levels.this, "easy");                                    //We generate other numbers
			if(EASY_RANGE > 90) {                                                             //If the range is grater than 90 we go to the medium level 
				Moderate(); 
				generator.generateNumber(Levels.this, "moderate");
				 easyButtonPressed = false;
				 mediumButtonPressed = true;
				 numberRange = 100;
			}
			saveUserInitials(name);                                                            //We save the data to according to the user initials 
		}
			    }
		System.out.print(complete);	
		complete = 0;
	 }
	public void SubmitM() {
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
	    // Method                : SubmitM()
	    // Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we verify if the user guess the correct number just for the medium level.We do the same actions as the easy level 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/06/06               C.Sebastian                  Initial Setup
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------------
		 int guess1 = Integer.parseInt(textField.getText());
		 int guess2 = Integer.parseInt(textField_2.getText());
		 int guess3 = Integer.parseInt(textField_3.getText());
		 int guess4 = Integer.parseInt(textField_4.getText());
		 int guess5 = Integer.parseInt(textField_5.getText());
		 
		 if (guess1 < 1 || guess1 > numberRange ||
			        guess2 < 1 || guess2 > numberRange ||
			        guess3 <1 || guess3 > numberRange ||
			        guess4 < 1 || guess4 > numberRange ||
			        guess5 < 1 || guess5 > numberRange) {
			        JOptionPane.showMessageDialog(null,"Por favor, ingrese solo números dentro del rango " + 1 + " - " + numberRange + ".");
			    }else {

		    if (guess1 == Integer.parseInt(lblguess.getText())) {
		    	lblScore.setText("SCORE: " + Score);
		    	textField.setEnabled(false);
		    	lblMatch.setIcon(image.correct);
		        complete++;
		    }
		    if(guess1 >  Integer.parseInt(lblguess.getText())) {
		    	lblLnumber.setText(textField.getText());
		    	textField.setText("");
		    	lblArrow.setIcon(image.arrowUp);
		    }
		    if(guess1 <  Integer.parseInt(lblguess.getText())) {
		    	lblLnumber.setText(textField.getText());
		    	textField.setText("");
		    	lblArrow.setIcon(image.arrowDown);
		    }
		    if(guess1 != Integer.parseInt(lblguess.getText())) {
		    	lblMatch.setIcon(image.wrong);
		    	Medium_Lives -= 1;
		    	lives.setText("" + Medium_Lives);
		    }
		    
		   if (guess2 == Integer.parseInt(lblguess_2.getText())) {
			   lblScore.setText("SCORE: " + Score);
			   textField_2.setEnabled(false);
		    	lblMatch_2.setIcon(image.correct);
		    	complete++;
		    }
		   if(guess2 >  Integer.parseInt(lblguess_2.getText())) {
			   lblLnumber_2.setText(textField_2.getText());
			   textField_2.setText("");
			   lblArrow_2.setIcon(image.arrowUp);
		    }
		    if(guess2 <  Integer.parseInt(lblguess_2.getText())) {
		    	lblLnumber_2.setText(textField_2.getText());
		    	textField_2.setText("");
		    	lblArrow_2.setIcon(image.arrowDown);
		    }
		    if(guess2 != Integer.parseInt(lblguess_2.getText())) {
		    	lblMatch_2.setIcon(image.wrong);
		    	Medium_Lives2 -=1;
		    	lives_2.setText("" + Medium_Lives2);
		    }	    
			if (guess3 == Integer.parseInt(lblguess_3.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_3.setIcon(image.correct);
				 textField_3.setEnabled(false);
				complete++;
			}
			if (guess3 > Integer.parseInt(lblguess_3.getText())) {
				lblLnumber_3.setText(textField_3.getText());
				textField_3.setText("");
				lblArrow_3.setIcon(image.arrowUp);
			}
			if (guess3 < Integer.parseInt(lblguess_3.getText())) {
				lblLnumber_3.setText(textField_3.getText());
				textField_3.setText("");
				lblArrow_3.setIcon(image.arrowDown);
			}
			if (guess3 != Integer.parseInt(lblguess_3.getText())) {				
				lblMatch_3.setIcon(image.wrong);
				Medium_Lives3 -=1;
		    	lives_3.setText("" + Medium_Lives3);
			}
			if (guess4 == Integer.parseInt(lblguess_4.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_4.setIcon(image.correct);
				 textField_4.setEnabled(false);
				complete++;
			}
			if (guess4 > Integer.parseInt(lblguess_4.getText())) {
				lblLnumber_4.setText(textField_4.getText());
				textField_4.setText("");
				lblArrow_4.setIcon(image.arrowUp);
			}
			if (guess4 < Integer.parseInt(lblguess_4.getText())) {
				lblLnumber_4.setText(textField_4.getText());
				textField_4.setText("");
				lblArrow_4.setIcon(image.arrowDown);
			}
			if (guess4 != Integer.parseInt(lblguess_4.getText())) {				
				lblMatch_4.setIcon(image.wrong);
				Medium_Lives4 -=1;
		    	lives_4.setText("" + Medium_Lives4);
			}
			if (guess5 == Integer.parseInt(lblguess_5.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_5.setIcon(image.correct);
				 textField_5.setEnabled(false);
				complete++;
			}
			if (guess5 > Integer.parseInt(lblguess_5.getText())) {
				lblLnumber_5.setText(textField_5.getText());
				textField_5.setText("");
				lblArrow_5.setIcon(image.arrowUp);
			}
			if (guess5 < Integer.parseInt(lblguess_5.getText())) {
				lblLnumber_5.setText(textField_5.getText());
				textField_5.setText("");
				lblArrow_5.setIcon(image.arrowDown);
			}
			if (guess5 != Integer.parseInt(lblguess_5.getText())) {				
				lblMatch_5.setIcon(image.wrong);
				Medium_Lives5 -=1;
		    	lives_5.setText("" + Medium_Lives5);
			}
			if(Medium_Lives==0||Medium_Lives2==0|| Medium_Lives3==0||Medium_Lives4==0||Medium_Lives5==0) {         //If the life is 0 in any of the tracks the player loses the game 
				JOptionPane.showMessageDialog(null, "YOU LOSE THE GAME");
				Splash main = new Splash();
				main.frmNumbercrunsher.setVisible(true);
				frame.dispose();					
			}
		if (complete == 5) {		
			int totalLives = Medium_Lives + Medium_Lives2 + Medium_Lives3 + Medium_Lives4 + Medium_Lives5;  			
			Score = Score + (totalLives * 10);
			Score += Math.floor(totalLives / 3) * 50;
			lblScore.setText("SCORE: " + Score);
			
			Stage += 1;
			Medium_Lives +=7;
			Medium_Lives2 +=7;
			Medium_Lives3 +=7;
			Medium_Lives4 +=7;
			Medium_Lives5 +=7;
			MEDIUM_RANGE +=100; 
			lives.setText("" + Medium_Lives);
			lives_2.setText("" + Medium_Lives2);
			lives_3.setText("" + Medium_Lives3);
			lives_4.setText("" + Medium_Lives4);
			lives_5.setText("" + Medium_Lives5);
			lblStage.setText("STAGE: " + Stage);
			lblNumberRange.setText("NUMBER RANGE: " + MEDIUM_RANGE );
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			lblLnumber.setText("");
			lblLnumber_2.setText("");
			lblLnumber_3.setText("");
			lblLnumber_4.setText("");
			lblLnumber_5.setText("");
			
			textField.setEnabled(true);
			textField_2.setEnabled(true);
			textField_3.setEnabled(true);
			textField_4.setEnabled(true);
			textField_5.setEnabled(true);
			
			lblMatch.setIcon(null);
			lblMatch_2.setIcon(null);
			lblMatch_3.setIcon(null);
			lblMatch_4.setIcon(null);
			lblMatch_5.setIcon(null);
			lblArrow.setIcon(null);
			lblArrow_2.setIcon(null);
			lblArrow_3.setIcon(null);
			lblArrow_4.setIcon(null);
			lblArrow_5.setIcon(null);
			
			generator.generateNumber(Levels.this, "moderate");
						
			if(MEDIUM_RANGE > 900) {                                                                         //If the range is more than 900 we go to the Hard level                              
				Difficult();
				generator.generateNumber(Levels.this, "difficult");
				mediumButtonPressed = false;	
				hardButtonPressed = true;
				numberRange = 1000;
			}
			saveUserInitials(name);
		}
			    }
		System.out.print(complete);	
		complete = 0;
	 }
	public void SubmitH() {
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
	    // Method                : SubmitH()
	    // Method Parameters     : none
		// Method return         : none
		// Synopsis              :In this method we verify if the user guess the correct number just for the hard level.We do the same actions as the easy level 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/06/06               C.Sebastian                  Initial Setup
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------------
		 int guess1 = Integer.parseInt(textField.getText());
		 int guess2 = Integer.parseInt(textField_2.getText());
		 int guess3 = Integer.parseInt(textField_3.getText());
		 int guess4 = Integer.parseInt(textField_4.getText());
		 int guess5 = Integer.parseInt(textField_5.getText());
		 int guess6 = Integer.parseInt(textField_6.getText());
		 int guess7 = Integer.parseInt(textField_7.getText());

		    if (guess1 == Integer.parseInt(lblguess.getText())) {
		    	lblScore.setText("SCORE: " + Score);
		    	textField.setEnabled(false);
		    	lblMatch.setIcon(image.correct);
		        complete++;
		    }
		    if(guess1 >  Integer.parseInt(lblguess.getText())) {
		    	lblLnumber.setText(textField.getText());
		    	textField.setText("");
		    	lblArrow.setIcon(image.arrowUp);
		    }
		    if(guess1 <  Integer.parseInt(lblguess.getText())) {
		    	lblLnumber.setText(textField.getText());
		    	textField.setText("");
		    	lblArrow.setIcon(image.arrowDown);
		    }
		    if(guess1 != Integer.parseInt(lblguess.getText())) {
		    	lblMatch.setIcon(image.wrong);
		    	Hard_Lives -= 1;
		    	lives.setText("" + Hard_Lives);
		    }
		    
		   if (guess2 == Integer.parseInt(lblguess_2.getText())) {
			   lblScore.setText("SCORE: " + Score);
			   textField_2.setEnabled(false);
		    	lblMatch_2.setIcon(image.correct);
		    	complete++;
		    }
		   if(guess2 >  Integer.parseInt(lblguess_2.getText())) {
			   lblLnumber_2.setText(textField_2.getText());
			   textField_2.setText("");
			   lblArrow_2.setIcon(image.arrowUp);
		    }
		    if(guess2 <  Integer.parseInt(lblguess_2.getText())) {
		    	lblLnumber_2.setText(textField_2.getText());
		    	textField_2.setText("");
		    	lblArrow_2.setIcon(image.arrowDown);
		    }
		    if(guess2 != Integer.parseInt(lblguess_2.getText())) {
		    	lblMatch_2.setIcon(image.wrong);
		    	Hard_Lives2 -=1;
		    	lives_2.setText("" + Hard_Lives2);
		    }	    
			if (guess3 == Integer.parseInt(lblguess_3.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_3.setIcon(image.correct);
				 textField_3.setEnabled(false);
				complete++;
			}
			if (guess3 > Integer.parseInt(lblguess_3.getText())) {
				lblLnumber_3.setText(textField_3.getText());
				textField_3.setText("");
				lblArrow_3.setIcon(image.arrowUp);
			}
			if (guess3 < Integer.parseInt(lblguess_3.getText())) {
				lblLnumber_3.setText(textField_3.getText());
				textField_3.setText("");
				lblArrow_3.setIcon(image.arrowDown);
			}
			if (guess3 != Integer.parseInt(lblguess_3.getText())) {				
				lblMatch_3.setIcon(image.wrong);
				Hard_Lives3 -=1;
		    	lives_3.setText("" + Hard_Lives3);
			}
			if (guess4 == Integer.parseInt(lblguess_4.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_4.setIcon(image.correct);
				 textField_4.setEnabled(false);
				complete++;
			}
			if (guess4 > Integer.parseInt(lblguess_4.getText())) {
				lblLnumber_4.setText(textField_4.getText());
				textField_4.setText("");
				lblArrow_4.setIcon(image.arrowUp);
			}
			if (guess4 < Integer.parseInt(lblguess_4.getText())) {
				lblLnumber_4.setText(textField_4.getText());
				textField_4.setText("");
				lblArrow_4.setIcon(image.arrowDown);
			}
			if (guess4 != Integer.parseInt(lblguess_4.getText())) {				
				lblMatch_4.setIcon(image.wrong);
				Hard_Lives4 -=1;
		    	lives_4.setText("" + Hard_Lives4);
			}
			if (guess5 == Integer.parseInt(lblguess_5.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_5.setIcon(image.correct);
				 textField_5.setEnabled(false);
				complete++;
			}
			if (guess5 > Integer.parseInt(lblguess_5.getText())) {
				lblLnumber_5.setText(textField_5.getText());
				textField_5.setText("");
				lblArrow_5.setIcon(image.arrowUp);
			}
			if (guess5 < Integer.parseInt(lblguess_5.getText())) {
				lblLnumber_5.setText(textField_5.getText());
				textField_5.setText("");
				lblArrow_5.setIcon(image.arrowDown);
			}
			if (guess5 != Integer.parseInt(lblguess_5.getText())) {				
				lblMatch_5.setIcon(image.wrong);
				Hard_Lives5 -=1;
		    	lives_5.setText("" + Hard_Lives5);
			}
			if (guess6 == Integer.parseInt(lblguess_6.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_6.setIcon(image.correct);
				 textField_6.setEnabled(false);
				complete++;
			}
			if (guess6 > Integer.parseInt(lblguess_6.getText())) {
				lblLnumber_6.setText(textField_6.getText());
				textField_6.setText("");
				lblArrow_6.setIcon(image.arrowUp);
			}
			if (guess6 < Integer.parseInt(lblguess_6.getText())) {
				lblLnumber_6.setText(textField_6.getText());
				textField_6.setText("");
				lblArrow_6.setIcon(image.arrowDown);
			}
			if (guess6 != Integer.parseInt(lblguess_6.getText())) {				
				lblMatch_6.setIcon(image.wrong);
				Hard_Lives6 -=1;
		    	lives_6.setText("" + Hard_Lives6);
			}
			if (guess7 == Integer.parseInt(lblguess_7.getText())) {
				lblScore.setText("SCORE: " + Score);
				lblMatch_7.setIcon(image.correct);
				 textField_7.setEnabled(false);
				complete++;
			}
			if (guess7 > Integer.parseInt(lblguess_7.getText())) {
				lblLnumber_7.setText(textField_7.getText());
				textField_7.setText("");
				lblArrow_7.setIcon(image.arrowUp);
			}
			if (guess7 < Integer.parseInt(lblguess_7.getText())) {
				lblLnumber_7.setText(textField_7.getText());
				textField_7.setText("");
				lblArrow_7.setIcon(image.arrowDown);
			}
			if (guess7 != Integer.parseInt(lblguess_7.getText())) {				
				lblMatch_7.setIcon(image.wrong);
				Hard_Lives7 -=1;
		    	lives_7.setText("" + Hard_Lives7);
			}
			if(Hard_Lives==0||Hard_Lives2==0|| Hard_Lives3==0||Hard_Lives4==0||Hard_Lives5==0||Hard_Lives6==0||Hard_Lives7==0) {  //If the life is 0 in any of the tracks the player loses the game
				JOptionPane.showMessageDialog(null, "YOU LOSE THE GAME");
				Splash main = new Splash();
				main.frmNumbercrunsher.setVisible(true);
				frame.dispose();					
			}
		if (complete == 7) {		
			int totalLives = Hard_Lives + Hard_Lives2 + Hard_Lives3 + Hard_Lives4 + Hard_Lives5 + Hard_Lives6 + Hard_Lives7;  			
			Score = Score + (totalLives * 10);
			Score += Math.floor(totalLives / 3) * 50;
			lblScore.setText("SCORE: " + Score);
			
			Stage += 1;
			Hard_Lives+=11;
			Hard_Lives+=11;
			Hard_Lives+=11;
			Hard_Lives+=11;
			Hard_Lives+=11;
			Hard_Lives+=11;
			Hard_Lives+=11;
			DIFFICULT_RANGE +=1000; 
			lives.setText("" + Hard_Lives);
			lives_2.setText("" + Hard_Lives2);
			lives_3.setText("" + Hard_Lives3);
			lives_4.setText("" + Hard_Lives4);
			lives_5.setText("" + Hard_Lives5);
			lives_6.setText("" + Hard_Lives6);
			lives_7.setText("" + Hard_Lives7);
			lblStage.setText("STAGE: " + Stage);
			lblNumberRange.setText("NUMBER RANGE: " + DIFFICULT_RANGE );
			textField.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			lblLnumber.setText("");
			lblLnumber_2.setText("");
			lblLnumber_3.setText("");
			lblLnumber_4.setText("");
			lblLnumber_5.setText("");
			lblLnumber_6.setText("");
			lblLnumber_7.setText("");
			
			textField.setEnabled(true);
			textField_2.setEnabled(true);
			textField_3.setEnabled(true);
			textField_4.setEnabled(true);
			textField_5.setEnabled(true);
			textField_6.setEnabled(true);
			textField_7.setEnabled(true);
			
			lblMatch.setIcon(null);
			lblMatch_2.setIcon(null);
			lblMatch_3.setIcon(null);
			lblMatch_4.setIcon(null);
			lblMatch_5.setIcon(null);
			lblMatch_6.setIcon(null);
			lblMatch_7.setIcon(null);
			lblArrow.setIcon(null);
			lblArrow_2.setIcon(null);
			lblArrow_3.setIcon(null);
			lblArrow_4.setIcon(null);
			lblArrow_5.setIcon(null);
			lblArrow_6.setIcon(null);
			lblArrow_7.setIcon(null);
	
			generator.generateNumber(Levels.this, "difficult");
			
			if(DIFFICULT_RANGE > 9000) {
				JOptionPane.showMessageDialog(null, "YOU WIN THE GAME, CONGRATS!!!");                      //If the range is more than 9000 the player wins the game 
				Splash main = new Splash();
				main.frmNumbercrunsher.setVisible(true);
				frame.dispose();					
			}
			saveUserInitials(name);
		}
		System.out.print(complete);	
		complete = 0;
	 }
	
	public void saveUserInitials(String userInput) {  
		// --------------------------------------------------------------------------------------------------------------------------------------------------------------
	    // Method                : saveUserInitials(String userInput)
	    // Method Parameters     : String userInput : will be the user's initials.
		// Method return         : none
		// Synopsis              :In this method we are going to write the user's data in the file 
		//
		// Modifications :             Author:                        Notes:
		//     Date:
		//   2023/06/06               C.Sebastian                  Initial Setup
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------------
	    	                                                                                                        
	        try {                                                                                                   
	        	writer = new FileWriter(name +".txt", false);                                               //depending on the initials that the user enters, a new .txt file will be created.
		        if(easyButtonPressed) {
	        	writer.write(userInput + "," + Stage + "," + numberRange + ",easy," + Score + "," + Easy_Lives + "," + Easy_Lives2 + "," + Easy_Lives3 );                    
		        }else if(mediumButtonPressed) {
		        	writer.write(userInput + "," + Stage + "," + numberRange + ",medium," + Score + "," + Medium_Lives+ "," + Medium_Lives2+ "," + Medium_Lives3+ "," + Medium_Lives4+ "," + Medium_Lives5 );
		        }else {
		        	writer.write(userInput + "," + Stage + "," + numberRange + ",hard," + Score + "," + Hard_Lives + "," + Hard_Lives2 + "," + Hard_Lives3 +  "," + Hard_Lives4 + "," + Hard_Lives5 + "," + Hard_Lives6 + "," + Hard_Lives7);
		        }
	        	writer.close();                                                                                    
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	}